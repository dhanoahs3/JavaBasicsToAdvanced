package com.composition;

public class Bed {
    int legs;
    String color;
    int sheets;

    public Bed(int legs, String color, int sheets) {
        this.legs = legs;
        this.color = color;
        this.sheets = sheets;
    }

    public int getLegs() {
        return legs;
    }

    public String getColor() {
        return color;
    }

    public int getSheets() {
        return sheets;
    }

    public void make(){
        System.out.println("making the bed in Bed class");
    }
}
