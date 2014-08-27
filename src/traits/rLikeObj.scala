package traits

import java.awt.geom.Ellipse2D

trait RectangleLike {
  this: java.awt.geom.RectangularShape =>

  def translate(dx: Double, dy: Double) {
    val obj = new java.awt.Rectangle(getX.toInt, getY.toInt, getWidth.toInt, getHeight.toInt)
    obj.translate(dx.toInt, dy.toInt)
    setFrame(obj.getX, obj.getY, obj.getWidth, obj.getHeight)
  }

  def grow(h: Double, v: Double) {
    val obj = new java.awt.Rectangle(getX.toInt, getY.toInt, getWidth.toInt, getHeight.toInt)
    obj.grow(h.toInt, v.toInt)
    setFrame(obj.getX, obj.getY, obj.getWidth, obj.getHeight)
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
