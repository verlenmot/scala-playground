package basic


// Manual Class
class BankAccount(val accountHolder: String, val balance: Int = 0) {
  def add(amount: Int): BankAccount = new BankAccount(accountHolder, balance + amount)

  def remove(amount: Int): BankAccount = new BankAccount(accountHolder, balance - amount)

  def copy: BankAccount = new BankAccount(accountHolder, balance) // Copy all

  def transferAccount(newAccountHolder: String): BankAccount = new BankAccount(newAccountHolder, balance) // Copy balance, adjust holder
  def adjustBalance(newBalance: Int): BankAccount = new BankAccount(accountHolder, newBalance) // Copy holder, adjust balance
}

// Case class
case class CaseBankAccount(accountHolder: String, balance: Int = 0) {
  def add(amount: Int) = CaseBankAccount(accountHolder, balance + amount)
  def addVariant(amount: Int) = this.copy(balance = this.balance + amount)
  def remove(amount: Int) = CaseBankAccount(accountHolder, balance - amount)
  def removeVariant(amount: Int) = this.copy(balance = this.balance - amount)
//  def copy: CaseBankAccount = this.copy // Already implemented in case classes
  def transferAccount(newAccountHolder: String): CaseBankAccount = this.copy(accountHolder = newAccountHolder)
  def adjustBalance(newBalance: Int): CaseBankAccount = this.copy(balance = newBalance)
}


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

    // Case
    val caseAccount = CaseBankAccount("John")
    println(caseAccount.add(2000).balance)
    println(caseAccount.addVariant(2000).balance)
    println(caseAccount.remove(300).balance)
    println(caseAccount.removeVariant(300).balance)

    val caseCopyAccount = caseAccount.copy()
    println(caseCopyAccount == caseAccount)
    println(caseCopyAccount.accountHolder, caseCopyAccount.balance, caseAccount.accountHolder, caseAccount.balance)
    val caseTransferAccount = caseAccount.transferAccount("Daniel")
    println(caseTransferAccount.accountHolder)
    val caseAdjustedAccount = caseAccount.adjustBalance(3000)
    println(caseAdjustedAccount.balance)
    val caseAdjustedTransferedAccount = caseAccount.transferAccount("Will").adjustBalance(1600)
    println(caseAdjustedTransferedAccount.accountHolder, caseAdjustedTransferedAccount.balance)
  }
}
