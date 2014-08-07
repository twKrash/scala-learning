package classes

/**
 * Created by krash on 8/7/14.
 */
class BankAccount {
  private var _balance: Int = 0

  def deposit(i: Int) = _balance += i

  def withdraw(i: Int) = _balance -= i

  def balance = _balance
}
