package com.abstraction;

public class Parrot extends Bird {

    /**Rules 1.have to define constructor as parent class bird has one.
     * Rule 2. Also since parent class bird implemented methods of eat and breath so we dont have to do that again here
     * we can do it but its not mandatory*/

    public Parrot(String name) {
        super(name);
    }


    @Override
    public void fly() {
        System.out.println(getName() +" is a parrot so it can fly.");
    }
}
