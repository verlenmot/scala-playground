package simpleTailRecursion

object StringTailRecursion {

  def main(args: Array[String]): Unit = {

    // Concatenate a string n times.
    def stringConcatenation(str: String, n: Int, acc: String = ""): String = {
      if (n == 0) acc
      else stringConcatenation(str, n - 1, str + " " + acc)
    }
    println(stringConcatenation("Hello", 5))
  }
}
