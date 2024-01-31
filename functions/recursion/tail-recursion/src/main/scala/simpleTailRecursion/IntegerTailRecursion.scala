package simpleTailRecursion

object IntegerTailRecursion {


  def main(args: Array[String]): Unit = {

    // Factorial function: n -> n * n -1 * ... * 1
    def factorial(n: Int, acc: Int = 1): Int = {
      if (n <= 1) acc
      else factorial(n - 1, n * acc)
    }

    println(factorial(4))

    // Add a number n times to itself without using multiplication
    def repeatedAddition(number: Int, n: Int, acc: Int = 0): Int = {
      if (n == 0) acc + number
      else repeatedAddition(number, n - 1, number + acc)
    }

    println(repeatedAddition(5, 2))

    // Retrieve the exponent of a number without using Math.pow
    def exponent(number: Int, n: Int, acc: Int = 1): Int = {
      if (n == 0) acc
      else exponent(number, n-1, number * acc)
    }
    println(exponent(5,2))
  }
}
