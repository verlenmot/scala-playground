package simpleTailRecursion

import scala.annotation.tailrec

object StringTailRecursion {

  def main(args: Array[String]): Unit = {

    // Concatenate a string n times.
    @tailrec
    def stringConcatenation(str: String, n: Int, acc: String = ""): String = {
      if (n == 0) acc
      else stringConcatenation(str, n - 1, str + " " + acc)
    }

    println(stringConcatenation("Hello", 5))

    // Replace a character in a string with another character n times
    def stringCharacterReplace(str: String, regex: String, newString: String, n: Int): String = {
      @tailrec
      def replaceTailrec(n: Int, acc: String = str): String = {
        if (n == 0) acc
        else replaceTailrec(n - 1, acc.replaceFirst(regex, newString))
      }
      replaceTailrec(n)
    }

    println(stringCharacterReplace("This is interesting", "is", "a", 2))
  }
}