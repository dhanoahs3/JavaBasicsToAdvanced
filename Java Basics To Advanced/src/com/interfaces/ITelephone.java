package com.interfaces;

public interface ITelephone {
    /*Interface names should start with a capital I and we can create interface by clicking new and
    * choosing an interface instead of a class
    * And as we know in an interface all the members(variables and methods) are public by default and none of them can
    * be initialised or defined respectively.
    * So any class that implements an interface has to initialise all its variables and define all its methods and if
    * it don't define all the variables or methods then that class becomes an abstract class and other classes that extend
    * that class will have to implement all the methods of abstract class
    * And  difference between abstract classes and interfaces are -
    * 1.a child class can only extend one child class but can implement multiple interfaces
    * 2 .an abstract class can have both defined and undefined methods but an interface can only have undefined methods
    * 3. this one is a similarity. None of the abstract class or interface can be instantiated. However both can reference
    * to objects of base class like this
    *  ITelephone myphone;
        myphone = new DeskPhone(123456); //Desktop phone is a base class and ITelephone is an interface.
    * */
    void powerOn();
    void dial(int phoneNumber);
    boolean callNumber(int phoneNumber);
    void answer();
    void isRinging();

}
