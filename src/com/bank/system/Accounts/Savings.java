package com.bank.system.Accounts;

import com.bank.system.data.Transactions;

import java.util.Scanner;

public class Savings extends Account implements Transactions {
     static final double interestrate=2.5;
     private double balance;
     public Savings(){
         super("Savings");

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
        else if(amount>500000)
        {
            System.out.println("Max Withdraw is 500000");
        }
        else
        balance-=amount;

    }
}
