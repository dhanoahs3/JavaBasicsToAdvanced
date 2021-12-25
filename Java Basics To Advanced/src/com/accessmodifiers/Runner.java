package com.accessmodifiers;

public class Runner {
    /*Access modifiers. very simple concepts.
    * if we define some variables in a class like in our class Account we have 3 variables
    * accountHolder , balance and transactions and we should make all of them private
    * because if we make them public we can access any of them directly in this class and then modify it directly like this
    *       //  hsaccount.transactions.add(500);
    * and then if we try to get balance after that using         hsaccount.calculateBalance();
    * it will not show correct balance
    * So better make variables private and methods used to access them as public
    * Types of access modifiers
    * 1.Public - can be accessed in any Class in any package
    * 2.default - also known as package public. can be accessed in any class of same package.
    * 3. private can be only accessed in the same class
    * 4. protected - can be only accessed in the same package AS WELL AS SUBCLASSES in DIFFERENT PACKAGES.
    * Rule is to define Class or Interface as public and members are private or public.
    * But we cannot define a Class as private and then try to define members as public . this will throw an error.
     */
    public static void main(String[] args) {
        Account hsaccount = new Account("hs");
         hsaccount.deposit(1000);
         hsaccount.withdraw(100);
         hsaccount.deposit(-100);
         hsaccount.withdraw(-300);
         hsaccount.calculateBalance();
       //  hsaccount.transactions.add(500);
        hsaccount.calculateBalance();



    }
}