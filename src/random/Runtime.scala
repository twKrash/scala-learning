package random


object Runtime extends App {
  val rnd = new Rnd
  rnd.setSeed(0)
  println((rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt()))
  println((rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble()))

  rnd.setSeed(500)
  println((rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), rnd.nextInt()))
  println((rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble()))
}
