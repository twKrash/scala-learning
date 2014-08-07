package classes

/**
 * Created by krash on 8/7/14.
 */
class Person {
  private var _name: String = ""
  private var _age: Int = 0

  def this(name: String) {
    this()
    this._name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this._age = age
  }


  def name = _name

  def age = _age
}

//In this case _name and _age is val
class Person2(_name: String, _age: Int) {
  print(this.getClass + " ")
  printf("New person created (%s - %d)", _name, _age)

  def name = _name

  def age = _age
}

class Person3(private var _name: String, private var _age: Int) {
  if (_age < 0) _age = 0
  print(this.getClass + " ")
  printf("New person3 created (%s - %d)", _name, _age)

  def name = _name

  def age = _age

  def name_=(s: String) = _name = s

  def age_=(i: Int) = _age = if (i > 0) i else 0
}

import scala.beans.BeanProperty

class Person4(@BeanProperty var name: String, @BeanProperty var age: Int) {

}

class Person5 private(val name: String, val age: Int) {}

object Person5 {
  def create(name: String, age: Int) = {
    new Person5(name, age)
  }
}