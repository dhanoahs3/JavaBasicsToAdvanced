package com.inheritance;

public class Animal {
    String name;
    int brain;
    int body;

    public Animal(String name,int brain,int body){
        this.name = name;
        this.brain = brain;
        this.body = body;
    }

    public void move(){
        System.out.println("Animal moving");
    }

    public void eat(){
        System.out.println("Animal eating");
    }

}
