package com.bank.system.user;

import com.bank.system.Accounts.Account;
import com.bank.system.Accounts.Savings;
import com.bank.system.Services.Services;
import com.bank.system.data.AccountDetails;
import com.bank.system.Accounts.Current;

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
            int options;
            System.out.print("Select Your Option: ");

            options = sc.nextInt();
            switch (options){
                case 1:
                    if(islogedin==null) {
                        Savings s = new Savings();
                        AccountDetails.accounts.add(s);
                        System.out.println("Need to Deposit Initial Amount");
                        s.deposit();
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
                        c.deposit();
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
                        System.out.println("Enter Account Number");
                        int ac = sc.nextInt();
                        System.out.println("Enter Account Type Saving or Current");
                        String type = sc.next();
                        if (type.equalsIgnoreCase("saving")) {
                            Services temp = AccountDetails.accCheck(ac);
                            if (temp == null)
                                System.out.println("AccountNumber or password is Wrong");
                            else
                                temp.Withdraw();
                        } else if (type.equalsIgnoreCase("current")) {
                            Services temp = AccountDetails.accCheck(ac);
                            if (temp == null)
                                System.out.println("AccountNumber or password is Wrong");
                            else
                                temp.Withdraw();
                        } else
                            System.out.println("Enter write name Saving or Current");
                        sc.nextLine();
                    }
                    else{
                        Services s = (Services) islogedin;
                        s.Withdraw();
                    }
                    System.out.println("\nAccount Withdraw complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 4:
                    if(islogedin==null) {
                        System.out.println("Enter Account Number");
                        int acc = sc.nextInt();
                        System.out.println("Enter Account Type Saving or Current");
                        String types = sc.next();
                        if (types.equalsIgnoreCase("saving")) {
                            Services temp = AccountDetails.accCheck(acc);
                            if (temp == null)
                                System.out.println("Check Account Number or Password");
                            else
                                temp.deposit();
                        } else if (types.equalsIgnoreCase("current")) {
                            Services temp = AccountDetails.accCheck(acc);
                            if (temp == null)
                                System.out.println("Check Account Number or Password");
                            else
                                temp.deposit();
                        } else
                            System.out.println("Enter write name Saving or Current");
                        sc.nextLine();
                    }
                    else{
                        Services s= (Services) islogedin;
                        s.deposit();
                    }
                    System.out.println("\nAccount Deposit complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 5:
                    if(islogedin==null) {
                        System.out.println("Enter Account Number");
                        int accs = sc.nextInt();
                        System.out.println("Enter Account Type Saving or Current");
                        String typess = sc.next();
                        if (typess.equalsIgnoreCase("saving")) {
                            Services temp = AccountDetails.accCheck(accs);
                            if (temp == null)
                                System.out.println("Check Account Number or Password");
                            else
                                temp.accounBalance();
                        } else if (typess.equalsIgnoreCase("current")) {
                            Services temp = AccountDetails.accCheck(accs);
                            if (temp == null)
                                System.out.println("Check Account Number or Password");
                            else
                                temp.accounBalance();
                        } else
                            System.out.println("Enter write name Saving or Current");
                        sc.nextLine();
                    }
                    else
                    {
                        Services s = (Services) islogedin;
                        s.accounBalance();
                    }
                    System.out.println("\nAccount Balance Check complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 6:
                    break;
                case 7:runloop=false;
            }

        }
        System.out.println("Thank You For Visiting");

    }
}