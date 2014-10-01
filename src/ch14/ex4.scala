package ch14

object ex4 extends App {
  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its@_*) =>
      its.map(price).sum - disc
    case Multiple(count, item) => price(item) * count
  }

  val x = Bundle("Father's day special", 20.0,
    Multiple(2, Article("Scala for the Impatient", 39.95)),
    Bundle("Anchor Distillery Sampler", 10.0,
      Article("Old Potrero Straight Rye Whiskey", 79.95),
      Article("Junípero Gin", 32.95)
    )
  )
  println(price(x))
}

case class Multiple(count: Int, items: Item*) extends Item
