package com.readwrite;


import java.io.*;
import java.util.*;

/*Two ways of dealing with exceptions.Either put everything that throws exception in try catch block
i.e catch the exception with try/catch block ot throw it
* or else add throws IOEXception to the method that can throw an exception
and since everything is in main method so we add  throws IOException to it.
Another thing to note is once we added the above code in the end of main we don't really need any try/catch
blocks in our code

But in our case we want to close the finally even if an exception is thrown
i.e code goes to exception but we still want to close our file so we can simply use a try and finally
block along with throws IOException
*
* Third way is called try with resources . Here we create FileWriter object inside the brackets()
* in try and the catch and finally block is missing.
try with resources is only available in Java 7 and above
*
*  Another thing to note is Locations class in implementing the Map interface so it has to implement
* all the methods of that interface as well. So down below we have implemented all the methods of map
* on our locations Map that we have created here in the second line ,which is a map of integers and
*location objects
* */

public class Locations implements Map<Integer,location> {

    private static Map<Integer,location> locations  = new HashMap<Integer, location>();

  public static void main(String[] args) throws IOException {



      System.out.println("==========using try catch block ==================");

       /*FileWriter locfile = null;
        try {
            locfile = new FileWriter("locations.txt");

           *  *//*iterate over the locations hashmap values
            * values are objects of class location and for each object
            * get the location id and the description and put them
            * in loc file and go to next line after each iteration
            * also note that we have out the close in finally block
            * so that even if an exception is thrown in for loop and code goes to catch
            * block the finally block will be executed anyways
            * But close itself can cause exception so we have to put close in another
            * try catch block in finally block
            * Another thing to note is we have added
            *        FileWriter locfile = null; before the try block because that way
            * we can use locfile in finally block other wise locfile would be just local to
            * try block and won't be accessible in finally block



            for (location location : locations.values()) {
                locfile.write(location.getLocationId() + ":" + location.getDescription() + "\n");
            }
        }
         catch (IOException e) {
           System.out.println("In the catch block");
           e.printStackTrace();
        }

       finally{
            System.out.println("In the finally block");
            try {
                if(locfile!=null){
                    System.out.println("Attempting to close locfile");
                locfile.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

     */


      System.out.println("==========using try and finally  block with throws I/O Exception in main======");

      /* But in our case we want to close the finally even if an exception is thrown
      i.e code goes to exception but we still want to close our file so we can simply use a try and finally
      block along with throws IOException
      We can deliberatly throw and exception like this
      throw new IOException("throwing an exception for testing purposes") ;*/


    /* FileWriter locfile = null;
      try {
          locfile = new FileWriter("locations.txt");

          for (location location : locations.values()) {
              locfile.write(location.getLocationId() + ":" + location.getDescription() + "\n");
             // throw new IOException("throwing an exception for testing purposes") ;
          }
      }
      finally{
          System.out.println("In the finally block");
              if(locfile!=null){
                  System.out.println("Attempting to close locfile");
                  locfile.close();}
      }*/


      System.out.println("=============try with resources==================");
          /*Please note that in try with resources the code to close the file is missing as
          * that would be automatically taken care of
          * Another difference is in try/catch block if there are 2 errors one in try block
          * while writing something to the file and one while closing the file
          * then in try/catch block only the final error in finally block(one to close the file)
          * is thrown back
          * But in case of try with resources its the first error that is thrown back
          * i.e one that happened while writing to the file and not the one that happened
          * at time of closing the file
          * Please also note that in below code we have two file writers
          * the first one is the same as above but the second one direction file what it does is
          * for each l0cation object it its gets the exits hash map   and gets the keys
          * which must be N,S,W,E,Q etc get the corresponding values like 0,1,2,3 and write to
          * the location object id  , the direction keys (N,S,W,E,Q) etc and values for keys(0,1,2) to
          * direction file
          * Please also note that try with resources allows more than one resource to be specified.
          * So that means we can add a second file writer object inside the try block after we added the first
          * one in try brackets()
          * */

       try( FileWriter locfile = new FileWriter("locations.txt");

           FileWriter directionfile = new FileWriter("directions.txt");)
       {
            for (location location : locations.values()) {
                locfile.write(location.getLocationId() + "," + location.getDescription() + "\n");

              for(String direction : location.getExits().keySet())
              {
                   directionfile.write(location.getLocationId()+","+direction+","+location.getExits().get(direction)+"\n");
                }

            }
        }




  }







