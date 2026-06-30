package com.bank.system.user;

import com.bank.system.Accounts.Account;
import com.bank.system.Accounts.Savings;
import com.bank.system.MakeAccount.MakeAccount;
import com.bank.system.Services.Services;
import com.bank.system.Transaction.Paypal;
import com.bank.system.Transaction.Transaction;
import com.bank.system.Transaction.creditCard;
import com.bank.system.Transaction.debitCard;
import com.bank.system.data.AccountDetails;
import com.bank.system.Accounts.Current;

import java.sql.SQLOutput;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        boolean runloop=true;
        Scanner sc = new Scanner(System.in);
        MakeAccount my;
        System.out.println("Hello Sir Welcome to Our Bank Here are Options You can Select");
        while(runloop){
            System.out.println("""
                    Press 1 to Open Savings Account
                    Press 2 to Open Current Account
                    Press 3 to Login
                    """);
            System.out.println();
            System.out.println("Select Your Option");
            switch (sc.nextInt()){
                case 1:Savings s = new Savings();
                    my = new MakeAccount();
                    my.makeAccount(s,sc);
                    menu(s,sc);
                    break;
                case 2:Current c = new Current();
                     my = new MakeAccount();
                     my.makeAccount(c,sc);
                     menu(c,sc);
                    break;
                case 3:Services temp=findAccount(sc);
                       if(temp==null){
                           System.out.println("Account Not Found please Check Account Number");
                       }
                       else{
                           menu(temp,sc);
                       }

            }
        }

        System.out.println("Thank You For Visiting");
    }
    private static Services findAccount(Scanner sc) {
        System.out.println("Enter Account Number");
        int ac = sc.nextInt();
        sc.nextLine();
        Services temp = AccountDetails.accCheck(ac);
        if(temp == null)
            System.out.println("Account not found or wrong password");
        return temp;
    }
    private static void menu(Services temp,Scanner sc){
        boolean isrun=true;
        while(isrun){
            System.out.println("""
                    Press 1 for Withdraw
                    Press 2 for Deposit
                    Press 3 for Transaction
                    Press 4 for ShowBalance
                    Press 5 for Logout
                    """);
            System.out.println();
            System.out.println("Enter Your option");
            switch (sc.nextInt()){
                case 1:System.out.println("Enter the amount to Withdraw");
                    temp.Withdraw(sc.nextDouble());
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("Enter the amount to Deposit");
                    temp.deposit(sc.nextDouble());
                    sc.nextLine();
                    break;
                case 3: System.out.println("""
                                Select Payment Mode
                                1 for Paypal
                                2 for CreditCard
                                3 for DebitCard
                                """);
                    int mode = sc.nextInt();
                    Transaction transaction=null;
                    switch (mode) {
                        case 1 -> transaction = new Paypal();
                        case 2 -> transaction = new creditCard();
                        case 3 -> transaction = new debitCard();
                        default -> transaction=null;
                    }
                    if(transaction!=null){
                        Services receiver=AccountDetails.findReceiver(sc);
                        if(receiver!=null) {
                            System.out.println("Enter the Amount");
                            transaction.getDetails(sc.nextDouble(), temp, receiver);
                        }
                        else
                            System.out.println("Account is not present");
                    }
                    break;
                case 4:
                    temp.accounBalance();
                    break;
                case 5:
                    System.out.println("Logging Out....");
                       try {
                           Thread.sleep(300);
                       }
                       catch (InterruptedException e) {
                           // Keeps track of the thread status if interrupted
                           Thread.currentThread().interrupt();
                       }
                    System.out.println("Logged Out Successfully");
                    System.out.println("Returning To Main Menu....");
                    try {
                        Thread.sleep(300);
                    }
                    catch (InterruptedException e) {
                        // Keeps track of the thread status if interrupted
                        Thread.currentThread().interrupt();
                    }
                    return;
                 }



        }

    }
}