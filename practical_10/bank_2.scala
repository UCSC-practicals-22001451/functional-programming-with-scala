package practical_10

object bank_2 {
  def run(): Unit = {
    // Account class
    class Account(val accountNumber: String, private var balance: Double) {
      def getBalance: Double = balance

      def deposit(amount: Double): Unit = {
        require(amount > 0, "Deposit amount must be positive")
        balance += amount
      }
      def deduct(amount: Double): Unit = {
        require(amount > 0, "Deduct amount must be positive")
        balance -= amount
      }

      def withdraw(amount: Double): Unit = {
        require(amount > 0, "Withdrawal amount must be positive")
        require(amount <= balance, "Insufficient funds")
        balance -= amount
      }

      def transfer(amount: Double, toAccount: Account): Unit = {
        require(amount > 0, "Transfer amount must be positive")
        require(amount <= balance, "Insufficient funds")
        withdraw(amount)
        toAccount.deposit(amount)
      }
    }

    // Bank class
    class Bank(private var accounts: List[Account] = List()) {
      def addAccount(account: Account): Unit = {
        accounts = account :: accounts
      }

      def accountsWithNegativeBalance: List[Account] = {
        accounts.filter(_.getBalance < 0)
      }

      def totalBalance: Double = {
        accounts.map(_.getBalance).sum
      }

      def applyInterest(): Unit = {
        accounts.foreach { account =>
          val balance = account.getBalance
          val interest = if (balance >= 0) balance * 0.05 else balance * 0.1
          if (interest > 0) account.deposit(interest)
          else account.deduct(-interest)
        }
      }
    }

    // Example usage

        val bank = new Bank()

        val account1 = new Account("001", 1000)
        val account2 = new Account("002", -500)
        val account3 = new Account("003", 2000)

        bank.addAccount(account1)
        bank.addAccount(account2)
        bank.addAccount(account3)

        println("Accounts with negative balance:")
        bank.accountsWithNegativeBalance.foreach(a => println(s"Account ${a.accountNumber}: ${a.getBalance}"))

        println(s"\nTotal balance: ${bank.totalBalance}")

        println("\nApplying interest...")
        bank.applyInterest()

        println("\nFinal balances:")
        List(account1, account2, account3).foreach(a => println(s"Account ${a.accountNumber}: ${a.getBalance}"))
      }
    }
  

