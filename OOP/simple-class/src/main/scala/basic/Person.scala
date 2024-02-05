package basic


object Basic {

  def main(args: Array[String]): Unit = {
    val dan = new Person("Dan", "Builder", 1994, "Dutch")
    println(dan.fullName)
    println(dan())
    println(!dan)
    println(dan -> "store")
    println(dan -> "bakery")

  }
}


class Person(firstName: String, lastName: String, birthYear: Int, nationality: String) {

  def fullName: String = s"$firstName $lastName"
  def apply(): String = s"This person is named ${this.fullName}."
  def unary_! : String = s"$firstName has been spotted!"
  def ->(location: String ): String  =  s"$firstName moves to the $location."

}



