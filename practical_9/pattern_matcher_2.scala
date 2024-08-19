package practical_9

object pattern_matcher_2 {
  def run(): Unit = {
    // Prompt user for input
    print("Enter an integer: ")
    val input = scala.io.StdIn.readInt()

    // Define pattern matching function using lambda
    val categorizeNumber: Int => String = {
      case n if n <= 0     => "Negative/Zero is input"
      case n if n % 2 == 0 => "Even number is given"
      case _               => "Odd number is given"
    }

    // Apply pattern matching and print result
    val result = categorizeNumber(input)
    println(result)
  }
}
