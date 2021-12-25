package com.readwrite;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LocationRunner2 {

    private static  Locations5 locations = new Locations5();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        Map<String,String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");

        int loc = 1;
        location4 currentLocation =  locations.getLocation(loc);
        while (true) {
            System.out.println(currentLocation.getDescription());

            if (currentLocation.getLocationId()==0)
                break;
            Map<String,Integer> exits = currentLocation.getExits();
            System.out.println("Available directions are: ");
            for(String exit:exits.keySet()){
                System.out.print(exit+ ", ");
            }
            System.out.println();
            String directions = scanner.nextLine().toUpperCase();
            if(directions.length()>1){
                String[] words = directions.split(" ");
                for(String word:words){
                    if(vocabulary.containsKey(word)){
                        directions = vocabulary.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(directions)){
                currentLocation = locations.getLocation(currentLocation.getExits().get(directions));
            }
            else{System.out.println("You cannot go to that direction");
            }
        }
        locations.close();
        String[] road = "You are standing at the end of the road before a small brick building".split(" ");
        for(String s :road){
            System.out.println(s);
        }

        System.out.println("====================================================================================");
        String[] building  = "You are inside a building,a well house for a small spring".split(",");
        for(String b :building){
            System.out.println(b);
        }


    }
}

