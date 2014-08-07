package objects

/**
 * Created by krash on 8/7/14.
 */

class Account {
  val id = Account.newUniqueNumber()
  private var _balance: Double = 0.0

  def deposit(amount: Double) {
    _balance += amount
  }

  def withdraw(amount: Double): Unit = {
    _balance -= amount
  }

}

object Account {

  private var _lastNumber: Int = 0

  def newUniqueNumber() = {
    _lastNumber += 1
    _lastNumber
  }
}
