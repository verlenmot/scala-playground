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

    // Replaces the first n appearances of a regular expression with a string.
    def replaceFirstN(str: String, regex: String, newString: String, n: Int): String = {
      @tailrec
      def replaceTailrec(n: Int = n, acc: String = str): String = {
        if (n == 0) acc
        else replaceTailrec(n - 1, acc.replaceFirst(regex, newString))
      }
      replaceTailrec()
    }

    println(replaceFirstN("This is interesting", "is", "a", 2))
  }
}