package ch14

object ex2 extends App {

  print(swap((3, 4)))

  def swap(x: (Int, Int)) = {
    x match {
      case (a, b) => (b: Int, a: Int)
      case _ => ()
    }
  }
}
