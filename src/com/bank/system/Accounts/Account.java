package com.bank.system.Accounts;

import java.util.Scanner;

public class Account {
    private int count=0;
    private static int accnum=19738;
    final private int accountNumber;
    private String password;
    final private String type;
    protected Account(String type){
        this.accountNumber=accnum;
        while(password==null){
            password=generatepassword();
        }
        this.password=password;
        this.type=type;
        System.out.println("Welcome Your AccountNumber is "+accountNumber);
        accnum++;
    }
    private String generatepassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password");
        String pass;
        pass = sc.next();
        if(pass.length()>15){
            System.out.println("Password Length should not be more then 15 Character");
            return null;
        }
        else if(pass.length()<6){
            System.out.println("Password Length should be More then 6 Characters");
            return null;
        }
        return pass;

    }
    public int getAccount(){
        return accountNumber;
    }
    public final boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    public void incCount(){
        count++;
    }
    public void setback(){
        count=0;
    }
    public int getCount(){
        return count;
    }

}
