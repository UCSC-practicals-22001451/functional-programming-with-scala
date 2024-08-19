package practical_9

object formatter_3 {
  def run(): Unit = {
    // Define toUpper method
    def toUpper(str: String): String = str.toUpperCase()

    // Define toLower method
    def toLower(str: String): String = str.toLowerCase()

    // Define formatNames method
    def formatNames(name: String)(formatFunc: String => String): String =
      formatFunc(name)

    // Test inputs
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    // Apply formatting and print results
    println(formatNames(names(0))(toUpper))
    println(
      formatNames(names(1))(str =>
        str.substring(0, 2).toUpperCase() + str.substring(2).toLowerCase()
      )
    )
    println(formatNames(names(2))(toLower))
    println(
      formatNames(names(3))(str =>
        str.substring(0, str.length - 1) + str.last.toUpper
      )
    )
  }
}
