package ch13


import ch13.lect.time

object ex1 extends App {

  def indexes(s: String) = {
    val zips = s.zipWithIndex
    (Map[Char, List[Any]]() /: s) {
      (m, c) => {
        //        m + (c -> m.getOrElse(c, zips.filter(_._1 == c).toList.map(_._2)))
        m + (c -> zips.filter(_._1 == c).toList.map(_._2))
        //        m + (c -> zips.foldLeft(List[Int]())((a, b) => {
        //          if (b._1 == s) a ++ List(b._2) else a
        //        }))

      }
    }
  }

  def indexes2(s: String) = {
    val res = collection.mutable.HashMap[Char, collection.mutable.LinkedHashSet[Int]]()
    for ((c, i) <- s.zipWithIndex) {
      val set = res.getOrElse(c, collection.mutable.LinkedHashSet[Int]())
      res(c) = set + i
    }
    res
  }

  def indexes3(s: String) =
    s.zipWithIndex.groupBy(_._1).map(x => (x._1, x._2.map(_._2).toList))

  time({
    println(indexes("Mississippi"))
  })
  time {
    println(indexes3("Mississippi"))
  }
  time {
    println(indexes2("Mississippi"))
  }
}
