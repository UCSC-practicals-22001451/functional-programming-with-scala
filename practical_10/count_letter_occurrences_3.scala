package practical_10

object count_letter_occurrences_3 {
  def countLetterOccurrences(words: List[String]): Int = {
    words.map(_.length).reduce(_ + _)
  }

  def run(): Unit = {
    val wordList = List("apple", "banana", "cherry", "date")
    val result = countLetterOccurrences(wordList)
    println(s"Total count of letter occurrences: $result")
  }
}