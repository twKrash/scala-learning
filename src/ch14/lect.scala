package ch14

object lect extends App {

  val pattern = "([0-9]+) ([a-z]+)".r
  "99 bottles" match {
    case pattern(num, item) => println(num, item)
    case _ => println("Nothing to do here")
  }

  val (q, r) = BigInt(10) /% 3
  println(q, r)
  val Array(firs, second, _*) = Array(1, 2, 3, 4, 5)

  val amt = List(Dollar(3.14), Currency(5.0, "hrn"), Nothing)

  for (m <- amt) {
    println(m match {
      case Dollar(v) => "Got $ " + v
      case Currency(_, u) => "Got " + u
      case Nothing => "Other"
      case _ => ""
    }
    )
  }
  val amt2: Amount = Dollar(20.0)
  println(amt2 match {
    case Dollar(v) => "Got $" + v
    case Currency(_, u) => "Got " + u
    case Nothing => "Other"
    case _ => ""
  })

  println(1 +: 7 +: 2 +: 9 +: Nil match {
    case first +: sec +: rest => {
      first + sec + rest.length
    }
  })

  val b1 = Bundle("Father's day special", 20.0,
    Article("Scala for impatient", 39.0),
    Bundle("Anchor Distillery Sampler", 10.0,
      Article("One", 20.0),
      Article("Two", 14.0)
    )
  )

  //  println(b1)

  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its@_*) => {
      println(its, disc)
      its.map(price).sum - disc
    }
  }

  print(price(b1))
  val color: TrafficLightColor = Green
  color match {
    case Red => "stop"
    case Green => "go"
    case Yellow => "hurry up"
  }

  val f: PartialFunction[Char, Int] = {
    case '+' => 1
    case '-' => -1
  }
  println(f('-'), f.isDefinedAt('0')) //f('0') -> Exception

  println("-3+4".collect {
    case '+' => 1
    case '-' => -1
  })
}

case object +: {
  def unapply[T](input: List[T]) = if (input.isEmpty) None else Some(input.head, input.tail)
}

sealed abstract class Amount

case class Dollar(value: Double) extends Amount

case class Currency(value: Double, unit: String) extends Amount

case object Nothing extends Amount


abstract class Item

case class Article(description: String, price: Double) extends Item

case class Bundle(description: String, price: Double, items: Item*) extends Item


sealed abstract class TrafficLightColor

case object Red extends TrafficLightColor

case object Green extends TrafficLightColor

case object Yellow extends TrafficLightColor
