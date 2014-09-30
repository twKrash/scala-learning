package ch13

import scala.collection.mutable
import ch13.lect._

object ex3 extends App {
  val lst = mutable.LinkedList(1, -2, 3, 4, -5)
  time {
    println(lst.filter(_ > 0))
  }
  time {
    var cur = lst
    while (cur != Nil) {
      if (cur.next.elem <= 0) cur.next = cur.next.next

      cur = cur.next
    }
    println(lst)
  }

}
