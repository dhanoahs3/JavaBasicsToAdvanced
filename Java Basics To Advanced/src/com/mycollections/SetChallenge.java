package com.mycollections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallenge {
    private static Map<HeavenlyBody1.Key,HeavenlyBody1> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody1> planets = new HashSet<>();
    public static void main(String[] args) {
        HeavenlyBody1 temp = new Planet("Mercury", 55);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus" ,225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Earth" ,365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        HeavenlyBody1 tempMoon = new Moon("Moon" ,27);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars" ,425);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Phobes" ,30);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Diames" ,35);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter" ,365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Europe" ,55);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Himalia" ,90);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn" ,10079);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Uranus" ,7777);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Neptune" ,15031);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Pluto" ,275);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        System.out.println("Planets:");
        for(HeavenlyBody1 planet :planets){
            System.out.println(planet);
        }

        HeavenlyBody1 body = solarSystem.get(HeavenlyBody1.makeKey("Jupiter",HeavenlyBody1.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        for(HeavenlyBody1 jupiterMoon : body.getSatellites()){
            System.out.println("\t "+jupiterMoon.getKey());
        }

        Set<HeavenlyBody1> moons =  new HashSet<>();

        for(HeavenlyBody1 planet : planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for(HeavenlyBody1 moon : moons){
         //   System.out.println("\t"+tempMoon.getKey());
            System.out.println(moon);
        }

        HeavenlyBody1 pluto = new Planet("Pluto" ,278);
        planets.add(pluto);

        System.out.println("Planets:");
        for(HeavenlyBody1 planet :planets){
            System.out.println(planet);
           // System.out.println("\t"+planet.getName()+" : "+planet.getOrbitalPeriod());
        }
        HeavenlyBody1 earth1 = new Planet("earth",365);
        HeavenlyBody1 earth2 = new Planet("earth",365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(temp));

         /*The below print outputs  depend on this line of code
         *         HeavenlyBody1 pluto = new Planet("Pluto" ,278);
         * if we define pluto as Planet and since pluto as Planet is already added to solar system above
         * and map can't have duplicate keys so the new Planet won't be added below
         * And then if we try to access the values in map based on keys the first one
         * will return true as we are trying to access based on key where BodyType = PLANET
         * and we have one body type for pluto added way above.
         * but if we try to access using Key where bodyType is DWARFPLANET it will print null as there
         * is no value for that key
         * However if we try to add pluto as a DWARFPLANET
         *               HeavenlyBody1 pluto = new DWARFPlanet("Pluto" ,278);
             then it will be a seperate object and hence
         * can be added to the solar system and hence the second print line will print the DWARF PLANET
         * pluto.
         *
         * And also note that when we make a new Planet or dwarfplanet we pass a name, orbitalperiod
         * and body type to constructor and equals method of Heavenly Body just figures out if two objects
         * are equal based on key and key finds out based on name and bodyType
         * so to conclude if object with name pluto and same bodyType planet is created again
         * then that wont't we added to the solarsystem
         * but if we create one with name pluto but bodyType DWARFPLANET then key object comparison
         * passes and that one can be added
         *
         * So way when we try to retrieve values from solarsystem map based on key
         * we create a new key with name and bodytype and if that key matches with a key in the map
         * i.e a key object with same name and bodyType it will give corresponding value otherwise it
         * will print null as there is no key and hence null value.
          */
        solarSystem.put(pluto.getKey(),pluto);
        System.out.println(solarSystem.get(HeavenlyBody1.makeKey("Pluto",HeavenlyBody1.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody1.makeKey("Pluto",HeavenlyBody1.BodyTypes.DWARF_PLANET)));

         System.out.println();
         System.out.println("The solar system contains the following:");
         for(HeavenlyBody1 heavenlyBody1:solarSystem.values()){
             System.out.println(heavenlyBody1);
         }

    }
}
