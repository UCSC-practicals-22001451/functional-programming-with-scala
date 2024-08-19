package practical_9

object formatter_3 {
  def run(): Unit = {

    def toUpper(str: String): String = str.toUpperCase()

    def toLower(str: String): String = str.toLowerCase()

    def formatNames(name: String)(formatFunc: String => String): String =
      formatFunc(name)

    val names = List("Benny", "Niroshan", "Saman", "Kumara")

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
