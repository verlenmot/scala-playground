package basic

abstract class Light {
  val lumens: Int
  def switch: Light
  def isOn: Boolean
  def apply: Unit
}

class lamp(brightness: Int, active: Boolean) extends Light with Purchasable {
  override val lumens: Int = brightness
  override def switch: Light = new lamp(brightness, !active)
  override def isOn: Boolean = active
  override def apply: Unit = println(s"This is a lamp")
}

trait Purchasable {
  def canPurchase = println("Thia object can be purchased.")
}

object Main {
  def main(args: Array[String]): Unit = {
    val tableLamp = new lamp(500, false)
    println(tableLamp.lumens)
    println(tableLamp.isOn)
    println(tableLamp.switch.isOn)
    tableLamp.apply
    tableLamp.canPurchase
  }
}