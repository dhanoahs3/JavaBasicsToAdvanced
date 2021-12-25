package com.inheritance;

public class Runner {
    public static void main(String[] args) {
     Dog d1 = new Dog(2,4,20,"dog",1,1,"micky");
     System.out.println("The nickname of dog d1 is "+Dog.nickname);
     Dog d2 = new Dog(2,4,20,"dog",1,1,"tommy");
     System.out.println("The nickname of dog d2 is "+Dog.nickname);
     d1.chew();
     d1.move();
     d1.run();
    }
}