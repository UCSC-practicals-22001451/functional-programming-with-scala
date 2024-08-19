package practical_9

object pattern_matcher_2 {
  def run(): Unit = {

    print("Enter an integer: ")
    val input = scala.io.StdIn.readInt()

    val categorizeNumber: Int => String = {
      case n if n <= 0     => "Negative/Zero is input"
      case n if n % 2 == 0 => "Even number is given"
      case _               => "Odd number is given"
    }

    val result = categorizeNumber(input)
    println(result)
  }
}
