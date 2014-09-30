package ch13

object lect extends App {

  //  def digits(n: Int): Set[Int] = {
  //    if (n < 0) digits(-n)
  //    else if (n < 10) digits(n)
  //    else digits(n / 10) + (n % 10)
  //  }

  def sum(lst: List[Int]): Int = {
    if (lst == Nil) 0 else lst.head + sum(lst.tail)
  }

  def sum2(lst: List[Int]): Int = {
    lst match {
      case Nil => 0
      case h :: t => h + sum(t)
    }
  }

  println(sum(List(1, 2, 3, 4, 5, 6)), sum2(List(1, 2, 3, 4, 5, 6)), List(1, 2, 3, 4, 5, 6).sum)

  val primes = Set(2, 3, 5, 7)
  val digits = Set(1, 7, 2, 9)
  println(digits contains 0)
  println(Set(1, 2) subsetOf digits)
  println(digits union primes, digits & primes, digits &~ primes)


  println(Vector(1, 2, 3) :+ 4)
  println(1 +: Vector(2, 3))


  def ulcase(s: String) = Vector(s.toUpperCase, s.toLowerCase)

  val names = List("Peter", "Paul", "Mary")

  println(names.map(ulcase), names.flatMap(ulcase))
  val qwe = (0 /: (List(1, 2, 3, 4) :+ 5))(_ - _)
  println(qwe)

  def getFreq(s: String) = {
    (Map[Char, Int]() /: s) {
      (m, c) => {
        val d = c.toLower
        m + (d -> (m.getOrElse(d, 0) + 1))
      }
    }
  }

  val asd = (Map[Char, Int]() /: "Mississippi") { (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))}
  val asd2 = "Mississippi".foldLeft(Map[Char, Int]()) {
    (m: Map[Char, Int], c: Char) => {
      m + (c -> (m.getOrElse(c, 0) + 1))
    }
  }
  println(asd, getFreq("Heello! This is me speaking! Lets try a big strings!"))

  val prices = List(5.0, 20.0, 9.95)
  val qtys = List(10, 2, 1)
  println((prices zip qtys map { p => p._1 * p._2}) sum)

  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

  println(numsFrom(10).tail.tail.tail)

  val squares = numsFrom(1).map(x => x * x)
  println(squares.take(5).force)

  def time[R](block: => R, name: String = "unknown"): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("[" + name + "]: Elapsed time: " + (t1 - t0) + "ns")
    result
  }

}
