package com.mycollections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*please note that sets don't allow us to add duplicates
* And we can create an empty set and add many sets to it
* like here we created a hashset moon and then iterated through all the planets and for each planet got its
* satellites set and added them all to moon
*  for(HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }
        *To iterate through each element of a Set.Here planets is the name of the set and since the set
        * contains objects of class HeavenlyBody so iterating will generate HeavenlyBody and then we can
        * use getName on that object to get the names of the objects.
        * for(HeavenlyBody planet :planets){
            System.out.println("\t"+planet.getName());
        }
        *
        * Same way we can do this . Here first we try to get body object from solarSystem  mao based on key
        * "Jupiter" and then for that object we use getSatellites method and since that method returns a copy
        * of a HashSet we can then iterate over each object of that Hashset and use getName to get their names.
        *  HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody jupiterMoon : body.getSatellites()){
            System.out.println("\t "+jupiterMoon.getName());
        }
        *
        *
        * Also please note that although hashset can't contain duplicate objects
        * what we have done in the code is ,we have added two pluto ojects to it and it is printing both of
        * them . The reason why its happening is because the basic equality method defined in object class
        * from which all other classes extend just checks  for referencial equality i.e
        * if two references point to same object only then it considers them equal .but if two separate objects
        * are created even if they have same class variables etc they are considered different.
        * that's why we were able to add two pluto objects.
        * For example if we consider this
        * Object o = new Object();
        System.out.println("Are objects equal "+o.equals(o));
        * and look at the equals method we see it just compares using == that is referencial
        * equality as discussed above.
        * But if we look at the equality method of a String its does lot more
        *         System.out.println("Are objects equal "+ "pluto".equals(" "));
        *
        * Also note that only and only when hash codes are equal ,then equals method is called ,so its very
        * important to override hashcode method as well ,when we are overriding equals.
        * like for example hashCode is called every time we add a new Heavenly Body
        * but only when there hashCodes are equal like in our case when pluto is added again the hashCode
        * is equal ,only then the equals method is called
        * And since we have overloaded the equals methods so two plutos with same name will not be added
        * to the set.So in nut shell every time we add an object to a HashSet Hashcode methof is called
        * but only when we add same object to HashSet again the equals is called.

 * */

public class HeavenlyBodyRunner {
    private static Map<String,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury" ,55);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus" ,225);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth" ,365);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon" ,27);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars" ,425);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Phobes" ,30);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Diames" ,35);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Jupiter" ,365);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Europe" ,55);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Himalia" ,90);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Saturn" ,10079);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus" ,7777);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune" ,15031);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto" ,275);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        System.out.println("Planets:");
        for(HeavenlyBody planet :planets){
            System.out.println("\t"+planet.getName());
        }

        System.out.println("=============================================");

        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody jupiterMoon : body.getSatellites()){
            System.out.println("\t "+jupiterMoon.getName());
        }
        System.out.println("=============================================");


        Set<HeavenlyBody> moons =  new HashSet<>();

        for(HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for(HeavenlyBody moon : moons){
            System.out.println("\t"+moon.getName());
        }

        System.out.println("============Adding pluto again =================");

        temp = new HeavenlyBody("Pluto" ,278);
        System.out.println("before adding pluto ");
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        System.out.println("Planets:");
        for(HeavenlyBody planet :planets){
            System.out.println("\t"+planet.getName()+" : "+planet.getOrbitalPeriod());
        }

        Object o = new Object();
        System.out.println("Are objects equal "+o.equals(o));
        System.out.println("Are objects equal "+ "pluto".equals(" "));







        }
}