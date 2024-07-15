def main(args: Array[String]) : Unit = {
  val inventory = List(
    ("Apple", 10),
    ("Banana", 20),
    ("Orange", 30),
    ("Pineapple", 40)
  )

  val inventoryManagement = List(
    (quantity: Int) => quantity * 2,
    (quantity: Int) => quantity * 3,
    (quantity: Int) => quantity * 4,
    (quantity: Int) => quantity * 5
  )

  inventory.zip(inventoryManagement).foreach { case ((item, quantity), management) =>
    println(s"Item: $item, Quantity: ${management(quantity)}")
  }
}