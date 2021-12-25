package com.composition;

public class Lamp {
    String color;
    boolean battery;

    public Lamp(String color, boolean battery) {
        this.color = color;
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public boolean isBattery() {
        return battery;
    }

    public void turnOn(){
        System.out.println("Turning the lamp on in Lamp class");
    }
}
