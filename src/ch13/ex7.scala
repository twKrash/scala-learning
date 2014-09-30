package ch13

import ch13.lect.time

object ex7 extends App {
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)


  time {
    val sum = (prices, quantities).zipped map {
      _ * _
    }
    println(sum)
  }

  time {
    val subtotal = ((x: Double, y: Int) => x * y).tupled
    val sum = (prices zip quantities) map {
      subtotal
    }

    println(sum)
  }
}
