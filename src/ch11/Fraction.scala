package ch11

import hplrs._


class Frac(n: Int, d: Int) {
  private val _num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val _den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def *(other: Frac) = new Frac(_num * other._num, _den * other._den)

  def +(other: Frac) = new Frac(_num + other._num, _den + other._den)

  def -(other: Frac) = new Frac(_num - other._num, _den - other._den)

  def /(other: Frac) = new Frac(_num / other._num, _den / other._den)

  override def toString = _num.toString + "/" + _den.toString

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) Math.abs(a) else gcd(b, a % b)
}

object Frac {
  def apply(n: Int, d: Int) = new Frac(n, d)

  def unapply(in: Frac) = {
    if (in._den == 0) None
    else Some((in._num, in._den))
  }
}

object Fraction extends App with ConsoleLogger with TimestampLogger {
  println(Frac(15, -6))
  println(Frac(1, 2) * Frac(2, 3))
  println(Frac(1, 2) + Frac(2, 3))
  println(Frac(1, 2) - Frac(2, 3))
  println(Frac(1, 2) / Frac(2, 3))

}
