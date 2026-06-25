package com.bank.system.data;

import com.bank.system.Accounts.Account;
import com.bank.system.Accounts.Current;
import com.bank.system.Accounts.Savings;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountDetails {
    public static ArrayList<Savings> savings = new ArrayList<>();
    public static ArrayList<Current> currents = new ArrayList<>();

    public static Savings savingCheck(int ac){
       Savings temp=null;
       for(Savings s:savings){
           if(s.getAccount()==ac && validate(s)){

                   temp=s;
           }
       }
       return temp;
    }

    public static Current currentCheck(int ac){
        Current temp=null;
        for(Current c:currents){
            if(c.getAccount()==ac && validate(c)){

                    temp=c;
            }
        }
        return temp;

    }
    private static boolean validate(Account accounts){
        System.out.println("Enter password of Account");
        Scanner sc = new Scanner(System.in);
        String password;
        password=sc.next();
        if(accounts.checkPassword(password))
            return true;
        else
            return false;

    }
}
