package traits


import java.awt.Point
import java.beans.{PropertyChangeEvent, PropertyChangeListener, PropertyChangeSupport}

trait PropertyChangeSupportLike {
  private val propertyChangeSupport = new PropertyChangeSupport(this)

  def addPropertyChangeListener(listener: PropertyChangeListener) {
    propertyChangeSupport.addPropertyChangeListener(listener)
  }

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
    propertyChangeSupport.addPropertyChangeListener(propertyName, listener)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean) {
    propertyChangeSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int) {
    propertyChangeSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Object, newValue: Object) {
    propertyChangeSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def firePropertyChange(event: PropertyChangeEvent) {
    propertyChangeSupport.firePropertyChange(event)
  }

  def firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean) {
    propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue)
  }

  def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int) {
    propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue)
  }

  def firePropertyChange(propertyName: String, oldValue: Object, newValue: Object) {
    propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue)
  }

  def getPropertyChangeListeners: Array[PropertyChangeListener] = propertyChangeSupport.getPropertyChangeListeners

  def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener] = propertyChangeSupport.getPropertyChangeListeners(propertyName)

  def hasListeners(propertyName: String): Boolean = propertyChangeSupport.hasListeners(propertyName)

  def removePropertyChangeListener(listener: PropertyChangeListener) {
    propertyChangeSupport.removePropertyChangeListener(listener)
  }

  def removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
    propertyChangeSupport.removePropertyChangeListener(propertyName, listener)
  }

}


trait PointTrait extends Point {
  override def toString = "[%f, %f]".format(getX, getY)
}

object PropertyChangeSupportObj extends App {

  val point = new Point(10, 20) with PropertyChangeSupportLike with PointTrait

  val listener = new PropertyChangeListener {
    def propertyChange(evt: PropertyChangeEvent): Unit = {
      println(("Old value: " + evt.getOldValue, "New value: " + evt.getNewValue))
    }
  }

  point.addPropertyChangeListener(listener)

  point.firePropertyChange("x", 10, 30)
  point.firePropertyChange("y", 20, 40)
  println(point.hasListeners("x"))
  println(point.hasListeners("y"))
  println(point)

}
