package objects

/**
 * Created by krash on 8/7/14.
 */
abstract class UndoableActions(val description: String) {
  def undo(): Unit

  def redo(): Unit
}


object DoNothingAction extends UndoableActions("Do nothing") {
  override def undo(): Unit = {

  }

  override def redo(): Unit = {

  }

}