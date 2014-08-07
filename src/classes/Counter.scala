package classes

import scala.beans.BeanProperty

/**
 * Created by krash on 8/7/14.
 */

class Counter {
  private[this] var _value = 0
  val timeStamp = new java.util.Date().getTime
  val maxValue: Int = 100

  def inc() = {
    value += 1
    this
  }

  def dec() = {
    value -= 1
    this
  }

  //Setter
  def value_=(v: Int) = if (v <= maxValue) _value = v else _value = maxValue

  //Getter
  def value = _value

  def isLess(other: Counter) = value < other.value
}
