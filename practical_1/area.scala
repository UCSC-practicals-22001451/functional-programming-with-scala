package practical_1

def diskArea(radius: Double): Double = {
  val Pi = Math.PI
  Pi * radius * radius
}

def run(args: Array[String]): Unit = {
  val radius = 5.0
  val area = diskArea(radius)
  println(s"The area of the disk with radius $radius is $area")
}
