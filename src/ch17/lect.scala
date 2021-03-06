package ch17


object lect extends App {

  class Pair[T, S](first: T, second: S)

  class Pair2[T <% Ordered[T]](first: T, second: T) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }

  class Pair22[T: Ordering](first: T, second: T) {
    def smaller(implicit ord: Ordering[T]) = if (ord.compare(first, second) < 0) first else second
  }

  class Pair3[T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair3[R](newFirst, second)
  }

  class Pair4[T](val first: T, val second: T) {
    def smaller(implicit ev: T <:< Ordered[T]) = if (first < second) first else second
  }

  def makePair[T: Manifest](first: T, second: T) = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }


  val p1 = new Pair[Any, Any](42, "String")
  println(p1)

  def getMiddle[T](a: Array[T]) = a(a.length / 2)

  println(getMiddle(Array("Marry", "had", "a", "little", "lamb")))
  val f = getMiddle[Int] _
  println(f(Array(1, 2, 3, 4, 5)))

  val pair = new Pair2("abc", "bcd")
  println(pair.smaller)
  val pairInt = new Pair2(2, 3)
  println(pairInt.smaller)

  println(makePair(1, 2))


  val friends = Map("Fred" -> "Barney")
  val friendOpt = friends.get("Wilma")
  val friendOrNull = friendOpt.orNull // Null <:< A

  //  def firstLast[A, C <:Iterable[A]](it:C) = (it.head,it.last) //Wrong
  def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) = (it.head, it.last) //Correct with curring
  println(firstLast(List(1, 2, 3)))

  //  def corresponds[B](that: Seq[B])(m: (A,B) => Boolean):Boolean = {...}


  object MySimpleHelper {

    implicit class StringExtended(str: String) {
      def sayIt = println(str)

      def sayItLouderBitch = println(str.toUpperCase + "!!!")
    }

  }

  import ch17.lect.MySimpleHelper._

  "oh gosh".sayIt

  "oh gosh".sayItLouderBitch

  implicit val myValue: Int = 5

  object Jules {
    def doesHeLookLikeABitch(answer: String)(implicit times: Int) = {
      println(times)
      for (x <- 1 to times) println(answer)
    }
  }

  Jules.doesHeLookLikeABitch("WHAT?")

  implicit val timeFuncName: String = "unknown"

  object bench {
    def time[R](block: => R)(implicit name: String): R = {
      val t0 = System.nanoTime()
      val result = block // call-by-name
      val t1 = System.nanoTime()
      println("[" + name + "]: Elapsed time: " + (t1 - t0) + "ns")
      result
    }

    def memory[R](block: => R)(implicit name: String): R = {
      val m0 = Runtime.getRuntime.totalMemory()
      val result = block // call-by-name
      val m1 = Runtime.getRuntime.freeMemory()
      println("[" + name + "]: Memory taken: " + (m0 - m1) + "")
      result
    }
  }

  import ch17.lect.bench._

  memory {
    println("asd")
  }

  time {
    println("asd")
  }

}
