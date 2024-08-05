object App {
  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      args(0) match {
        // case "p2e2" => practical_2.practical_2_Exercise_2.run()
        // case "p5e1" => practical_5.inventory_management.run()
        // case "p5e2" => practical_5.library_management.run()
        // case "p5e3" => practical_5.print_fib.run()
        // case "p6e1" => practical_6.warehouse_management.run()
        // case "p6e2" => practical_6.student_management.run()
        case "p7e1" => practical_7.filterEvenNumbers.run()
        case "p7e2" => practical_7.calculateSquare.run()
        case "p7e3" => practical_7.filterPrime.run()
        case _      => println("Exercise not found.")
      }
    } else {
      println("Please specify an exercise to run.")
    }
  }
}
