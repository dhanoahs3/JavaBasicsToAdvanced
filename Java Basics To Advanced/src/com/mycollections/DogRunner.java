package com.mycollections;

public class DogRunner {
    /*There is a problem in Java at the moment. If we override the equals method in both parent and child class
    * like we did in Dog and Labrador Class and then try to compare a Dog and Labrador object like we did here
    * then Dog(parent object) compares to child object but its not true the other way around.
    * The reason is rover is an instance of Dog but dog itself is not an instance of Labrador
    *  if(obj instanceof Labrador).
    * so the best way to solve this problem is NOT to override the equals and also Set method in child classes
    * So we comment the override method in Labrador. or we can mark the over-riden method in
    * Parent class Dog as final and then in both cases it returns true.
    * */
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog dog = new Dog("Rover");
        System.out.println(dog.equals(rover));
        System.out.println(rover.equals(dog));
    }
}
