package com.bank.system;

import com.bank.system.Accounts.Savings;
import com.bank.system.data.AccountDetails;
import com.bank.system.data.Current;

import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        boolean runloop=true;
        Scanner sc = new Scanner(System.in);
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
                    Savings s = new Savings();
                    AccountDetails.savings.add(s);
                    System.out.println("Need to Deposit Initial Amount");
                    s.deposit();
                    System.out.println("\nAccount setup complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 2:
                    Current c = new Current();
                    AccountDetails.currents.add(c);
                    System.out.println("Need to Deposit Initial Amount");
                    c.deposit();
                    System.out.println("\nAccount setup complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Enter Account Number");
                    int ac= sc.nextInt();
                    System.out.println("Enter Account Type Saving or Current");
                    String type=sc.next();
                    if(type.equalsIgnoreCase("saving")){
                        Savings temp=AccountDetails.savingCheck(ac);
                        if(temp==null)
                            System.out.println("Account don't exist");
                        else
                            temp.Withdraw();
                    }
                    else if(type.equalsIgnoreCase("current")){
                        Current temp=AccountDetails.currentCheck(ac);
                        if(temp==null)
                            System.out.println("Account don't exist");
                        else
                            temp.Withdraw();
                    }
                    else
                        System.out.println("Enter write name Saving or Current");
                    System.out.println("\nAccount Withdraw complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 4: System.out.println("Enter Account Number");
                    int acc= sc.nextInt();
                    System.out.println("Enter Account Type Saving or Current");
                    String types=sc.next();
                    if(types.equalsIgnoreCase("saving")){
                        Savings temp=AccountDetails.savingCheck(acc);
                        if(temp==null)
                            System.out.println("Check Account Number or Password");
                        else
                            temp.deposit();
                    }
                    else if(types.equalsIgnoreCase("current")){
                        Current temp=AccountDetails.currentCheck(acc);
                        if(temp==null)
                            System.out.println("Check Account Number or Password");
                        else
                            temp.deposit();
                    }
                    else
                        System.out.println("Enter write name Saving or Current");
                    System.out.println("\nAccount setup complete! Press Enter to return to the main menu...");
                    sc.nextLine();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:runloop=false;
            }

        }
        System.out.println("Thank You For Visiting");

    }
}