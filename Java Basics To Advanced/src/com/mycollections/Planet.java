package com.mycollections;

public class Planet extends HeavenlyBody1 {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod,BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody1 moon) {
     //   if(moon.getBodyType() ==BodyTypes.MOON)
        return super.addSatellite(moon);
       // else
       //     return false;
    }
}
