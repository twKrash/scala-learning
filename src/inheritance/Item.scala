package inheritance

import scala.collection.mutable.ArrayBuffer


abstract class Item{
  def price: Double

  def description: String

  class SimpleItem(val price: Double, val description: String) extends Serializable

  def apply(price: Double, description: String) = {
    new SimpleItem(price, description)
  }


}

class Bundle extends Item with Serializable {

  private var _items = new ArrayBuffer[super.SimpleItem]

  override def apply(price: Double, description: String) = {
    val s = super.apply(price, description)
    _items += s
    s
  }

  def price = items.map(_.price).sum

  def description = items.map(_.description).mkString(", ")

  def items = _items
}

object Bundle extends App {
  val bundle = new Bundle
  bundle(1, "Test")
  bundle(2, "Test2")
  println(bundle.price, bundle.description)
}