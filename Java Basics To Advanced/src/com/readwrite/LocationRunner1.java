package com.readwrite;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocationRunner1 {

   private static  Locations3 locations = new Locations3();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String,String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());

            if (loc == 0)
                break;
            Map<String,Integer> exits = locations.get(loc).getExits();
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
                loc = exits.get(directions);
            }
            else{System.out.println("You cannot go to that direction");
            }
        }
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
