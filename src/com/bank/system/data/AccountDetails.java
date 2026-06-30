package com.bank.system.data;

import com.bank.system.Accounts.Account;
import com.bank.system.Accounts.Current;
import com.bank.system.Accounts.Savings;
import com.bank.system.Services.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//import static com.sun.tools.javac.jvm.ByteCodes.illegal;

public class AccountDetails {
    public static ArrayList<Account> accounts = new ArrayList<>();
//    public static ArrayList<Current> currents = new ArrayList<>();

    public static Services accCheck(int ac){
       for(Account s:accounts){
           if(s.getAccount()==ac && validate(s)) {
               return (Services) s;
              }
           }

       return null;
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
    public static Services findReceiver(Scanner sc){
        System.out.println("Enter Receiver Account Number");
        int account=sc.nextInt();
        for(Account s:accounts){
            if(s.getAccount()==account){
                return (Services) s;
            }
        }
        return null;
    }
}
