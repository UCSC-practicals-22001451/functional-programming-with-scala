object PatternMatchingApp {
  def run(args: Array[String]): Unit = {
    if (args.length == 0) {
      println(
        "No input provided. Please run the program with an integer argument."
      )
    } else {
      val input = args(0).toInt
      input match {
        case i if i <= 0     => println("Negative/Zero is input")
        case i if i / 2 == 0 => println("Even number is given")
        case _               => println("Odd number is given")
      }
    }
  }
}
