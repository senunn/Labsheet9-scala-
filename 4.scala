class Account(val accountNumber: String, var balance: Double) {
  require(balance >= 0, "Balance cannot be negative")

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited $amount. New balance: $balance")
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Insufficient balance for withdrawal")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      balance -= amount
      toAccount.balance += amount
      println(s"Transferred $amount to account ${toAccount.accountNumber}. New balance: $balance")
    } else {
      println("Insufficient balance for transfer")
    }
  }

  override def toString: String = s"Account $accountNumber - Balance: $balance"
}

object Main extends App {
  val account1 = new Account("A12345", 1000.0)
  val account2 = new Account("B67890", 500.0)

  println(account1)
  println(account2)

  account1.deposit(200.0)
  account2.withdraw(100.0)

  account1.transfer(300.0, account2)

  println(account1)
  println(account2)
}
