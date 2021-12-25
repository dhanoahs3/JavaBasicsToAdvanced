package com.abstraction;
/*Differences between abstract classes and interfaces
* 1.Abstract classes can have variables that are or are not defined
* and we have to provide access modifiers to members in abstract classes
* 2.In case of Interfaces all variables are public ,static and final by default so we can't provide those keywords to them
* and they are by default.
* abstract classes methods can be public ,private etc.
* Abstract classes can have constructors ,sometimes that is not possible in Interfaces
* But abstract classes can never be instantiated.
* 3. Abstract class can extend only one parent class but can implement mmutiple interfaces
* 4. Abstract can use static and non static methods and variables.
* Abstract classes is used to provide a common definition of a base class that multiple child classes can share
* 5.Interfaces can't be instantiated
* 6 .Interfaces can extend another interface
* 7.vvv imp Starting with Java 8, default and static methods may have implementation in the interface definition.
* in jave 9 private and private static methods were added to interfaces
* 8. interfaces are used to implement common behaviour when we are not concerned about who actually implements that behaviour
* 9.List interface is an example of interface where ArrayList and LinkedList implement that interface.
* */

public class Runner {
    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();

        Parrot parrot = new Parrot("australian ringneck");
        parrot.breath();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("zoo penguin");
        penguin.breath();
        penguin.eat();
        penguin.fly();
    }
}
