package files_and_regexp

import scala.io.Source

object readFile extends App {

  val s = Source.fromFile("/Users/Krash/suggest.txt");s.mkString.split("\\s").filter(_.length >41).map(println(_));s.close()

  val source = Source.fromFile("/Users/Krash/suggest.txt")
  val lexems = source.mkString.split("\\s")
  for (w <- lexems) if (w.length > 41) println(w)

  source.close()
}
