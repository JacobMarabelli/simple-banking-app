package com.bankingapp;
import java.util.Scanner;

public class Account {
    //Class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Constructor (setting up customer name and id)
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //Method to check balance
    public int checkBalance() {
        return balance;
    }

    //Method to make deposit
    public void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = balance;
        }
    }
    //Method to make withdrawals
    public void withdrawal(int amount) {
        if (amount != 0 && balance > 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    //Method to view previous transactions
    public int viewPreviousTransaction() {
        return previousTransaction;
    }
    //Method to calculate interest
    public void calculateInterest(int years) {
        double interestRate = 0.0055;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + " years, your balance will be " + newBalance);
    }

    //Menu
    public void menuOptions() {
        char selection;
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, " + customerName + "! Your ID is: " + customerID);
        System.out.println("======================================");
        System.out.println("What would you like to do next?");
        System.out.println(" ");
        System.out.println("A. Check my balance.");
        System.out.println("B. Make a deposit into my account.");
        System.out.println("C. Make a withdrawal from my account.");
        System.out.println("D. See my last transaction.");
        System.out.println("E. Calculate interest.");
        System.out.println("F. Exit out of my account.");
        System.out.println(" ");

        do {
            System.out.println("Please enter an option:");
            selection = Character.toUpperCase(scan.next().charAt(0));

            if (selection == 'A') {
                System.out.println("Your current balance is: $" + checkBalance());
            }
            else if (selection == 'B') {
                System.out.println("How much money would you like to deposit?");
                int amountToDeposit = scan.nextInt();
                deposit(amountToDeposit);
                System.out.println("Deposit completed. Your account balance has been updated.");
            }
            else if(selection == 'C') {
                System.out.println("How much money would you like to withdraw?");
                int amountToWithdraw = scan.nextInt();
                withdrawal(amountToWithdraw);
                System.out.println("Withdrawal completed. Your account balance has been updated.");
            }
            else if(selection == 'D') {
                System.out.println("Your last transaction: $" + viewPreviousTransaction());
            }
            else if(selection == 'E') {
                System.out.println("How many years would you like to calculate interest for?");
                int desiredYears = scan.nextInt();
                calculateInterest(desiredYears);
            }
            else if (selection == 'F'){
                System.out.println("Thank you for banking with us. Have a nice day!");
            }
        } while (selection != 'F');
    }
}