package traits

import java.io.{BufferedInputStream, FileInputStream, InputStream}

trait Buffering extends InputStream {
  this: InputStream =>

  private[this] val bis = {
    new BufferedInputStream(this)
  }

  abstract override def read = super.read()

  override def read(byte: Array[Byte], off: Int, len: Int) = {
    super.read(byte, off, len)
  }

  override def available = bis.available

  override def close() {
    bis.close()
  }

  override def skip(n: Long) = bis.skip(n)

}

object BufferingObj extends App {
  val fis = new FileInputStream("/Users/krash/test.txt") with Buffering
  var content: Int = 0
  var counter: Int = 0
  while ((content = fis.read()) != -1 && counter < 101) {
    counter += 1
    if (counter >= 100) {
      println("Stack Overflow!")
    }
    print(content.toChar)
  }
  fis.close()
}
