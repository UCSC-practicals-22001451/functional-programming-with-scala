package practical_8

import scala.io.StdIn
object lambda_categorize_2 {
  def run(): Unit = {

    print("Enter a number: ")
    val input = StdIn.readInt()

    val result = input match {
      case n if n % 3 == 0 && n % 5 == 0 => "Multiple of Both Three and Five"
      case n if n % 3 == 0               => "Multiple of Three"
      case n if n % 5 == 0               => "Multiple of Five"
      case _                             => "Not a Multiple of Three or Five"
    }

    println(result)
  }
}
