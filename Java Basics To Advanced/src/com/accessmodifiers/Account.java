package com.accessmodifiers;

import java.util.ArrayList;

public class Account {
    private String accountHolder;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

     public void deposit(int amount){
       if(amount>0){
           this.transactions.add(amount);
           this.balance += amount;
           System.out.println("amount deposited is "+amount + " and balance is now "+this.balance);
       }
       else
           System.out.println("amount "+ amount + " is less than or equal to zero and can't be deposited");
     }



    public void withdraw(int amount){
        int withdrawal = -amount;
        if(withdrawal < 0){
            this.transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println("amount withdrawn is "+amount + " and balance is now "+this.balance);
        }
        else
            System.out.println("amount "+ amount + " is less than or equal to zero and can't be withdrawn");
    }

    public void calculateBalance(){
        this.balance = 0;
        for(int i:this.transactions){
            this.balance += i;
        }
        System.out.println("The current balance is "+this.balance);
    }
}
