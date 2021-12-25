package com.accessmodifiers;

public class SomeClass {
    /*Please note here classCounter is static so it has nothing to instances of Class
    * It does however gets incremented every time we create a new object of SomeClass
    * as we are incrementing it in a Constructor
    * Also note that the variables instanceNumber and name are final so we either have to provide them values
    * at the places where we have defined  like     public final int instanceNumber = 10;
    * or other option is to give them a value in the Constructor. And since these values are non-static so
    * these values will only be accessed when when we create a object of the Class so providing them values in constructor
    * solved the problem of providing a value to final values.
     */
    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        this.instanceNumber = classCounter;
        System.out.println("Instance created and value of instance number  is "+this.instanceNumber);
    }

    public int getInstanceCounter() {
        return instanceNumber;
    }
}
