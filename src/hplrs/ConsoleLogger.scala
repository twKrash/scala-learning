package hplrs

trait ConsoleLogger extends Logged {
  override def log(msg: String) {
    println(msg)
  }
}
