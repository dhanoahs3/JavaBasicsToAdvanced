package com.abstraction;
/*Rules 1.define an constructor for child class if parent class has one with arguments and give call to that
contructor fo super class Since bird class extends abstract class animal so it has to define an argument constructor
 Rule 2
 Since bird class is abstract so we cn overide some methods of parent class animal like methods eat and breath
 but we can also leave some methods without defining if we want*/
public abstract class Bird extends Animal implements canFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+ " is picking");
    }

    @Override
    public void breath() {
        System.out.println(getName() + " is breathing");
    }

    @Override
    public void fly() {
        System.out.println(getName() +" trying to fly");
    }

}
