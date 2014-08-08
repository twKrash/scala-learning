package random


class Rnd {

  println("rnd init")
  private var _next: Double = 1
  private var _previous: Double = 1

  def nextInt(): Int = {
    compose
    _next.toInt
  }

  def nextDouble(): Double = {
    compose
    _next
  }

  private def compose = {
    _next = (_previous * getA + getB) % math.pow(2, getN)
    _previous = _next
  }


  def setSeed(seed: Int): Unit = {
    _previous = seed.toDouble
  }
}

object Rnd {
  def apply = new Rnd

  //  def setSeed(seed: Int) = _setSeed(seed)
}