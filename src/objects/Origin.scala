package objects

import java.awt.Point

class Origin private(x: Int, y: Int) extends Point {
  setLocation(x, y)
}

object Origin {
  def apply(x: Int, y: Int) = new Origin(x, y)
}


object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}