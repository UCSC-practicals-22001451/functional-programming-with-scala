package practical_10

object rational_num_1 {
  def run(): Unit = {
    class rational_number(n: Int, d: Int) {
      require(d != 0, "Denominator cannot be zero")
      
      private val gcd: Int = calculateGCD(n.abs, d.abs)
      private val numerator: Int = n / gcd
      private val denominator: Int = d / gcd
      
      def this(n: Int) = this(n, 1)
      
      override def toString: String = s"$numerator/$denominator"

      def+(that: rational_number): rational_number = {
        new rational_number(
          numerator * that.denominator + that.numerator * denominator,
          denominator * that.denominator
        )
      }      
      def-(that: rational_number): rational_number = {
        new rational_number(
          numerator * that.denominator - that.numerator * denominator,
          denominator * that.denominator
        )
      }
      def neg: rational_number = new rational_number(-numerator, denominator)

       private def calculateGCD(a: Int, b: Int): Int = {
        if (b == 0) a else calculateGCD(b, a % b)
      }
    }


    val x = new rational_number(3, 4)
    val x2 = x.neg
    println(x2)

    val y = new rational_number(5, 8)
    val z = new rational_number(2, 7)
    
    val r1 = x - y - z
    
    println(r1)
  }
}
