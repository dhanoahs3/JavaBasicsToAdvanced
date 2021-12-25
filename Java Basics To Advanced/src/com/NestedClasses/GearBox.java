package com.NestedClasses;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 1;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral  = new Gear(0,0.0);
        this.gears.add(neutral);
        for(int i =0;i<maxGears; i++){
            addGear(1,i*5.3);
        }
    }

    public void operatingClutch(boolean in){
        this.clutchIsIn = in;
    }

    public void addGear(int number ,double ratio){
        if((number>0) && (number <=maxGears)){
            this.gears.add(new Gear(number,ratio));
        }
    }

    public void changeGear(int newGear){
        if((newGear>=0) && (newGear<this.gears.size()) && this.clutchIsIn){
            this.currentGear = newGear;
            System.out.println("Gear "+newGear +" selected");
        }
        else
        {
            System.out.println("Grind");
            this.currentGear = 0;
        }
    }
    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("Scream!!");
            return 0.0;
        }
        return revs*gears.get(currentGear).getRatio();
    }
    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber; //this.gearNumber means here we are referring to gearNumber of inner class
            //if there we no gearNumber in inner class then this.gearNumber would have referred to gearNumber of outer class
            //we can rename the gearNumber of outer class to currentGear to avoid any confusion
            this.ratio = ratio;
        }

        public double driveSpeed(int speed) {
            return speed * ratio;
        }

        public double getRatio() {
            return ratio;
        }
    }
  }