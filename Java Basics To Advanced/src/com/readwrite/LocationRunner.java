package com.readwrite;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocationRunner {

    /*Create an object of locations class ,the class that extends Map interface i.e the class
     * which extends all methods of map interface and has a hashmap defined as well which contains
     * Integer as string and location object as value.
     * When we create a new object of locations as below , the static block in Locations class is executed
     * and what it does is it puts key value pairs in hashmap with keys  as integers and values as
     * objects of class location which further has entries of all the exits in its hashmaps
     *
     * And then based on the locations object we created here when we try something like this
     *             System.out.println(locations.get(loc).getDescription());
     * it will actually call the overriden get method in map interface and that get method
     * will return the value from locations hashmap defined in Locations class
     *     private static Map<Integer,location> locations  = new HashMap<Integer, location>();

     * */
   private static  Locations locations = new Locations();
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
    }
}
