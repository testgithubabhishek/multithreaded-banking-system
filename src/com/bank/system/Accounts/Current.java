package com.bank.system.Accounts;

import com.bank.system.Services.Services;

import java.util.Scanner;

public class Current extends Account implements Services {
   private double balance;
   public Current(){
        super("Current");
    }

    @Override
    public void accounBalance() {
        System.out.println("Account Balance is "+balance);
    }

    @Override
    public void deposit(double amount) {
        if(amount<0){
            System.out.println("Invalid amount entered");
        }
        balance+=amount;
    }

    @Override
    public void Withdraw(double amount) {
        if(balance<0 || amount>balance){
            System.out.println("Insufficient Balance");
        }
        else if(amount>500000)
        {
            System.out.println("Max Withdraw is 500000");
        }
        else
            balance-=amount;
    }
}
