package com.readwrite2;

import com.readwrite.location;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*Here in this class we will be using a new technique to read and write files using java.nio package which came available
in java 1.4 If we compare java.nio with our old java.io methods we see that to create constructor of BufferedWriter
we use Files.newBufferedWriter and it accepts an instant of path object that we created above.class The old methods which
we used in our old classes used an object of file class.
Basically java.nio packages use Path instance and not File instance when reading and writing data to files
Path instance - Path locPath = FileSystems.getDefault().getPath("locations.txt");
Creating BufferedWriter objects using path instances
try(BufferedWriter locFile = Files.newBufferedWriter(locPath);
 BufferedWriter dirFile = Files.newBufferedWriter(dirPath)){

old way of doing things usings io methods and using instances of file class instead of path class
 try(BufferedWriter locfile = new BufferedWriter(new FileWriter("locations2.txt"));
   BufferedWriter directionfile = new BufferedWriter(new FileWriter("directions2.txt"));)

   Please note old methods of reading and writng are still preferred way and new java.nio package is if we
   want to use it or for knowledge purpose.

   Same way for reading data from a file instead of using FileReader or BufferedReader classes directly we will use
   java nio package to first create Path objects of  files are reading and then use method Files.newBufferedReader to
   to read that data.
     Path locPath = FileSystems.getDefault().getPath("locations.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions.txt");

        try(Scanner scanner = new Scanner(Files.newBufferedReader(locPath)))

        Above we used scanner object. With BufferedReader object we can use something like this
         try(BufferedReader dirFile = Files.newBufferedReader(dirPath)){
   */
public class Locations implements Map<Integer, Location> {

    private static HashMap<Integer, Location> locations  = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions.txt");
        try(BufferedWriter locFile = Files.newBufferedWriter(locPath);
            BufferedWriter dirFile = Files.newBufferedWriter(dirPath)){
            for(Location location:locations.values()){
                locFile.write(location.getLocationId()+","+location.getDescription()+"\n");
                for(String direction :location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        dirFile.write(location.getLocationId()+","+direction+","+location.getExits().get(direction)+"\n");
                    }
                }
            }
        }

        catch(IOException e){
            e.printStackTrace();
        }


    }

    static {

        Path locPath = FileSystems.getDefault().getPath("locations.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions.txt");

        try(Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported description =============> "+loc+" , "+description);
                Map<String,Integer> tempExits = new HashMap<>();
                locations.put(loc,new Location(loc,description,tempExits));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader dirFile = Files.newBufferedReader(dirPath)){
            String input;
            while((input=dirFile.readLine())!=null){
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc+":"+direction+":"+destination);
                Location location = locations.get(loc);
                location.addExit(direction,destination);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

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
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Map.Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
