package ch13


import ch13.lect.time

class MyRichString(l: List[String]) {
  def myMkstring(start: String = "", sep: String = " ", end: String = ""): String = {
    start + l.reduceLeft(_.toString + sep + _.toString) + end
  }
}

object MyRichString {
  def apply(l: List[String]) = new MyRichString(l)
}

object ex5 extends App {
  implicit def listToString(s: List[String]) = MyRichString(s)

  time {
    println(List("haha", "HAHAHA", "MUAHAHAHAH").myMkstring("<@Malkovian said:", " | ", " >"))
  }
  time {
    println(List("haha", "HAHAHA", "MUAHAHAHAH").mkString("<@Malkovian said:", " | ", " >"))
  }
}
