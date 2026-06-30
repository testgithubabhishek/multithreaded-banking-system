package com.bank.system.Transaction;

import com.bank.system.Services.Services;

public class debitCard implements Transaction{
    public void getDetails(double amount, Services sender, Services receiver) {
        System.out.println("Money is Transferring through "+getMode()+".....");
        try {
            // 3000 milliseconds = 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // Keeps track of the thread status if interrupted
            Thread.currentThread().interrupt();
        }
        if(sender.Withdraw(amount) &&  receiver.deposit(amount)) {
            System.out.println("Transaction Complete");
        }
        else
            System.out.println("Transaction failed");
        try {
            // 3000 milliseconds = 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // Keeps track of the thread status if interrupted
            Thread.currentThread().interrupt();
        }
    }
    @Override
    public String getMode() {
        return "DebitCard";
    }

}
