import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    int customerNumber, pin;
    double currentBalance, savingsBalance, amount = 0;
    DecimalFormat currencyFormat = new DecimalFormat("'£'###,###,##0.00");
    Scanner sc = new Scanner(System.in);

    protected void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    protected void setPIN(int pin) {
        this.pin = pin;
    }

    protected int getCustomerNumber() {
        return customerNumber;
    }

    protected int getPIN() {
        return pin;
    }

    protected double getCurrentBalance() {
        return currentBalance;
    }

    protected double getSavingsBalance() {
        return savingsBalance;
    }

    protected double calcCurrentWithdrawl(double amount) {
        return currentBalance -= amount;
    }

    protected double calcCurrentDeposit(double amount) {
        return currentBalance += amount;
    }

    protected double calcSavingsWithdrawl(double amount) {
        return savingsBalance -= amount;
    }

    protected double calcSavingsDeposit(double amount) {
        return savingsBalance += amount;
    }

    protected void getCurrentWithdrawl() {
        System.out.println("\nCurrent Account Balance: " + currencyFormat.format(currentBalance));
        System.out.print("Amount to withdraw from Current Account: ");
        amount = sc.nextDouble();

        if ((currentBalance - amount) >= 0) {
            calcCurrentWithdrawl(amount);
            System.out.println("New Current Account Balance: " + currencyFormat.format(currentBalance));
        } else {
            System.out.println("Balance cannot be negative. Please try another amount:");
            getCurrentWithdrawl();
        }
    }

    protected void getCurrentDeposit() {
        System.out.println("\nCurrent Account Balance: " + currencyFormat.format(currentBalance));
        System.out.print("Amount to deposit to Current Account: ");
        amount = sc.nextDouble();

        if ((currentBalance + amount) >= 0) {
            calcCurrentDeposit(amount);
            System.out.println("New Current Account Balance: " + currencyFormat.format(currentBalance));
        } else {
            System.out.println("Balance cannot be negative. Please try another amount:");
            getCurrentDeposit();
        }
    }

    protected void getSavingsWithdrawl() {
        System.out.println("\nSavings Account Balance: " + currencyFormat.format(savingsBalance));
        System.out.print("Amount to withdraw from Savings Account: ");
        amount = sc.nextDouble();

        if ((savingsBalance - amount) >= 0) {
            calcSavingsWithdrawl(amount);
            System.out.println("New Savings Account Balance: " + currencyFormat.format(savingsBalance));
        } else {
            System.out.println("Balance cannot be negative. Please try another amount:");
            getSavingsWithdrawl();
        }
    }

    protected void getSavingsDeposit() {
        System.out.println("\nSavings Account Balance: " + currencyFormat.format(savingsBalance));
        System.out.print("Amount to deposit to Savings Account: ");
        amount = sc.nextDouble();

        if ((savingsBalance + amount) >= 0) {
            calcSavingsDeposit(amount);
            System.out.println("New Savings Account Balance: " + currencyFormat.format(savingsBalance));
        } else {
            System.out.println("Balance cannot be negative. Please try another amount:");
            getSavingsDeposit();
        }
    }
}