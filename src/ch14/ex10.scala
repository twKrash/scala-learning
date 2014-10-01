package ch14

import scala.math.sqrt

object ex10 extends App {

  def compose(a: Double => Option[Double], b: Double => Option[Double]) = {
    (x: Double) => a(x) match {
      case Some(y) => b(y)
      case None => None
    }
  }

  type T = Double => Option[Double]

  def compose2(f: T, g: T): T = {
    (x: Double) => f(x) match {
      case Some(y) => g(y)
      case None => None
    }
  }


  def f(x: Double) = if (x > 0) Some(sqrt(x)) else None

  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

  val h = compose(f, g)
  val j = compose2(f, g)

  println(h(4))
  println(h(1))
  println(h(0))
  println(j(4), j(1), j(0))
}
