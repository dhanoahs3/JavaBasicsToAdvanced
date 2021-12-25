package com.readwrite;

import java.io.*;
import java.util.*;

/*Buffered reader and writer -reduce disk access time as it reads or writes large chunk of data at once
*
* Byte Streams reads /writes byte Stream. since it reads/writes binary input streams we can use it with any primitive type
* like int ,double character and in a special case we can even use Strings
* And instead of File reader and File writer we use File input stream nd file output stream
* */

public class Locations2 implements Map<Integer,location> {
    private static Map<Integer,location> locations  = new LinkedHashMap<Integer, location>();

    public static void main(String[] args) throws IOException {
        try(BufferedWriter locfile = new BufferedWriter(new FileWriter("locations.txt"));
            BufferedWriter directionfile = new BufferedWriter(new FileWriter("directions.txt"));)
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
                System.out.println("Imported description = "+loc+" , "+description);
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
