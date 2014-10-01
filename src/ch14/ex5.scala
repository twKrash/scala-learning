package ch14

object ex5 extends App {
  def leafSum(l: List[Any]): Int = {
    (for (elem <- l) yield elem match {
      case a: List[Int] => leafSum(a)
      case a: Int => a
      case _ => 0
    }).sum
  }

  val x = List(List(3, 8), 2, List(5))
  println(x, leafSum(x))
}
