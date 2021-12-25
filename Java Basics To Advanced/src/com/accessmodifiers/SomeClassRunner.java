package com.accessmodifiers;

public class SomeClassRunner {
    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");
        System.out.println(one.getInstanceCounter());
        System.out.println(two.getInstanceCounter());
        System.out.println(three.getInstanceCounter());



    }
}
