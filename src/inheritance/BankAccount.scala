package inheritance

class BankAccount(initialBalance: Double) {
  private var _balance = initialBalance

  def deposit(amount: Double) = {
    _balance += amount
    _balance
  }

  def withdraw(amount: Double) = {
    _balance -= amount
    _balance
  }

  def balance = _balance

}


class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  override def deposit(amount: Double) = {
    super.withdraw(1)
    super.deposit(amount)
  }

  override def withdraw(amount: Double) = {
    super.withdraw(1)
    super.withdraw(amount)
  }
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private[this] val ConstTransactionsLeft = 3
  private var numberOfTransactionsLeft = 3


  def earnMonthlyInterest(): Unit = {
    numberOfTransactionsLeft = ConstTransactionsLeft
    deposit(balance * 0.01)
  }

  private def checkTransactionsLeft() = {
    if (numberOfTransactionsLeft > 0) {
      numberOfTransactionsLeft -= 1
      true
    } else {
      println("No free transactions left")
      false
    }
  }

  override def withdraw(amount: Double) = {
    if (checkTransactionsLeft()) {
      super.withdraw(amount)
    } else {
      super.withdraw(1)
      super.withdraw(amount)
    }
  }

  override def deposit(amount: Double) = {
    if (checkTransactionsLeft()) {
      super.deposit(amount)
    } else {
      super.withdraw(1)
      super.deposit(amount)
    }
  }
}

class NoTransactionsLeftThisMonth extends Exception