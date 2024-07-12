object NameFormat {
  def toUpper(name: String): String = name.toUpperCase

  def toLower(name: String): String = name.toLowerCase

  def formatNames(name: String)(formatter: String => String): String =
    formatter(name)

  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")
    val formats = List(
      toUpper, // Corrected: Removed trailing _
      (name: String) =>
        name.substring(0, 1).toUpperCase + name.substring(1).toLowerCase,
      toLower, // Corrected: Removed trailing _
      (name: String) =>
        name.substring(0, name.length - 1).toLowerCase + name
          .takeRight(1)
          .toUpperCase
    )

    names.zip(formats).foreach { case (name, format) =>
      println(formatNames(name)(format))
    }
  }
}
