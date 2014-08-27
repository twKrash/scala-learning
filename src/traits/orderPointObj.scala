package traits

import java.awt.Point
import java.util


class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
  def compare(that: Point): Int = {
    if (this.x <= that.x) {
      if (this.x == that.x) {
        if (this.y < that.y) -1
        else if (this.y > that.y) 1
        else 0
      } else -1
    } else 1
  }

  override def toString = "[%f, %f]".format(getX, getY)
}

object orderPointObj extends App {

  val p1 = new OrderedPoint(1,2)
  val p2 = new OrderedPoint(2,3)
  val p3 = new OrderedPoint(2,3)
  println(p1,p2)
  println(p1 > p2)
  println(p1 == p2)
  println(p1 < p2)

  println(p2 == p3)
}


