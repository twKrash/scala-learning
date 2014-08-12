package files_and_regexp

import java.io._

import inheritance.Bundle

//@SerialVesrionUID(42L) class Person extends Serializable


object serial extends App {
  val bundle = new Bundle
  bundle(1, "Test")
  bundle(2, "Test2")

  val out = new ObjectOutputStream(new FileOutputStream("/tmp/test.obj"))
  out.writeObject(bundle)
  out.close()
  val in = new ObjectInputStream(new FileInputStream("/tmp/test.obj"))
  val savedBundle = in.readObject().asInstanceOf[Bundle]

  println(savedBundle.price,savedBundle.description)

}

