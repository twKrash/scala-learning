package classes

/**
 * Created by krash on 8/7/14.
 */

import scala.collection.mutable.ArrayBuffer

class Network(val name: String) {
  outer =>

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]

    def description = name + " inside " + outer.name
  }

  private val _members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    _members += m
    m
  }

  def members = _members
}
