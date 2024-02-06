package basic


// Manual Class
class BankAccount(val accountHolder: String, val balance: Int = 0) {
  def add(amount: Int) = new BankAccount(accountHolder, amount)
  def remove(amount: Int) = new BankAccount(accountHolder, balance - amount)
  def copy = new BankAccount(accountHolder, balance) // Copy all
  def transferAccount(newAccountHolder: String) = new BankAccount(newAccountHolder, balance) // Copy balance, adjust holder
  def adjustBalance(newBalance: Int) = new BankAccount(accountHolder, newBalance) // Copy holder, adjust balance
}

// Case class

object CaseMain {
  def main(args: Array[String]): Unit = {

    // Manual
    val account = new BankAccount("John")
    println(account.add(2000).balance)
    println(account.remove(300).balance)

    val copyAccount = account.copy
    println(copyAccount == account)
    println(copyAccount.accountHolder, copyAccount.balance, account.accountHolder, account.balance)
    val transferAccount = account.transferAccount("Daniel")
    println(transferAccount.accountHolder)
    val adjustedAccount = account.adjustBalance(3000)
    println(adjustedAccount.balance)
    val adjustedTransferedAccount = account.transferAccount("Will").adjustBalance(1600)
    println(adjustedTransferedAccount.accountHolder, adjustedTransferedAccount.balance)

  }
}
