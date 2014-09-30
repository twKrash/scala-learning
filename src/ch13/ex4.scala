package ch13

import ch13.lect._

object ex4 extends App {

  def test(a: Array[String], b: Map[String, Int]) = a.toList.map(b.get).flatMap(x => x)

  val a = Array("Tom", "Fred", "Harry")
  val b = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
  time {
    println(test(a, b))
  }
}
