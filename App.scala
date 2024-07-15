import practical2.practical_2_Exercise_2

object App {
  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      args(0) match {
        case "p2e2" => practical_2_Exercise_2.run()
        // Add cases for other exercises here
        case _ => println("Exercise not found.")
      }
    } else {
      println("Please specify an exercise to run.")
    }
  }
}
