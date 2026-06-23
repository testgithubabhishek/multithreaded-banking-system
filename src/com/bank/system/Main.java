package com.bank.system;

import java.util.ArrayList;
import java.util.Scanner;

class Accounts {
    private final int AccountNumber;
    private int password;
    Accounts(int AccountNumber,int password){
        this.AccountNumber=AccountNumber;
        this.password=password;
        AccountDetails.details.add(this);
    }
    public static void showAccountDetails(Accounts temp){
        System.out.println("Account Number is "+temp.AccountNumber);

    }

}
class AccountDetails{
    static ArrayList<Accounts> details = new ArrayList<>();
}

class Main{
    public static void main(String[] args) {
        Accounts a1;
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<5;i++){
            System.out.println("Enter account Number");
            int account = sc.nextInt();
            System.out.println("Enter Password");
            int password = sc.nextInt();
            a1=new Accounts(account,password);

        }
        for(int i=0;i<AccountDetails.details.size();i++){
            Accounts.showAccountDetails(AccountDetails.details.get(i));
//            System.out.println(AccountDetails.details.get(i).showAccount());
        }

    }
}
