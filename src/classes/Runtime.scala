package classes

import objects.Runtime.Test

object Runtime extends App {
  val myCounter = new Counter
  myCounter.dec().dec().dec()
  println(myCounter.value)
  myCounter.value = 0
  myCounter.inc().inc().inc()
  println(myCounter.value)
  println(new java.util.Date().getTime - myCounter.timeStamp)
  val counter2 = new Counter
  counter2.value = 4
  println(myCounter.isLess(counter2))




  println(new Person)
  val person = new Person("Max")
  println((person.name, person.age))
  val person2 = new Person("Pete", 22)
  println((person2.name, person2.age))


  val p2 = new Person2("t", 5)
  println(p2.name)

  val p3 = new Person3("p3", 5)
  println((p3.name, p3.age))
  p3.name = "QWE"
  p3.age = 10
  println((p3.name, p3.age))

  val p4 = new Person4("p4", 5)
  println((p4.getName, p4.getAge))
  p4.setName("ASD")
  p4.setAge(20)
  println((p4.getName, p4.getAge))


  val p5 = Person5.create("Private Constructor", 5)
  println((p5.name, p5.age))


  val chatter = new Network("Meeting")
  val myFace = new Network("Private")

  val fred = chatter.join("Fred")
  val wilma = chatter.join("Wilma")
  fred.contacts += wilma
  val barney = myFace.join("Barney")
  for (member <- chatter.members) println(member.description)
  for (member <- myFace.members) println(member.description)

  for (contact <- fred.contacts) println(contact.description)
  println(fred.contacts)
  //  fred.contacts += barney

  //TODO: Task1
  println("task 1")
  val counter3 = new Counter
  counter3.value = 99
  counter3.inc().inc().inc().inc()
  println(counter3.value)
  counter3.value = 0
  println(counter3.value)
  counter3.value = 10000
  println(counter3.value)
  counter3.value = 1
  println(counter3.value)
  counter3.value = 100
  println(counter3.value)
  println("end ===========")

  //TODO: Task 2

  println("task 2")
  val acc = new BankAccount()
  println(acc.balance)
  acc.deposit(100)
  println(acc.balance)
  acc.withdraw(50)
  println(acc.balance)
  println("end ===========")

  //TODO: Task 3-4
  println("task 3-4")
  val t1 = new Time(22, 59)
  val t2 = new Time(23, 59)
  println((t1.before(t2), t2.before(t1)))
  println("end ===========")

  //TODO: Task 5
  println("task 5")
  val student = new Student("Max", 123456)
  println(student.getId + " - " + student.getName)
  student.setName("Pete")
  student.setId(123457)
  println(student.getId + " - " + student.getName)
  println("end ===========")

  //TODO: Task 6
  println("task 6")
  val pe = new Person3("age", -15)
  println(pe.name, pe.age)
  println("end ===========")

  println("Too lazy to do rest...")

  val a2:Option[String] = Some("123")

  a2 match {
    case Some("345") => println("123")
    case Some(x) => println(x)
    case None => println("rest")
  }
}
