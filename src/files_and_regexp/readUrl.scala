package files_and_regexp

import scala.io.Source

object readUrl extends App {
  var source = Source.fromURL("http://apps.opera.com/echo?s", "UTF-8")
  val lines = source.getLines().toArray.mkString("\n")
  source.close()
  println(lines)
}
