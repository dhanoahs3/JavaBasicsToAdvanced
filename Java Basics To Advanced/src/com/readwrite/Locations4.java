package com.readwrite;

import java.io.*;
import java.util.*;
/*To read and write objects using ObjectInputStream and ObjectOutPutStream
 we have to make the classes that we are about to read and write Serializable. For
 that the respective class needs to implement
* Serializable interface and we also define a long field SerialVersionUID.
This UID field should be private as no other class should use them
This field is like  version no of class
if we don't set it the compiler creates one based on class variables methods etc
If we change class methods etc we need to change the uid as well
because if we don't then runtime  checks  the uid with one stored in compiled class version and if they don't match
 runtime wil throw an invalid class exception .
 Please note that ObjectInputStream and ObjectOutputStream implement DataInputStream and
 DataOutputStream interfaces and these interfaces define all the methods like writeInt,readInt ,writeUtf and
 readUtf .So ObjectInputStream and ObjectOutputStream can read/write primitive types and Strings as well
  along with serializable objects
  Another thing to note is that if in location4 class we comment out this line of code
       private Long serialVersionUID = 1L;
       then an invalid class exception will be thrown in this block of code for our class
       catch (InvalidClassException e){
          System.out.println("InvalidClass exception "+e.getMessage());
        }

        as in that case we are trying to read from locations1.dat file to create a location4 object but since we have
        commented that line of code so runtime will say that the object you are reading from location1.dat file
        has UID = 1 as we have written that object to locations1.dat before commenting out that line
        So runtime will sat that given object has uid1 ,but it will assign uid to location4 at runtime so both objects
        are not same anymore so that's why invalid class exception.


  */

public class Locations4 implements Map<Integer, location4> {
    private static HashMap<Integer, location4> locations  = new HashMap<Integer, location4>();

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream locfile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations2.dat")));) {
            for (location4 location : locations.values()) {
                locfile.writeObject(location);
            }
        }

    }

    static {
        try (ObjectInputStream locfile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations1.dat")))) {
            boolean endOfFile = false;
            while(!endOfFile) {
                try {
                    //Please note that here are readingObject using reaObject and we have to cast it type Location
                    location4 location = (location4) locfile.readObject();
                    //And once object is created we can access the methods of this class
                    System.out.println("Read location---> " + location.getLocationId() + " , " + location.getDescription());
                    System.out.println("found --->" + location.getExits().size() + " exits");
                    locations.put(location.getLocationId(), location);
                }

                catch (InvalidClassException e){
                    System.out.println("InvalidClass exception "+e.getMessage());
                }

                catch (EOFException e){
                    endOfFile = true;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            //Please note we are throwing this exception because if we are reading an object from a location.dat file
            //but can't find corresponding class in class path
            //For example if another class tries to read location.dat file but if that class doesn't contain location4 class.
            System.out.println("ClassNotFoundException "+e.getMessage());
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
    public location4 get(Object key) {
        return locations.get(key);
    }

    @Override
    public location4 put(Integer key, location4 value) {
        return locations.put(key,value);
    }

    @Override
    public location4 remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends location4> m) {

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
    public Collection<location4> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, location4>> entrySet() {
        return locations.entrySet();
    }
}
