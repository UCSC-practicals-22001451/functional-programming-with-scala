package practical_7

object filterEvenNumbers {
  def run(): Unit = {
    println("Enter a list of space-separated numbers:")
    val input = scala.io.StdIn.readLine()
    val numbers = input.split(" ").map(_.toInt).toList
    val evenNumbers = numbers.filter(num => num % 2 == 0)
    println(s"Even numbers: $evenNumbers")
  }
}
