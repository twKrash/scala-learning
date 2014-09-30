package ch13

import ch13.lect.time

import scala.collection.mutable

object ex10 extends App {

  time {
    val files = List("1.txt", "2.txt", "3.txt", "4.txt", "5.txt")
    val frequences = new mutable.HashMap[Char, Int] with mutable.SynchronizedMap[Char, Int]

    for (file <- files.par) {
      println("Reading file : " + file)
      val source = scala.io.Source.fromFile("/Users/krash/" + file)
      val lines = source.mkString
      for (c <- lines) frequences(c) = frequences.getOrElse(c, 0) + 1
      source.close()
    }
    println(frequences)
  }
  val str = scala.io.Source.fromFile("/Users/krash/5.txt").mkString
  time({
    import scala.collection.immutable

    //    val frequences = new mutable.HashMap[Char, Int]
    //    for (c <- str.par) frequences(c) = frequences.getOrElse(c, 0) + 1
    //    println(frequences)

    val frequences = str.par.aggregate(new immutable.HashMap[Char, Int])(
      (x, c) => x + (c -> (x.getOrElse(c, 0) + 1)),
      (map1, map2) => map1 ++: map2.map { case (k, v) => k -> (v + map1.getOrElse(k, 0))}
    )

    println(frequences.toSeq.sorted)

  }, "parralel")

  time({
    val freq = str.map(c => (c, 1)).groupBy(_._1).map(x => (x._1, x._2.length))
    println(freq.seq.toSeq.sorted)
  }, "immutable")

  time({
    val freq = new collection.mutable.HashMap[Char, Int]
    for (c <- str) freq(c) = freq.getOrElse(c, 0) + 1
    println(freq.toSeq.sorted)
  }, "mutable")

}
