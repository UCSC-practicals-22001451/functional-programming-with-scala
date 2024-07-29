package practical_6
import scala.io.StdIn.readLine

object student_management {

  def run(): Unit = {
    var continue = true
    var studentRecords: List[(String, Int, Int, Double, Char)] = List()

    while (continue) {
      println("Menu:")
      println("1. Add Student")
      println("2. Print Student Records")
      println("3. Done")
      val choice = readLine("Enter your choice: ")

      choice match {
        case "1" =>
          val studentInfo = getStudentInfoWithRetry()
          studentRecords = studentRecords :+ studentInfo
        case "2" =>
          studentRecords.foreach(printStudentRecord)
        case "3" =>
          continue = false
        case _ =>
          println("Invalid choice. Please try again.")
      }
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var studentInfo: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')

    while (!isValid) {
      val name = readLine("Enter student's name: ")
      val marks = readLine("Enter student's marks: ").toInt
      val totalMarks = readLine("Enter total possible marks: ").toInt

      val (valid, errorMessage) = validateInput(name, marks, totalMarks)
      if (valid) {
        val percentage = (marks.toDouble / totalMarks) * 100
        val grade = percentage match {
          case p if p >= 90 => 'A'
          case p if p >= 75 => 'B'
          case p if p >= 50 => 'C'
          case _            => 'D'
        }
        studentInfo = (name, marks, totalMarks, percentage, grade)
        isValid = true
      } else {
        println(s"Invalid input: ${errorMessage.get}")
      }
    }

    studentInfo
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks / $totalMarks")
    println(s"Percentage: $percentage%")
    println(s"Grade: $grade")
  }

  def validateInput(
      name: String,
      marks: Int,
      totalMarks: Int
  ): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || marks > totalMarks) {
      (
        false,
        Some("Marks must be positive and not exceed total possible marks")
      )
    } else {
      (true, None)
    }
  }
}
