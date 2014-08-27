package traits

class CryptoLogger(msg: String) {
  val chiper: Int = 3

  def crypt: String = msg.flatMap { c =>
    (c.toInt + chiper).toChar + ""
  }

  def decrypt(encrypted: String): String = encrypted.flatMap { c =>
    (c.toInt - chiper).toChar + ""
  }

}

object CryptoLoggerObj extends App {
  val test = new CryptoLogger("Hello")
  val crypt = test.crypt

  println(crypt, test.decrypt(crypt))

  val test2 = new {
    override val chiper: Int = -3
  } with CryptoLogger("Hello")
  val crypt2 = test2.crypt

  println(crypt2, test2.decrypt(crypt2))
}
