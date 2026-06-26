package com.bank.system.user;

import com.bank.system.Accounts.Account;
import com.bank.system.Accounts.Savings;
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
        Account islogedin=null;
        System.out.println("Hello Sir Welcome to Our Bank Here are Options You can Select");
        while(runloop){
            System.out.println("""
                    Options
                    Press 1 to Open SavingsAccount
                    Press 2 to Open CurrentAccount
                    Press 3 to Withdraw Money
                    Press 4 to Deposit Money
                    Press 5 to SeeAccount Balance
                    Press 6 to do Transaction
                    Press 7 to Exit
                    """);
            System.out.println();
            int options;
            System.out.print("Select Your Option: ");

            options = sc.nextInt();
            switch (options){
                case 1:
                    if(islogedin==null) {
                        Savings s = new Savings();
                        AccountDetails.accounts.add(s);
                        System.out.println("Need to Deposit Initial Amount");
                        s.deposit(sc.nextDouble());
                        islogedin=s;
                        sc.nextLine();
                        System.out.println("\nAccount setup complete! Press Enter to return to the main menu...");
                        sc.nextLine();
                    }
                    else
                        System.out.println("You already logged in with AccountNumber "+islogedin.getAccount());


                    break;
                case 2:
                    if(islogedin==null) {
                        Current c = new Current();
                        AccountDetails.accounts.add(c);
                        System.out.println("Need to Deposit Initial Amount");
                        c.deposit(sc.nextDouble());
                        islogedin=c;
                        sc.nextLine();
                        System.out.println("\nAccount setup complete! Press Enter to return to the main menu...");
                        sc.nextLine();

                    }
                    else
                        System.out.println("You already logged in with AccountNumber "+islogedin.getAccount());
                    break;
                case 3:
                    if(islogedin==null) {
                        Services temp=findAccount(sc);
                        if(temp!=null) {
                            System.out.println("Enter the amount to Withdraw");
                            temp.Withdraw(sc.nextDouble());
                        }
                        sc.nextLine();
                    }
                    else{
                        Services s = (Services) islogedin;
                        System.out.println("Enter the amount to Withdraw");
                        s.Withdraw(sc.nextDouble());
                        sc.nextLine();
                    }
                    System.out.println("\nAccount Withdraw complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 4:
                    if(islogedin==null) {
                       Services temp = findAccount(sc);
                       if(temp!=null) {
                           System.out.println("Enter the amount to deposit");
                           temp.deposit(sc.nextDouble());
                       }
                    }
                    else{
                        Services s= (Services) islogedin;
                        System.out.println("Enter the amount to deposit");
                        s.deposit(sc.nextDouble());
                    }
                    System.out.println("\nAccount Deposit complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 5:
                    if(islogedin==null) {
                        Services temp = findAccount(sc);
                        if(temp!=null)
                            temp.accounBalance();
                    }
                    else
                    {
                        Services s = (Services) islogedin;
                        s.accounBalance();
                    }
                    System.out.println("\nAccount Balance Check complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 6:
                    if(islogedin!=null) {
                        System.out.println("""
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
                                transaction.getDetails(sc.nextDouble(), (Services) islogedin, receiver);
                            }
                            else
                                System.out.println("Account is not present");
                        }
                    }
                    break;
                case 7: {
                        runloop = false;
                        islogedin=null;
                    System.out.println("Logged out successfully");
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
}