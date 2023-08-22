class Account(val accountNumber: String, var balance: Double) {
  // ... Account class implementation ...

  override def toString: String = s"Account $accountNumber - Balance: $balance"
}

object Bank extends App {
  val accounts: List[Account] = List(
    new Account("A12345", 1000.0),
    new Account("B67890", -500.0),
    new Account("C98765", 2000.0),
    new Account("D54321", -100.0)
  )

  def negativeBalanceAccounts(accounts: List[Account]): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def sumOfBalances(accounts: List[Account]): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterest(accounts: List[Account]): List[Account] = {
    accounts.map { account =>
      if (account.balance > 0) {
        val newBalance = account.balance + account.balance * 0.05
        new Account(account.accountNumber, newBalance)
      } else {
        val newBalance = account.balance + account.balance * 0.1
        new Account(account.accountNumber, newBalance)
      }
    }
  }

  val accountsWithNegativeBalance = negativeBalanceAccounts(accounts)
  println("Accounts with negative balances:")
  accountsWithNegativeBalance.foreach(println)

  val totalBalance = sumOfBalances(accounts)
  println(s"Total balance of all accounts: $totalBalance")

  val accountsAfterInterest = applyInterest(accounts)
  println("Accounts after applying interest:")
  accountsAfterInterest.foreach(println)
}
