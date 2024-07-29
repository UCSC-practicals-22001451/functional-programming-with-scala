package practical_6
import scala.io.StdIn.readLine

case class Product(name: String, quantity: Int, price: Double)

object warehouse_management {
  def run(): Unit = {
    var choice = ""
    while (choice != "6") {
      println("\nInventory Management System")
      println("1. List all products")
      println("2. Calculate total value")
      println("3. Check if inventory is empty")
      println("4. Add new product")
      println("5. Find product by ID")
      println("6. Exit")
      print("Enter your choice: ")

      choice = readLine()

      choice match {
        case "1" => listProducts()
        case "2" => calculateTotalValue()
        case "3" => checkIfEmpty()
        case "4" => addNewProduct()
        case "5" => findProduct()
        case "6" => println("Exiting...")
        case _   => println("Invalid choice. Please try again.")
      }
    }
  }
  var inventory = Map(
    101 -> Product("Apple", 100, 0.5),
    102 -> Product("Banana", 150, 0.3),
    103 -> Product("Orange", 75, 0.6)
  )

  def listProducts(): Unit = {
    inventory.foreach { case (id, product) =>
      println(
        f"ID: $id, Name: ${product.name}, Quantity: ${product.quantity}, Price: $${product price}"
      )
    }
  }

  def calculateTotalValue(): Unit = {
    val totalValue = inventory.values.map(p => p.quantity * p.price).sum
    println(f"Total inventory value: $$$totalValue%.2f")
  }

  def checkIfEmpty(): Unit = {
    println(s"Is inventory empty? ${inventory.isEmpty}")
  }

  def addNewProduct(): Unit = {
    print("Enter product ID: ")
    val id = readLine().toInt
    print("Enter product name: ")
    val name = readLine()
    print("Enter quantity: ")
    val quantity = readLine().toInt
    print("Enter price: ")
    val price = readLine().toDouble

    inventory += (id -> Product(name, quantity, price))
    println("Product added successfully.")
  }

  def findProduct(): Unit = {
    print("Enter product ID to find: ")
    val id = readLine().toInt
    inventory.get(id) match {
      case Some(product) =>
        println(
          f"Product found - Name: ${product.name}, Quantity: ${product.quantity}, Price: $${product.price}"
        )
      case None =>
        println("Product not found.")
    }
  }
}
