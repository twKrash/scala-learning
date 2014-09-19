package ch11

class BitSequence {
  var data: Long = 0L

  override def toString = {
    (for (i <- 63 to(0, -1)) yield (data >> i) & 1L).mkString
  }

  def apply(n: Int) = {
    if (n >= 0 && n <= 63) (data >> n) & 1L
    else 0L
  }

  def update(n: Int, b: Int) = {
    if (n >= 0 && n <= 63) {
      if (b == 0) data &= ~(1L << n)
      else data |= (1L << n)
    }
  }
}


object BitSeq extends App {
  val bs = new BitSequence()
  println(bs)
  for (i <- 16 to 47) bs(i) = 1
  println(bs)
  for (i <- 24 to 39) bs(i) = 0
  println(bs)
  println(bs(15) + " " + bs(16))
}