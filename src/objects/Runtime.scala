package objects

/**
 * Created by krash on 8/7/14.
 */
object Runtime extends App {
  println(Account.newUniqueNumber(), Account.newUniqueNumber())

  val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)

  val acct = Account(1000.0)
  acct.deposit(5000)
  acct.withdraw(3000)
  println(acct.balance)

  import TrafficLightColor._

  def doWhat(color: TrafficLightColor) = {
    if (color == Red)
      "stop"
    else if (color == Yellow)
      "hurry"
    else
      "go"
  }


  println((doWhat(Green), doWhat(Yellow), doWhat(Red)))

  for (c <- TrafficLightColor.values) println(c.id + " - " + c)

  val conversion = new UnitConversion()
  println(conversion.InchesToCentimeters(1) + " cm")
  println(conversion.GallonsToLites(1) + " l")
  println(conversion.MilesToKilometers(1) + " km")

  val origin = Origin(1,2)
  println(origin.toString)
  println(origin.getLocation)
}

