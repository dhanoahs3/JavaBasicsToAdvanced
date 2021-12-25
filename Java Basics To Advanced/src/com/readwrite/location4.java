package com.readwrite;

/*To write an object to a file we have to translate the object into a format that can
* be written to a file and can be constructed back to object later on
* The process to convert a data structures like objects into formats that can be written to a file
* is called Serialisation
* For that we have to implement an interface called Serelai
* this interface has no methods and it is just to tell JVM that class objects can be
* serialised.
* We have to also set the serial Version UID field. this is like a version number for the class
* and it has to be private so that no other class can use it.
* If we don't set this value the compiler will throw a warning and create it based on class details
* such as no of fields ,methods etc. If we change a class like change no of fields etc
* we have to change the serial version UID field as well.
* When we read an object from a Stream the run time checks
* the serial version UID with the one contained in the compiled
* class file and if they don't match runtime will throw invalid  class exception
* we don't have to worry about declaring the serial version UID unless we are using serialisation
* */

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/*Serializable does not have methods so we don't have to over ride any when we implement
* Serializable
* And our location4 class has 3 fields int,string and Map
* where int and String are primitive types but Map is an object
* And the map we are using is Hashmap which implements Serializable interface so map
*  will also we serialised */
public class location4 implements Serializable {
    private final int locationId;
    private final String description;
    private final Map<String,Integer> exits;
    private Long serialVersionUID = 1L;

    public location4(int locationId, String description, Map<String,Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        if(exits!=null){
            this.exits = new LinkedHashMap<>(exits);}
        else{
            this.exits = new LinkedHashMap<>();
        }
        this.exits.put("Q",0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits);
    }

    protected void addExit(String direction , Integer location){
        exits.put(direction,location);
    }

}

