package ch11

import hplrs.{ConsoleLogger, TimestampLogger}

class Table(html: String) {

  override def toString = html.stripSuffix("<tr>").trim + "</tr></table>"

  def |(col: String) = if (col == "") Table(html + "") else Table(html + "<td>" + col + "</td>")

  def ||(col: String) = if (col == "") Table(html + "") else Table(html + "</tr><tr><td>" + col + "</td>")
}

object Table {
  def apply(html: String = "<table><tr>") = new Table(html)
}

object HtmlBuilder extends App with ConsoleLogger with TimestampLogger {
  log("" + (Table() | "Bob" | "Two" || "three" | "four" || ""))

}
