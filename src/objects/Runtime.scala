package objects

/**
 * Created by krash on 8/7/14.
 */
object Runtime extends App {
  println(Account.newUniqueNumber(), Account.newUniqueNumber())

  val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)
}

