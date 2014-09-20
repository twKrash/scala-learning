package ch12

object ex6 extends App {
  def largestAt(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs reduceLeft { (x, y) => if (fun(x) > fun(y)) x else y}
  }

  println(largestAt(x => 10 * x - x * x, 1 to 10))
}
