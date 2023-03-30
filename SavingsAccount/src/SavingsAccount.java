/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */
public class SavingsAccount {

    private float startingBalance;
    private float balance;
    private float withdrawal;
    private float monthlyInterestAmount;
    private float annualInterest;
    private float totalDeposit;
    private float totalWithdrawal;
    private float totalInterestAmount;

    //constructor accepting starting balance
    public SavingsAccount(float startingBalance) {
        this.startingBalance = startingBalance;
        balance = startingBalance;
    }

    // Getters and setters
    public float getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    public float getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(float withdrawal) {
        this.withdrawal = withdrawal;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    private float deposit;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(float startingBalance) {
        this.startingBalance = startingBalance;
        balance=startingBalance;
    }

    public float getMonthlyInterestAmount() {
        return monthlyInterestAmount;
    }

    public void setMonthlyInterestAmount(float monthlyInterestAmount) {
        this.monthlyInterestAmount = monthlyInterestAmount;
    }

    public float getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(float totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public float getTotalWithdrawal() {
        return totalWithdrawal;
    }

    public void setTotalWithdrawal(float totalWithdrawal) {
        this.totalWithdrawal = totalWithdrawal;
    }

    public float getTotalInterestAmount() {
        return totalInterestAmount;
    }

    public void setTotalInterestAmount(float totalInterestAmount) {
        this.totalInterestAmount = totalInterestAmount;
    }

    //calculation methods

    /*
         subtracts withdrawal amount from balance
         keeps withdrawal total history
    */
    public void subWithdrawalAmount() {
        balance -= this.withdrawal;
        totalWithdrawal += withdrawal;
    }

    /*
         adds deposit amount to balance
         keeps deposit total history
    */
    public void addDepositAmount() {
        balance += this.deposit;
        totalDeposit += this.deposit;
    }

    /*
    *    adds interest monthly amount to balance
         keeps interest amount total history
    * */
    public void addMonthlyInterest() {
        float monthlyInterestRate = annualInterest / 12;
        monthlyInterestAmount = (balance * monthlyInterestRate) / 100;
        balance += monthlyInterestAmount;
        totalInterestAmount += monthlyInterestAmount;
    }
}
