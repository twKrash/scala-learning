package ch15

import scala.annotation.tailrec
import scala.util.control.TailCalls._


object lect extends App {

  @tailrec def sum(xs: Seq[Int], partial: BigInt): BigInt =
    if (xs.isEmpty) partial else sum(xs.tail, xs.head + partial)

  def evenLength(xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(oddLength(xs.tail))

  def oddLength(xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(evenLength(xs.tail))

  println(sum(1 to 1000000, 0))

  println(evenLength(1 to 1000000).result)

  def fib(n: Int): TailRec[Int] = {
    if (n < 2) done(n)
    else {
      val storeX = tailcall(fib(n - 1))
      val storeY = tailcall(fib(n - 2))
      done(storeX.result + storeY.result)
    }
    //
    //          for {
    //          x <- tailcall(fib(n - 1))
    //          y <- tailcall(fib(n - 2))
    //        } yield (x + y)
  }

  def fac(n: Long): TailRec[Long] =
    if (n == 0) done(1) else done(n * tailcall(fac(n - 1)).result)

  println(fac(12).result)
  println("result:" + fib(5).result)


  object BooleanHolder {
    @volatile var value: Boolean = false
//    var value: Boolean = false
  }

  spawn {
    Thread.sleep(5100)
    BooleanHolder.value = true
    println("Thread1: setting value to TRUE!")
  }

  spawn {
//        while (!BooleanHolder.value) {println("wating");Thread.sleep(20)}
    def ch():Unit = {
      if (!BooleanHolder.value) {
        println("wating")
        Thread.sleep(1000)
        ch()
      } else println("Thread2: value is TRUE!")
    }
    ch()
  }

  def spawn[T](block: => T) = {
    new Thread {
      tr =>
      override def run() {
        block
      }
    }.start()
  }
}
