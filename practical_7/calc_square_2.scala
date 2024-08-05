package practical_7

object calculateSquare {
  def run(): Unit = {
    println("Enter a list of space-separated numbers:")
    val input = scala.io.StdIn.readLine()
    val numbers = input.split(" ").map(_.toInt).toList

    val squaredNumbers = numbers.map(num => num * num)
    println(s"Squared numbers: $squaredNumbers")
  }
}
