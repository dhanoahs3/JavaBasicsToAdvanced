package com.mycollections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*Sets don't allow duplicate values. want to add duplicates ,then go with lists
* when we use keySet method on a map it basically returns a Set of Keys from a Map
* Operations on Sets are very fast
* Set is basically a Map with key as the key it stores and value is basically null
* And if we iterate through the items of a set we have to use an iterator . we don't have a method called
* /get(0) for a Set. for that we have to use a list.
* What we can do is use  a for loop to loop through all items of a Set
* for(HeavenlyBody planet :planets){
            System.out.println("\t"+planet.getName())
* Please note that in our class HeavenlyBodyRunner if we add two pluto objects both were added to Set
* as both are considered different objects as the default equality method only checks for referential equality
* that is two objects are considered equal if two references points to same object
* But if we want two objects to be considered same based on some variable like in our case if we want to check
* if name is same we override the equals and hashcode method
*     public boolean equals(Object obj) {
Please note its very imp to pass arguments of type "Object" to above method otherwise the equals never works
        }*/
public class HeavenlyBody {
    private final String name;
    private final  double orbitalPeriod;
    private final  Set<HeavenlyBody> satellites ;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        return new HashSet<HeavenlyBody>(this.satellites);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        System.out.println("obj.getClass() is "+obj.getClass());
        System.out.println("this.getClass() is "+this.getClass());
//        If class is not equal i.e if class for obj or this class ins not same i.e mycollections.HeavenlyBody
        if(obj==null||obj.getClass()!=this.getClass())
            return false;
        String objName = ((HeavenlyBody)obj).getName();
        System.out.println(this.name + "============"+((HeavenlyBody)obj).getName());
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {

        //Every instance of an object has hash code  0 so it misses the purpose somehow.
        // So all objects will have same hash code and will end in same bucked.So we will
        //have to add a random no to the hashcode so that its not 0.


        /*Hashcode will be called when we need to compare two Heavenly Body objects , but if of the objects
         * have same hash code i.e if they are in the same bucket then equals will be called
         * and it will compare the objects using equals method as well*/

        System.out.println("hashCode is "+this.name.hashCode()+57);

        return this.name.hashCode()+57;
    }
}
