package com.bank.system.MakeAccount;

import com.bank.system.Accounts.Account;
import com.bank.system.Services.Services;
import com.bank.system.data.AccountDetails;

import java.util.Scanner;

public class MakeAccount {
    public void makeAccount(Account s, Scanner sc){
        AccountDetails.accounts.add(s);
//        Account islogedin=s;
        System.out.println("Need to Deposit Initial Amount");
        Services a = (Services) s;
        a.deposit(sc.nextDouble());
        sc.nextLine();

    }
}
