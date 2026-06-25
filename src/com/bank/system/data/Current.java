package com.bank.system.data;

import com.bank.system.Accounts.Account;

import java.util.Scanner;

public class Current extends Account implements Services{
   private double balance;
   public Current(){
        super("Current");
    }

    @Override
    public void accounBalance() {
        System.out.println("Account Balance is "+balance);
    }

    @Override
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Amount you want to Deposit");
        double amount=sc.nextDouble();
        balance+=amount;
    }

    @Override
    public void Withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Amount you want to WithDraw");
        double amount=sc.nextDouble();
        if(balance<0 || amount>balance){
            System.out.println("Insufficent Balance");
        }
        else
            balance-=amount;
    }
}
