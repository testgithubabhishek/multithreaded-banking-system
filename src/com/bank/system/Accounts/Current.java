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
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            // Keeps track of the thread status if interrupted
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public boolean deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount entered");
            return false;
        } else {
            balance += amount;

        }

       return true;
    }

    @Override
    public boolean Withdraw(double amount) {
        if(balance<0 || amount>balance){
            System.out.println("Insufficient Balance");
            return false;
        }
        else if(amount>500000)
        {
            System.out.println("Max Withdraw is 500000");
        }
        else {
            balance -= amount;
            return true;
        }
        return false;
    }
}
