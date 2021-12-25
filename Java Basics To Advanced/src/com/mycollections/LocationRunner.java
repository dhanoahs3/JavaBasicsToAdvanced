package com.mycollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*To iterate through each word in a String array i.e the array we created by splitting the string based on 
* regex expression space
*  String[] road = "You are standing at the end of the road before a small brick building".split(" ");
        for(String s :road){
            System.out.println(s);
        }
        * To print all keys in a map separated by a comma  exits is a map.Please note we are printing keys
        *  for(String exit:exits.keySet()){
                System.out.print(exit+ ", ");
            }
            * Other than key set we can print a map like this      System.out.println(exits.toString());

* Or we can can check if a Map contains a particular key like this
*                     if(vocabulary.containsKey(word)){

*/

public class LocationRunner {
    public static Map<Integer,location> locations = new HashMap<Integer,location>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> tempExit = new HashMap<String,Integer>();
        /*For first entry in Map we put key 0 and value is a object of class location
        * which has accepts a integer ,String and a empty hashmap tempExit in its constructor*/
        locations.put(0, new location(0, " you are at home",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
//        tempExit.put("Q",0);
        /*For second entry in Map we put key 1 and value is a object of class location
         * which has accepts a integer ,String and a  hashmap tempExit that contains key value
         * pairs defined above in its constructor*/
        locations.put(1, new location(1, " you are at office",tempExit));

        /*same goes on for other entries for Hashmap named locations*/
        tempExit = new HashMap<String,Integer>();
        tempExit.put("N",5);
  //      tempExit.put("Q",0);
        locations.put(2, new location(2, " you are in the mall",tempExit));


        tempExit = new HashMap<String,Integer>();
        tempExit.put("W",1);
    //    tempExit.put("Q",0);
        locations.put(3, new location(3, " you are at restaurant",tempExit));


        tempExit = new HashMap<String,Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
    //    tempExit.put("Q",0);
        locations.put(4, new location(4, " you are outside the city",tempExit));


        tempExit = new HashMap<String,Integer>();
       tempExit.put("S",1);
       tempExit.put("W",2);
      // tempExit.put("Q",0);
        locations.put(5, new location(5, " you are in the playground",tempExit));

        Map<String,String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");

        int loc = 1;
        while (true) {
            /*The below will print you are at office which is description for object no 1 for location
            * as we defined loc above*/
            System.out.println(locations.get(loc).getDescription());
            /*Now the last tempExit points to the map that we passed to the constructor of playground class.
            * if we remove "S" from tempExit it will remove it from the map of playground.
            * to fix this issue we should use immutability that is rather than using the map object passed as is in constructor ,better make a copy
            * of it and then use it
            * like below
            * So use this*/
          /*  this.exits = new HashMap<>(exits);}
          insted of this  in the constructor
                this.exits = exits*/
        tempExit.remove("S");
             //if loc is 0 break out of loop
            if (loc == 0)
                break;

            /*If we are not looping out of while loop
            * we get exits map for the location object
            * when running the code for first time loc = 1
            * so we will get exits map for object stored at key 1 in locations map*/
            Map<String,Integer> exits = locations.get(loc).getExits();
            System.out.println("Available directions are: ");
            /*Then we print all keys for that map separated by , like for example N,S,W,E,Q*/
            for(String exit:exits.keySet()){
                System.out.print(exit+ ", ");
            }
            /*go to next line*/
            System.out.println();
            /*type any direction like Q,W ,e or even like go North ,lets go west*/
            String directions = scanner.nextLine().toUpperCase();
            /*If typed direction is more than one letter like go north etc*/
            if(directions.length()>1){
                /*split it based on space*/
                String[] words = directions.split(" ");
                /*iterate through each word of String array*/
                for(String word:words){
                    /*check if vocabulary map contains any of the keywords we entered */
                    if(vocabulary.containsKey(word)){
                        /* if it is there in the vocabulary map then get the short form from
                                * vocabulary map  like get E for east or W for west*/
                        directions = vocabulary.get(word);
                        /*And break out of this word looking for loop*/
                        break;
                    }
                }
            }
            /*then we go the exits map we got for our location object.
            * in first case it will be location object 1
            * and if we have that direction key there for our map we will get the value for that
            * for example for our location object 1 we have put key values map like this
            *  tempExit.put("W",2);
            * and if we get W from directions above
            *  and W is in map below. note not all location objects have all directions in their exit
            * maps but if it is there then*/
            if(exits.containsKey(directions)){
                /*then get a value for loc like 1,2,3,4 or 0 based on key W,E,S,N or Q etc*/
                loc = exits.get(directions);
            }
            /*If there is no key in exits map then print the below message
            * for example for some location object there will be no key like W or S or N etc*/
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
