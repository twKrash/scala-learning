package ch13

import ch13.lect.time

object ex8 extends App {
  def test(a: Array[Int], n: Int) = a.grouped(n).toArray.map(_.toArray)

  time({
    println(test(Array(1, 2, 3, 4, 5), 1).deep.mkString(", "))
  }, "test")
}
