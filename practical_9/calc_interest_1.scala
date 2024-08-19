package practical_9

object interest_1 {
  def run(): Unit = {
    val calculateInterest: Double => Double = deposit =>
      deposit match {
        case d if d <= 20000   => d * 0.02
        case d if d <= 200000  => d * 0.04
        case d if d <= 2000000 => d * 0.035
        case d                 => d * 0.065
      }

    print("Enter the deposit amount: ")
    val depositAmount = scala.io.StdIn.readDouble()

    val interest = calculateInterest(depositAmount)
    println(
      f"The interest earned is Rs. $interest%.2f"
    )
  }
}
