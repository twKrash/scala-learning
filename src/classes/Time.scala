package classes

/**
 * Created by krash on 8/7/14.
 */
class Time() {
  private var _hrs: Int = 0
  private var _min: Int = 0

  def this(hrs: Int) = {
    this()
    this._hrs = if (hrs >= 0 && hrs <= 23) hrs else if (hrs > 23) 23 else 0
  }

  def this(hrs: Int, min: Int) = {
    this(hrs)
    this._min = if (min >= 0 && min <= 59) min else if (min > 59) 59 else 0
  }

  def hrs = _hrs

  def min = _min

  private def _convertDate(hrs: Int, min: Int): Int = {
    (hrs * 60 + min) * 60
  }

  def before(other: Time): Boolean = {
    _convertDate(hrs, min) < _convertDate(other.hrs, other.min)
  }
}
