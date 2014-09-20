package ch12

object ex3 extends App{
  def fact1(n: Int) = if (n < 1) 1 else (1 to n).reduceLeft(_ * _)

  def fact2(n: Int) = if (n < 1) 1 else (1 to n).product

  def fact3(n:Int) = (1 to Math.max(1,n)).foldLeft(1)(_ * _)


  println(fact1(5), fact2(-5), fact3(-5))
}
