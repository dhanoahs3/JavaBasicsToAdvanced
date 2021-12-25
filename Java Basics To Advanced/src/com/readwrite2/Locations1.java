package com.readwrite2;



import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*Here in this class we will be using a new technique to read and write files using java.nio package which came available
in java 1.4 to read and write objects instead of text

The only difference using nio class will be that we will be passing an instance of Path Class rather than instance of
file class as we used to do with io packages.
so for io packages we  used new FileOutputStream("location2.dat")))
try (ObjectOutputStream locfile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations2.dat")));) {

 Here in nio package we are using an instance of path using  Files.newOutputStream(locPath)))
 So what we doing with java nio method below we are doing is  we crete a file outputStream using
 Files.newOutputStream(locPath) and that is the only difference from java io package as there we are creating file using
 new FileOutputStream("locations2.dat")));)

 Then we buffer the output using BufferedOutputStream  so that data is written in buffers and then we wrap it
 in ObjectOutputStream so that we can write objects instead of  normal data.
try(ObjectOutputStream locFile  =  new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))){

Same way for reading data in static initialization block we pass instance of Path instead of instance of File like below

 Path locPath = FileSystems.getDefault().getPath("locations.dat");
 try (ObjectInputStream locfile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
   */

public class Locations1 implements Map<Integer, Location> {

    private static HashMap<Integer, Location> locations  = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectOutputStream locFile  =  new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))){
                for (Location location : locations.values()) {
                    locFile.writeObject(location);
                }
            }


        catch(IOException e){
            e.printStackTrace();
        }


    }

    static {



        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectInputStream locfile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    Location location = (Location) locfile.readObject();
                    //And once object is created we can access the methods of this class
                    System.out.println("Read location---> " + location.getLocationId() + " , " + location.getDescription());
                    System.out.println("found --->" + location.getExits().size() + " exits");
                    locations.put(location.getLocationId(), location);
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
        }
        catch (InvalidClassException e) {
            System.out.println("Invalid class exception  ->"+e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO exception  ->"+e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Invalid class exception  ->"+e.getMessage());
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

