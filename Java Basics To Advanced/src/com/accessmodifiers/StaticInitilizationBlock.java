package com.accessmodifiers;

public class StaticInitilizationBlock {
    /*A class can have as many static initialisation blocks as we want
    * Please note that all static initialisation blocks are executed before the execution of class constructor
    * when ever we make a new object of the class. So here the block 1 and 2 will be executed before the constructors
    * is executed
    * So static blocks are the first ones to be loaded into JVM when we execute a program
    * A very important use of static initialisation block is providing values to static final values
    * like below we provided value to final static variable name.
    * The same way we use constructor to provide values to final non-static variables.*/
    public static final String name;
    static{
        System.out.println("In the first static block");
        name = "hs";
    }

    public StaticInitilizationBlock() {
        System.out.println("In the class constructor");
    }

    static{
        System.out.println("In the second static block");
    }

    public void printMethod(){
        System.out.println("In the print method");
    }
}
