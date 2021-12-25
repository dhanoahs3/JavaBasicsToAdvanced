package com.abstraction;
/*Abstract class can have abstract and non abstract members . Opposite to interface where every thing needs to be abstract
* And if we want to define some abstract members in the class for example some methods that don't have a body we have to
* put the keyword abstract in front of them*/
public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat();
    public abstract void breath();



}
