package com.composition;

public class Runner {
    /*Compostion - So here we are using composition which should be preferred over inheritance and should be used
    * if the classes don't have a parent -child relationship. So here we see in the Bedroom constructor we pass
    * objects of classes like wall,ceiling and lamp. and since we have a getter method in bedroom that returns an lamp
    * what we can do is use that lamp object to access method turnOn of lamp class. So point is bedroom can't extend lamp
    * class but we can use its object to access its methods like we did here
    *         bedroom1.getLamp().turnOn();
     */
    public static void main(String[] args) {
        Wall wall1 = new Wall("east");
        Wall wall2 = new Wall("west");
        Wall wall3 = new Wall("north");
        Wall wall4 = new Wall("south");

        Ceiling ceiling = new Ceiling(50,"blue");
        Bed bed = new Bed(4,"brown",2);
        Lamp lamp = new Lamp("velvet",true);
        Bedroom bedroom1 = new Bedroom("My bedroom",wall1,wall2,wall3,wall4,ceiling,bed,lamp);
        bedroom1.makeBed();
        bedroom1.getLamp().turnOn();
    }
}