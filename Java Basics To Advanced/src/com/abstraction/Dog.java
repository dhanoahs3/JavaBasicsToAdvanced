package com.abstraction;

public class Dog extends Animal {
    /*We have to define a constructor for child class and make call to super constructor if constructor in parent
    * class is accepting arguments
    * Also note that we can make call to getName method of parent abstract class and dog is a child class of animal
    * and that method getName is already defined in parent class so we dont have to override it*/
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+ " is eating");
    }

    @Override
    public void breath() {
        System.out.println("Animal is breathing");
    }
}
