package practical_7

object filterPrime {
  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter { num =>
      if (num <= 1) false
      else if (num == 2) true
      else !(2 to Math.sqrt(num).toInt).exists(x => num % x == 0)
    }
  }

  def run(): Unit = {
    println("Enter a list of space-separated numbers:")
    val input = scala.io.StdIn.readLine()
    val numbers = input.split(" ").map(_.toInt).toList

    // Filter out the prime numbers
    val primeNumbers = filterPrime(numbers)

    println(s"Prime numbers: $primeNumbers")
  }
}
