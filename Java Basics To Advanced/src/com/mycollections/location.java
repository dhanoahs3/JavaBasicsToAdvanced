package com.mycollections;

import java.util.HashMap;
import java.util.Map;

/*Please note that in getter from exits we are not returning the actual map but instead we are creating
* a copy of the map so that actual map is not effected in any way
* And as we know from Arraylists we can create a copy of List or map by passing the actual map to the
* constructor of the new map ,where newHashmap<String,Integer> is the new hashmap and (exits) is the
* actual map to be copied that is being passed to the constructor here.
* public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    * */

public class location {
    private final int locationId;
    private final String description;
    private final Map<String,Integer> exits;

    public location(int locationId, String description,Map<String,Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        if(exits!=null){
        this.exits = new HashMap<>(exits);}
        else{
            this.exits = new HashMap<>();
        }
        this.exits.put("Q",0);
    }

    /*  public void addExit(String direction ,int location){
        exits.put(direction,location);
     }*/
    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
