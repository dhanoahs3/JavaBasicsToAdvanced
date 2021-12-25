package com.accessmodifiers;

public class StaticBlockRunner {

    public static void main(String[] args) {
    System.out.println("Main method called");
    StaticInitilizationBlock sib = new StaticInitilizationBlock();
    sib.printMethod();
    System.out.println("My name  is " + sib.name );
        System.out.println("My name can be also accessed like this as well and is " + StaticInitilizationBlock.name );

    }
}