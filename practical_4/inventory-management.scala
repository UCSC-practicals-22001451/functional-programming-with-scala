case class Item(name: String, var quantity: Int)

class InventoryManagement {
  private var items: List[Item] =
    List(Item("Apples", 10), Item("Bananas", 20), Item("Oranges", 15))

  def displayInventory(): Unit = {
    println("Current Inventory:")
    items.foreach(item => println(s"${item.name}: ${item.quantity}"))
  }

  def findItem(itemName: String): Option[Item] = items.find(_.name == itemName)

  def restockItem(itemName: String, quantity: Int): Unit = {
    findItem(itemName) match {
      case Some(item) =>
        item.quantity += quantity
        println(s"Restocked $itemName. New quantity: ${item.quantity}")
      case None =>
        println(s"Item $itemName does not exist in inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    findItem(itemName) match {
      case Some(item) if item.quantity >= quantity =>
        item.quantity -= quantity
        println(
          s"Sold $quantity of $itemName. Remaining quantity: ${item.quantity}"
        )
      case Some(item) =>
        println(
          s"Not enough $itemName in stock to sell. Available quantity: ${item.quantity}"
        )
      case None =>
        println(s"Item $itemName does not exist in inventory.")
    }
  }
}

object InventoryApp extends App {
  val inventory = new InventoryManagement()

  inventory.displayInventory()
  inventory.restockItem("Apples", 5)
  inventory.sellItem("Bananas", 10)
  inventory.sellItem(
    "Oranges",
    20
  )
}
