package traits

import java.awt.geom.Ellipse2D

trait RectangleLike {
  this: java.awt.geom.RectangularShape =>

  def translate(dx: Double, dy: Double) {
    setFrame(getX + dy,
      getY + dy,
      getWidth,
      getHeight)
  }

  def grow(h: Double, v: Double) {
    setFrame(getX + h,
      getY + v,
      getWidth + 2 * h,
      getHeight + 2 * v)
  }
  override def toString = "[%f, %f, %f, %f]".format(getX, getY, getWidth, getHeight)
}

object rLikeObj extends App {
  val egg = new Ellipse2D.Double(5, 10, 20, 13) with RectangleLike
  println(egg)
  egg.translate(10, -10)
  println(egg)
  egg.grow(10, 20)

  println(egg)

}
