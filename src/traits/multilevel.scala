package traits

trait Logged {
  def log(msg: String) {}
}

trait Logger {
  def log(msg: String)

  def info(msg: String): Unit = {
    log("INFO: " + msg)
  }

  def warn(msg: String): Unit = {
    log("WARN: " + msg)
  }

  def severe(msg: String): Unit = {
    log("SEVERE: " + msg)
  }
}

trait TimestampLogger extends Logged {
  override def log(msg: String): Unit = {
    super.log(new java.util.Date() + ": " + msg)
  }
}

trait TimestampLogger2 extends Logger {
  abstract override def log(msg: String): Unit = {
    super.log(new java.util.Date() + ": " + msg)
  }
}

trait ShortLogger extends Logged {
  val maxlenghts = 15

  override def log(msg: String): Unit = {
    super.log(if (msg.length <= maxlenghts) msg else msg.substring(0, maxlenghts - 3) + "...")
  }
}

trait ShortLogger2 extends Logger {
  val maxlenghts = 15

  override def log(msg: String): Unit = {
    log(if (msg.length <= maxlenghts) msg else msg.substring(0, maxlenghts - 3) + "...")
  }
}

trait ConsoleLogger extends Logged {
  override def log(msg: String): Unit = {
    println(msg)
  }
}

trait ConsoleLogger2 extends Logger {
  override def log(msg: String): Unit = {
    println(msg)
  }
}

class Account {
  var balance = 0.0
}

class SavingsAccount extends Account with Logger {
  def withdraw(amount: Double): Unit = {
    if (amount > balance) severe("Insufficient funds. ")
    else {
      info("Ok")
      balance -= amount
    }
  }

  override def log(msg: String): Unit = {
    println(msg)
  }
}

class SavingsAccount2 extends Account with ConsoleLogger2 with ShortLogger {
  var interest = 0.0

  def withdraw(amount: Double): Unit = {
    if (amount > balance) severe("Insufficient funds. ")
    else {
      info("Ok")
      balance -= amount
    }
  }

  override def log(msg: String): Unit = {
    println(msg)
  }
}


object multilevel extends App {

  val acct1 = new SavingsAccount() with ConsoleLogger2 with TimestampLogger2
  acct1.balance = 3
  //  val acct2 = new SavingsAccount(100) with ConsoleLogger with ShortLogger with TimestampLogger

  acct1.withdraw(1)
  acct1.withdraw(1)
  acct1.withdraw(1)
  acct1.withdraw(1)

  //  acct2.withdraw(1)
  //  acct2.withdraw(1)
  //  acct2.withdraw(1)
  //  acct2.withdraw(1)
}
