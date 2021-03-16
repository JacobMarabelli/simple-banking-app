package com.bankingapp;
import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Getting user credentials to pull up their account information
        System.out.println("Please enter your first and last name:");
        String fullName = scan.nextLine();
        System.out.println("Please enter your ID number:");
        String idNumber = scan.nextLine();

        Account acct = new Account(fullName, idNumber);
        acct.menuOptions();
    }
}
