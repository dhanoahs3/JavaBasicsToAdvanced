package com.abstraction;

public class Penguin extends Bird implements canFly {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println(getName() +" is a penguin so can't fly");
    }
}
