package com.readwrite;


import java.io.*;
import java.util.*;

/*We know that static initialisation block is run first ,even before the main method
* we also know that Buffered reader and writers read and write data in big chunks
* Byte Streams can be used to read int,char and String as well. The only thing is data is in bytes
* so we don't have to parse it i.e we don't have to do anything like this
*  int loc = Integer.parseInt(data[0]);
   int destination = Integer.parseInt(data[2]);
   * The reason is byte stream can be used to read and write any of the primitive data types like  int double etc
   * and even String even though String is not a primitive data type.
* And instead of FileReader and FileWriter we use FileInputStream and FileOutputStream
*But byte streams reads and writes raw bytes ,one byte at a time
* data is buffered using BufferedInputStream and BufferedOutputStream
* FileInput streams use methods like readInt,readUtf  etc to read integers,Strings etc same as writeInt,writeUtf
* And since these file input streams deal with binary files so we better create a .dat file
* and not a .txt file as data is not entirely human readable in this file
* Reading data from dat file is easier than reading from text file as we don't have to
* do any String parsing to get the integer value.
* data input streams take care of building primitive types like int ,double from the bytes in the
* file
*Another inp thing to note is we need to need the format of file we want to read before using byte streams to read data
* i.e if first letter is a digit then a String then digit etc.Now this is easy if we want to read text file using
* byte stream as we can open and read the file as it is in human readable form. But it becomes tricky it file
* is a dat file as in our case below. So in that case either we are creating that file ourself otherwise we wont know
* the format in which various data types appeared in that file ,so reading data becomes very tricky.
* For example below we know the format while writing data is
*              locfile.writeInt(location.getLocationId());
*              locfile.writeUTF(location.getDescription());
*              locfile.writeInt(location.getExits().size()-1);
*              locfile.writeUTF(direction);
               locfile.writeInt(location.getExits().get(direction));

      * Then we read data in the same format as well.
          int locId = locfile.readInt();
          String description = locfile.readUTF();
          int numExits = locfile.readInt();
          String direction = locfile.readUTF();
          int destination = locfile.readInt();



*  */

public class Locations3 implements Map<Integer,location> {

    private static Map<Integer,location> locations  = new HashMap<Integer, location>();

    public static void main(String[] args) throws IOException {
     try(DataOutputStream locfile  = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")));)
     {
         for(location location:locations.values()){
/*
           writeInt  used to write Int values
           similarly we have methods to write other java primitive types like
           writeLong ,writeDouble etc
*/
             locfile.writeInt(location.getLocationId());
/*
            writeUTF used to write text data
*/
             locfile.writeUTF(location.getDescription());
             System.out.println("writing location "+location.getLocationId()+" : "+location.getDescription());
             System.out.println("total exits are "+(location.getExits().size()-1)+" : "+location.getDescription());
             locfile.writeInt(location.getExits().size()-1);
             for(String direction:location.getExits().keySet()){
                 if(!direction.equalsIgnoreCase("Q")){
                     System.out.println("\t\t"+direction+ " , "+location.getExits().get(direction));
                     locfile.writeUTF(direction);
                     locfile.writeInt(location.getExits().get(direction));
                 }
             }
         }
     }
    }
      static {
         try (DataInputStream locfile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
             boolean endOfFile = false;
             while(!endOfFile) {
                 try {
                     Map<String, Integer> exits = new LinkedHashMap<>();
                     int locId = locfile.readInt();
                     String description = locfile.readUTF();
                     int numExits = locfile.readInt();
                     System.out.println("Read location " + locId + " , " + description);
                     System.out.println("found " + numExits + " exits");
                     for (int i = 0; i < numExits; i++) {
                         String direction = locfile.readUTF();
                         int destination = locfile.readInt();
                         exits.put(direction, destination);
                         System.out.println("\t\t" + direction + " , " + destination);
                     }
                     locations.put(locId, new location(locId, description, exits));
                 }
                 //*This catch is used end the while loop
                 // i.e when we reach end of file set endOfFile = true
                 // so that while loops after that*//*
                 catch (EOFException e){
                     endOfFile = true;
                 }
             }
         }
         //*If there is any other exception other than eof , i.e any exception
         // thrown by try with resources it will be catch by the below catch block*//*
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
