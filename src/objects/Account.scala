package objects

class Account private(val id: Int, initialBalance: Double) {
  private var _balance: Double = initialBalance

  def deposit(amount: Double) {
    _balance += amount
  }

  def withdraw(amount: Double): Unit = {
    _balance -= amount
  }

  def balance = _balance

}

object Account {

  def apply(initialBalance: Double) = new Account(newUniqueNumber(), initialBalance)


  private var _lastNumber: Int = 0

  def newUniqueNumber() = {
    _lastNumber += 1
    _lastNumber
  }
}
