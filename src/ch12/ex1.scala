package ch12


object ex1 extends App {
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    (low to high) map { (x) => (x, fun(x))}
  }

  println(values(x => x * x, -5, 5))
}
