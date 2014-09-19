package ch11

import hplrs._

object Name {
//  def unapply(input: String) = {
//    val pos = input.indexOf(" ")
//    if (pos == -1) None
//    else Some((input.substring(0, pos), input.substring(pos + 1)))
//  }

  def unapplySeq(input: String): Option[Seq[String]] =
    if (input.trim == "") None else Some(input.trim.split("\\s"))
}

object Number {
  def unapply(input: String): Option[Int] = try {
    Some(Integer.parseInt(input.trim))
  } catch {
    case ex: NumberFormatException => None
    //    case _ => None
  }
}


object isCompound {
  def unapply(input: String) = input.contains(" ")
}

object Extractors extends App with ConsoleLogger with TimestampLogger {
  val author = "Firstname Lastname qwe "
//  val Name(first, last) = author
//  log(first + " " + last)
  val num = "5"
  val num2 = "24"
  val Number(test) = num2
  log(test.toString)

  author match {
    case Name(f, l) => log("two")
    case Name(f, l, t) => log("tree")
    case Name(f, l, t, fo) => log("four")
    case _ => log("other")
  }


}
