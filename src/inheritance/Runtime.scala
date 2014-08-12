package inheritance

object Runtime extends App {
  val ant1 = new Ant
  val ant2 = new Ant2
  println((ant1.env.length, ant2.env.length))

  val acct = new CheckingAccount(123)
  println(acct.withdraw(100), acct.withdraw(21), acct.deposit(3))

  val acct2 = new SavingsAccount(123)
  println(acct2.withdraw(100), acct2.withdraw(21), acct2.deposit(3), acct2.deposit(5))

  val savAcct = new SavingsAccount(100)

  assert(savAcct.balance == 100)
  savAcct.deposit(100)
  assert(savAcct.balance == 200)
  savAcct.deposit(100)
  println(savAcct.withdraw(300))
  savAcct.deposit(2)
  assert(savAcct.balance == 1)
//  assertRaises[NoTransactionsLeftThisMonth] { () => savAcct.deposit(100) }
}