  static {

      /*Normally we put data in tempExits hashmaps and then put loc,directions and tempExit in locations
       * map but here instead of doing that we are reading data from files and then putting it in
       * location map .please note we are reading the locations using a file reader
       * and exits using a buffered reader*/


      /*File reader using try catch block */


     /* Scanner scanner = null;
      try {
          //Scanner will read from locations.txt file
          //normally we pass System.in to constructor of scanner
          //like new Scanner(System.in)
          //but here were are reading from a text file and not the keyword
          //so thats why we use new FileReader instead in constructor.

          scanner = new Scanner(new FileReader("locations.txt"));
          //useDelimiter to tell scanner that fields are seperate by a :
          scanner.useDelimiter(",");
          while (scanner.hasNext()) {
              //get the first bit of info as location
              int loc = scanner.nextInt();
              //skip the : and move to next bit of info
              scanner.skip(scanner.delimiter());
              //get next bit of info(description) and move to next line
              String description = scanner.nextLine();
              System.out.println("Imported description = " + loc + " , " + description);
              //then create a hash map called tempExits
              //then pass loc ,description and textExits to locations map.
              Map<String, Integer> tempExits = new HashMap<>();
              locations.put(loc, new location(loc, description, tempExits));
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } finally {
          //here we can close the scanner and it will also close the new Filereader as well ,so we
          //don't have to close it separately
          if (scanner != null)
              scanner.close();
      }

      //================Using buffered reader in try catch block===========================

      try {
          /*  Please note that buffered readers read data in buffer or chunks.
           * They can read 8k of data in one go and since most text files are less than
           * 8k so they are vey fast and efficient in reading them as they will read
           * those files in one go */
       /*   scanner = new Scanner(new BufferedReader(new FileReader("directions1.txt")));
        /*  scanner.useDelimiter(",");
          while (scanner.hasNextLine()) {
              //*One way of reading from file and storing location,direction destination is below that is splitting based on scanner.delimiter.*//*

              int loc = scanner.nextInt();
              scanner.skip(scanner.delimiter());
              String direction = scanner.next();
              scanner.skip(scanner.delimiter());
              String dest = scanner.nextLine();
              int destination = Integer.parseInt(dest);*/

      //* Another way is to read the entire String using nextLine and split based on ,
      // as done below after the split method i.e create a String array based on ,
      // and then get 0th , 1st and 2nd element of array *//*


         /*        String input = scanner.nextLine();
                 String[] data  = input.split(",");
                 int loc = Integer.parseInt(data[0]);
                 String direction = data[1];
                 int destination = Integer.parseInt(data[2]);


              System.out.println(loc + " : " + direction + " : " + destination);
              location location = locations.get(loc);
              location.addExit(direction, destination);

      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (scanner != null) {
              scanner.close();
          }
      }

  }*/



      /* ==============File reader using try with resources =======================
       * Please note again for try with resources we don't need finally block as
       * we don't need code to close the scanner as try with resources will remove as well*/
      System.out.println("-------Try with resources--------------------------------");
      try (Scanner scanner = new Scanner(new FileReader("locations.txt"))) {
          scanner.useDelimiter(",");
          while (scanner.hasNext()) {
              int loc = scanner.nextInt();
              scanner.skip(scanner.delimiter());
              String description = scanner.nextLine();
              System.out.println("Imported description = " + loc + " , " + description);
              Map<String, Integer> tempExits = new HashMap<>();
              locations.put(loc, new location(loc, description, tempExits));
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }


      /*  Buffered reader reads whole chunks of data.
       * Please note instead of scanner we can just use BufferedReader br as reference as well
       */

      try (BufferedReader br = new BufferedReader(new FileReader("directions.txt"))) {
          String input;
          while ((input = br.readLine()) != null) {
              String[] data = input.split(",");
              int loc = Integer.parseInt(data[0]);
              String direction = data[1];
              int destination = Integer.parseInt(data[2]);
              System.out.println(loc + " : " + direction + " : " + destination);
              location location = locations.get(loc);
              location.addExit(direction, destination);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }


  }








         /*-------------------------------------------------------------------------------------*/
/*

         Map<String,Integer> tempExit = new HashMap<>();

         locations.put(0, new location(0, " you are at home",tempExit));

         tempExit = new HashMap<String,Integer>();
         tempExit.put("W",2);
         tempExit.put("E",3);
         tempExit.put("S",4);
         tempExit.put("N",5);
         locations.put(1, new location(1, " you are at office",tempExit));


         tempExit = new HashMap<String,Integer>();
         tempExit.put("N",5);
         locations.put(2, new location(2, " you are in the mall",tempExit));


         tempExit = new HashMap<String,Integer>();
         tempExit.put("W",1);
         locations.put(3, new location(3, " you are at restaurant",tempExit));

         tempExit = new HashMap<String,Integer>();
         tempExit.put("N",1);
         tempExit.put("W",2);
         locations.put(4, new location(4, " you are outside the city",tempExit));


         tempExit = new HashMap<>();
         tempExit.put("S",1);
         tempExit.put("W",2);
         locations.put(5, new location(5, " you are in the playground",tempExit));
     }

*/


     /*Map functions
     *
         locations.isEmpty();

        locations.containsKey(key);

      locations.containsValue(value);

      locations.get(key);

      locations.put(key,value);

      locations.remove(key);

      locations.clear();

     locations.keySet();

     locations.values();

      locations.entrySet();

     * */









    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public location get(Object key) {
        return locations.get(key);
    }

    @Override
    public location put(Integer key, location value) {
        return locations.put(key,value);
    }

    @Override
    public location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends location> m) {

    }

    @Override
    public void clear() {
       locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, location>> entrySet() {
        return locations.entrySet();
    }
}
