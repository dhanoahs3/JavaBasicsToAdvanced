package com.mycollections;
import java.util.HashMap;
import java.util.Map;

/*ArrayList and LinkedList are part of java.util.collections framework and Maps are
* part of java.util.Map
* List ,Set ,Queue and Dequeue inherit directly from collections.
* Please note that Keys are unique in Java .so what that means is if we put two values for the same
* keys in a map it will override the previous value and then we can only access the second value using that key
* like we did in our case where we add values for same keys Java
*
*
* So to avoid adding values to keys that already exist we can check if key already exists using
*         if(languages.containsKey("Python"))
* Then we can use a for loop to iterate through each key value pair for a map
*   for(String key:languages.keySet()){System.out.println(key +" : "+languages.get(key));}
*
* We can even print just the values of a map and not the keys by doing the below
*          for(String value:languages.values()){ System.out.println(value) }

*
* To print only keys from a map
*  for(String exit:exits.keySet()){
                System.out.print(exit+ ", ");
            }
   Other than key set we can print a map like this
   *     System.out.println(exits.toString());
   *
   * To print Map in a more readable form we can do use an for loop on keySet and do something like this
   *  for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

    *
*
* to replace a value
*         languages.remove("MySql");

* To remove if key value pairs match
*   if (languages.remove("JavaScript", "Only remove if key values match")) {
            System.out.println("JavaScript removed");
        }
*
* To replace
*   languages.replace("Python","Getting famous for machine learning");
   //similar to remove , replace only if key value pairs match
        if (languages.replace("JavaScript", "Only replace if old key value pairs match in the Map","New value for Javascript")) {
            System.out.println("JavaScript value replaced");
        }

 * */
public class MapRunner {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a high level,object oriented ,platform independent language");
        languages.put("Python", "an interpreted ,object oriented ,platform independent language");
        languages.put("BASIC", "old language");
        languages.put("MySql", "Some say its not exactly a programming language");
        languages.put("JavaScript", "Used for front end development");

        System.out.println(languages.get("Java"));
        System.out.println(languages.get("Python"));

        languages.put("Java", "This will over ride the previous value fo java");
        System.out.println(languages.get("Java"));

        /*This will print the previous value for java and then replace with new one*/
        System.out.println(languages.put("Java", "This is another defination for java"));
        System.out.println(languages.get("Java"));

        if (languages.containsKey("Python")) {
            System.out.println("The key Python is already there");
        } else {
            languages.put("Python", "This will over ride the previous value fo python");
        }


        System.out.println("========================================================================");
        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        System.out.println("========================================================================");
        System.out.println(languages.toString());
               System.out.println("========================================================================");



        languages.remove("MySql");

        if (languages.remove("JavaScript", "Only remove if key values match")) {
            System.out.println("JavaScript removed");
        }
        else{
            System.out.println(languages.get("JavaScript")+ " still there in Map");}

        languages.replace("Python","Getting famous for machine learning");

        if (languages.replace("JavaScript", "Only replace if old key value pairs match in the Map","New value for Javascript")) {
            System.out.println("JavaScript value replaced");
        }
        else{
            System.out.println(languages.get("JavaScript")+ " still has this value in the Map");}


        System.out.println("============After remove and replace================================");
        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        System.out.println("============printing just the values================================");
        for(String value:languages.values()){ System.out.println(value); }

    }
}
