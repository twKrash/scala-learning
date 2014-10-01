package ch14

object ex3 extends App{
  def swap(x:Array[Int]): Array[Int] ={
    x match {
      case Array(a,b, rest @ _*) => Array(b,a) ++ rest
      case _ => x
    }
  }
  println(swap(Array(1)).deep, swap(Array(1,2)).deep, swap(Array(1,2,3)).deep)
}
