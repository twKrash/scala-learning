package inheritance

/**
 * Created by krash on 8/12/14.
 */
class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}


class Ant extends Creature {
  override val range: Int = 2
}

class Ant2 extends {
  override val range:Int = 2
} with Creature


