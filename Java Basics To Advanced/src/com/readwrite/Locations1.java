package com.readwrite;


import java.io.*;
import java.util.*;

/* We can even use Buffered writer . File writer writes data to Buffered writer and the buffered writer
        * only writes data in size able chunks once in a while. */

public class Locations1 implements Map<Integer,location> {

    private static Map<Integer,location> locations  = new LinkedHashMap<Integer, location>();

    public static void main(String[] args) throws IOException {
        try(BufferedWriter locfile = new BufferedWriter(new FileWriter("locations2.txt"));
             BufferedWriter directionfile = new BufferedWriter(new FileWriter("directions2.txt"));)
        {
            for (location location : locations.values()) {
                locfile.write(location.getLocationId() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q"))
                    directionfile.write(location.getLocationId()+","+direction+","+location.getExits().get(direction)+"\n");
                }
            }
        }
    }
     static {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations.txt")))) {
             scanner.useDelimiter(",");
             while(scanner.hasNext()){
                 int loc = scanner.nextInt();
                 scanner.skip(scanner.delimiter());
                 String description = scanner.nextLine();
                 System.out.println("Imported description =============> "+loc+" , "+description);
                 Map<String,Integer> tempExits = new HashMap<>();
                 locations.put(loc,new location(loc,description,tempExits));
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }

        try(BufferedReader br = new BufferedReader(new FileReader("directions.txt"))) {
             String input;
             while((input = br.readLine())!=null){
                 String[] data  = input.split(",");
                 int loc = Integer.parseInt(data[0]);
                 String direction = data[1];
                 int destination = Integer.parseInt(data[2]);
                 location location = locations.get(loc);
                 location.addExit(direction,destination);
             }
         } catch (IOException e) {
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
