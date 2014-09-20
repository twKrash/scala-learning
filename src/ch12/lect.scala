package ch12


object lect extends App {

  val test = Array(3.14, 1.42, 2.0) map { (x: Double) => 3 * x}
  println(test.mkString(" "))

  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

  println(valueAtOneQuarter(scala.math.ceil))
  println(valueAtOneQuarter(scala.math.sqrt))
  println(valueAtOneQuarter(3 * _))

  def mulBy(factor: Double) = (x: Double) => factor * x // (Double) => ((Double) => Double )

  val quantiple = mulBy(5)
  println(quantiple(20))

  //val fun = 3 * _ //will cause an error
  val fun = 3 * (_: Double)
  // Ok
  val fun2: (Double) => Double = 3 * _ // Ok


  def mulAtOneTime(x: Int) = (y: Int) => x * y

  def mulAtOneTime2(x: Int)(y: Int) = x * y


  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  println(a.corresponds(b)(_.equals(_)))
  println(a.corresponds(b)(_.equalsIgnoreCase(_)))

  def runInThread(block: => Unit) = {
    new Thread {
      override def run() {
        block
      }
    }.start()
  }

  runInThread {
    println("Hi")
    Thread.sleep(1000)
    println("Bye!")
  }

  println("end")

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  var x = 10
  until(x == 0) {
    x -= 1
    println(x)
  }

  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until(i == str.length) {
      if (str(i) == ch) return 1
      i += 1
    }
    -1
  }

  println(indexOf("Hello", 't'))


}
