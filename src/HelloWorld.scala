package helloworld

import scala.collection.mutable.ArrayBuffer

/**
 * Created by krash on 02.08.2014.
 */

case class User(name: String, address: String) {

}


object HelloWorld extends App {
  val a1 = User("qwe","Pr.of peace")

  a1 match{
    case User(name,addr) => println(name + " " + addr)
  }



  def countdown(n: Int) {
    for (i <- n to 0 by -1) {
      println(i)
    }
  }

  def product(s: String): Long = {
    val sum: Long = if (s.tail.length > 0) s.head.toInt * product(s.tail) else s.head
    sum
  }

  def product2(s: String) = {
    s.toList.map(_.toInt).foldLeft(1) { (prod: Int, current: Int) => prod * current}
  }

  println(product2("Hello"))

  def productCheck(s: String): Long = {
    s.foldLeft(1L)(_ * _.toInt)
  }

  val str: String = "Hello"
  if (product(str) == productCheck(str)) {
    println("matched")
  } else {
    println("error")
  }

  println(product(str))

  import scala.math._

  def func(x: Double, n: Int): Double = {
    val res: Double = {
      //Zero
      if (n == 0) {
        1
      } else if (n > 0) {
        //Positive
        if (isEven(n)) {
          pow(pow(x, n / 2), 2) //Even
        } else {
          x * pow(x, n - 1) //Odd
        }
      } else {
        //Negative
        1 / pow(x, -n)
      }
    }
    res
  }

  def func2(x: Double, n: Int): Double = {
    if (n == 0) {
      1
    } else if (n < 0) {
      1 / func2(x, -n)
    } else {
      if (n % 2 == 0) {
        val res = func2(x, n / 2)
        res * res
      } else {
        x * func2(x, n - 1)
      }
    }
  }

  def isEven(n: Int): Boolean = {
    (n / 2) * 2 == n
  }

  println(func(1, 0))
  println(func(2, 2))
  println(func(2, 3))
  println(func(2, -1))

  println(func2(1, 0))
  println(func2(2, 2))
  println(func2(2, 3))
  println(func2(2, -1))

  val test = ArrayBuffer(1, 2, 3, -1, 4, 5, -2, -3, 6, 0)
  //Удалить все отрицательные кроме первого
  var a = test.clone()
  println(a)
  var first = true
  var indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
    if (a(i) < 0) first = false; i
  }

  for (j <- 0 until indexes.length) a(j) = a(indexes(j))
  a.trimEnd(a.length - indexes.length)
  println(a)

  def firstNeg(list: List[Int]): List[Int] = {
    def tailFirstNeg(list: List[Int], acc: List[Int], flag: Boolean = false): List[Int] = {
      (list, flag) match {
        case (Nil, _) => acc
        case (head :: tail, _) if head >= 0 => tailFirstNeg(tail, head :: acc, flag)
        case (head :: tail, false) if head < 0 => tailFirstNeg(tail, head :: acc, true)
        case (head :: tail, true) if head < 0 => tailFirstNeg(tail, acc, true)
      }
    }
    tailFirstNeg(list, List()).reverse
  }

  println(firstNeg(test.toList).mkString("<", " , ", ">"))

  def one(n: Int) {
    println((0 until n).toArray.mkString(" , "))
  }

  one(15)

  def changeNearest(array: Array[Int]) {

    val buf = for (i <- 0 until array.length by 2; j <- (0 to 1).reverse) yield {
      if (i < array.length - 1) {
        array(i + j)
      } else array(i)
    }
    val result = buf.toBuffer
    result.trimEnd(1)
    println(result.mkString(" , "))
  }

  def changeNearest2(array: List[Int]): List[Int] = {
    array match {
      case x :: b :: Nil => b :: x :: Nil
      case x :: Nil => x :: Nil
      case x :: b :: tail => b :: x :: changeNearest2(tail)
    }
  }

  def changeNearest3(array: List[Int]): List[Int] = {
    def kakhochesh(array: List[Int], acc: List[Int]): List[Int] = {
      array match {
        case x :: b :: Nil => x :: b :: acc
        case x :: Nil => x :: acc
        case x :: b :: tail => kakhochesh(tail, x :: b :: acc)
      }
    }
    kakhochesh(array, List()).reverse

  }


  changeNearest(Array(1, 2, 3, 4, 5))
  println(changeNearest2(List(1, 2, 3, 4, 5)).toString())
  println(changeNearest3(List(1, 2, 3, 4, 5)).toString())

  //  changeNearest2(Array(1, 2, 3, 4, 5))

  def posOrder(arr: ArrayBuffer[Int]) = {
    {
      arr.filter {
        _ > 0
      } ++ arr.filter {
        _ <= 0
      }
    }
  }

  def posOrder2(arr: ArrayBuffer[Int]): String = {
    arr.groupBy(_ < 0).values.flatMap(x => x).toString()

  }

  println(posOrder(test).toString)
  println(posOrder2(test))

  val tz = java.util.TimeZone.getAvailableIDs.filter(_.startsWith("Europe/")).sorted
  println(tz.mkString(" , "))

  val in = new java.util.Scanner(new java.io.File("/Users/krash/ios_broken.csv"))
  val words = new scala.collection.mutable.HashMap[String, Int]
  while (in.hasNext) {
    val word = in.next()
    words(word) = words.getOrElse(word, 0) + 1
  }
  //  for((k,v) <- words) {
  //    println(k + " " + v)
  //  }
  //  println(words.toString)


  //  import java.awt.datatransfer._
  //  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf(SystemFlavorMap)
  //  val qwe = getNativesForFlavor(DataFlavor.imageFlavor)
  //  println(qwe)
}