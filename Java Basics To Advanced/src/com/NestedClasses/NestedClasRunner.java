package com.NestedClasses;

public class NestedClasRunner {

    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
        //if nested class is public we can simply create its object like this
        //please note we first make object of outer class above and reference it as mcLaren
        //then we create object of inner class like this
        //OuterClass.InnerClass reference = referenceforouterclass.new InnerClass();
        //GearBox.Gear first = mcLaren.new Gear(1,12.3);
        //System.out.println(first.driveSpeed(1000));
      /*But if our inner class is  private we can't use the above methods.
      * So for that we can have define some methods which we defined in the nested classes and then use them as below*/
      mcLaren.operatingClutch(true);
      mcLaren.changeGear(1);
      mcLaren.operatingClutch(false);
      System.out.println(mcLaren.wheelSpeed(1000));
      mcLaren.changeGear(2);
      System.out.println(mcLaren.wheelSpeed(3000));
      mcLaren.operatingClutch(true);
      mcLaren.changeGear(3);
      mcLaren.operatingClutch(false);
      System.out.println(mcLaren.wheelSpeed(6000));



    }
}