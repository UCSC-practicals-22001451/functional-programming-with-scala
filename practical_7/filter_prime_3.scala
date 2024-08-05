package practical_7

object filterPrime {
  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else if (n == 2) true
    else !(2 to Math.sqrt(n).toInt).exists(x => n % x == 0)
  }

  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(num => isPrime(num))
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
