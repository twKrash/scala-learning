package ch12

object ex2 extends App{
  println(Array(1,2,3,9,12,4,5,3,123,7).reduceLeft(Math.max))
}
