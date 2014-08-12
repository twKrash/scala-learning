package files_and_regexp

import scala.io.Source

/**
 * Created by krash on 8/12/14.
 */
object readUrl extends App{
  var source = Source.fromURL("http://apps.opera.com/echo?s", "UTF-8")
  val lines = source.getLines().toArray.mkString("\n")
  println(lines)

  source.close()

}
