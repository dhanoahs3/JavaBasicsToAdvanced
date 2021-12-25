package com.readwrite;

import java.io.*;
import java.util.*;
/* If a file is too large we don't have to read and write the entire file. We can read parts of the file.
Earlier all the examples we have seen earlier we read files sequentially. But we can read file randomly i.e read files
in bits and pieces.
So we use RandomAccessFile class to read and write a file in random fashion.
File pointer is an offset where read and write will start from. If File pointer is set to a 100 then 100 is location
where next read and write is going to take place.
if data to be read is 5 bytes then after first read or write operation the pointer will be set to 105.
And offset is where the first byte of a particular data is located in a file.
So if a particular data that we want to read has an offset 100 i.e has first value to read from at 100
then we want our pointer to point to location 100 to start reading or writing.
Let us say all our locations are of size 30 bytes and first location starts from offset 0 .
Then location 1 will occupy 0-29
location 2 will occupy 30-58 and so on .
nth location start point can be found using (n-1)*30

But all locations are not of same size as size of each location's description is different.

So in our case we will use index to find location of a location and then we read data in that particular location

Index contains location Id ,offset of a location and the length of the location.

So as locations will be of variable length so index will record offset of each location and length of each location

So Reading a location will be a two step process. First we read te index for each location and then use the index to
read location data.

each index should be of same length.
And each index contains location id , offset of location and location length as we discussed before.
The data that a index is used to read , in our case the location is called a record.
Each index in java is 12 bytes.
In our case location description is usually longer , so index to location record which will be 12 bytes will  be always
shorter in memory than location itself.

So when we want to read a location from a file we can read the index when user moves to that location
or we can load the entire index into memory when application starts.
Ideally entire index of all locations is loaded into the memory all at once since reading index from memory is much
faster than reading it from the file again and again.
Usually size of index will be smaller than location data  so it makes sense to load entire index into memory.
Just in case if index size is greater than data record then it is not good point to load entire index to memory.


We also said that first byte of data start at position 0 but that won't be the case if we use index to store data records

So if index is saved in file then first bytes of file will be used in saving index files.
So first record for data will not start at index 0 as those memory locations are used to save index.
But that does not apply to our case as in our case we will not save index to file
We will just load it from memory.

In our case it will be like this

1.The first 4 bytes will contain the number of locations(bytes 0-3)
2.The next 4 bytes will contain the start offset of the locations section( bytes 4-7)
3.The next section of file will contain the index (the index is 1692 bytes long). It will start at bytes 8 and end
at bytes 1699
4.The final section of the file contains the actual record (the data ). It will start at byte 1700.

We can move to typical location using seek method and then move  file pointer to that location.
 and then we can read write use readUTF write UTF etc.When data is read or written the file pointer automatically moves
 to next location in the memory. so we don't to use seek method if the next piece of data we want to read is just
 lying after the one that we just read.
 seek is only used when we want to move to a different location is a file.

*/

public class Locations5 implements Map<Integer, location4> {
    private static HashMap<Integer, location4> locations  = new HashMap<Integer, location4>();
    private static Map<Integer, IndexRecord> index  = new LinkedHashMap<Integer,IndexRecord>();
    private static RandomAccessFile ra;
      //Random access file can't read ,wrote object. and also we don't use Buffered input ouput streams as those
    // are used to read write data from a buffer i.e is in a sequence. but random access file is all random data read
    // and write.

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile rao = new RandomAccessFile("locations2.dat","rwd")) {
            //locations.da file remain open when we read data from file. that is why we use rwd to read and write
            //synchronously. that means multiple files can read and write the file at the same time

             // we dont need rao.seek here as we are not going to any particular location. we are just writing
            // at the start of the file
            rao.writeInt(locations.size());//So here we wrote total no of locations to the file.
            //Each index record contains 3  integers
            //  The location id , offset for the location and length of location record.
            ///We get index size using locations.size i.e total no of locations we got  multiplied by  3
            //Multiply by no of bytes for an integer.
            //
            int indexSize = locations.size()*3*Integer.BYTES;
            //We then calculate the current position of file pointer to index size to account for values we have
            // already written to the file. We also have to account for the integer we are about to write to the file
            // the locations section offset we just calculated  and no of bytes in Integer.
            //This will give us offset for location section
            //Then we have to cast to an int as getFilePointer is a long value.
            int locationStart = (int)(indexSize+rao.getFilePointer()+Integer.BYTES);
            rao.writeInt((locationStart));


            //Next section to write to file is the index. But before we can write index we have to write the locations
            // as each index record requires the offset for the location and since we don't know the offset until
            // we have written the location.
            //we can write one location then write index record ,then next location then write index to file but
            // we will then be accessing the disk again and again and disk access is expensive process.
            //So we will first write all the locations to the file and then all the index records.
            //so for that we will save all indexes in memory and since we need to go back to file to write all the indexes
            // after we have written the locations we will save the current position of file pointer , so that we can
            // jump back to it once all locations are written and since index will be written after the two integers we
            //have already written so index will be written after 'locations size' and 'locations start we wrote above'
            //so if means index will be written at location where file Pointer is pointing write now. so let us save that
            //location. as below

            long indexStart  = rao.getFilePointer();

            //We have already calculated the offfset of locations data section . We will assign it to a variable
            //named startPointer which will update after each location is written.Then we ill loop through the locations
            // write each location , create an index for it and add indexrecord it to a map

            //For that we need a new java class and we add a new class named IndexRecord to our project.

            int startPointer = locationStart;
            //we get String location above and below we seek that location to start writing at that location.
            //So after storing locationStart to file above, we store that in integer startPointer and then use
            // rao. seek to go point to where we want to start writting data. we only need to do it for first location
            // as after that we write data to file sequentially.

            rao.seek(startPointer);
              //loop through all values of locations map
            for(location4 location : locations.values()){
                //write locationId and locationDescription
                rao.writeInt(location.getLocationId());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                //Then use for loop to get all exits and  put them in a String builder
                for(String direction :location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                //then write those exits to the file.
              rao.writeUTF(builder.toString());
                //Then below we create objects of Index class by passing startpointer(where we started writing the file
                //and getFilePointer-startPointer (i.e current location) to constructor of IndexRecord.
                IndexRecord record = new IndexRecord(startPointer,(int)(rao.getFilePointer()-startPointer));
                //add the objects of IndexRecord to index map.
                index.put(location.getLocationId(),record);
                // put start pointer to current location
                startPointer = (int)rao.getFilePointer();
            }
            //Above we have written locations to file.
            //Below we will write all info from index map to file.

            // We are seeking or going to position of indexStart which we have saved above
            //i,e the one we saved before writing our locations because we knew that is the location where we will
            // be writing our indexes. ---------------------> long indexStart  = rao.getFilePointer();
            rao.seek(indexStart);
            for(Integer locationID :index.keySet()){
                //so basically we are writing locationId to file .
                //Then based on locationId we are getting IndexRecord objects from index map and
                //then write start bytes and length from each IndexRecord object  to file.
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartBytes());
                rao.writeInt(index.get(locationID).getLength());
            }
            }
        }



    static {

        try{
            ra = new RandomAccessFile("locations2.dat","rwd");
            int numLocations = ra.readInt(); //no of locations
            long locationStartPoint = ra.readInt(); //offset of locations

            while(ra.getFilePointer()<locationStartPoint){ //read till fil pointer reaches locations offset
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();
                IndexRecord record = new IndexRecord(locationStart,locationLength); //create new record and save all data
                index.put(locationId,record);
            }

        }
        catch(IOException e){
            System.out.println("IO exception in static initializer "+ e.getMessage());
        }

       /* try (ObjectInputStream locfile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations1.dat")))) {
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
        }*/
    }

    public location4 getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartBytes());//We are moving the start byte to locations offset by using the seek method
        int id = ra.readInt();// we don't need the id . we are just doing sanity check here
        String description = ra.readUTF();//we then go to description
        String exits = ra.readUTF();//We are retrieving the exits here
        String[] exitParts = exits.split(",");
        location4 location = new location4(locationId,description,null);//We then create an new location that does
        // not have any exits at the moment.
        if(locationId!=0){
            //Here we are adding the exits
            for(int i=0;i<exitParts.length;i++){
                System.out.println("exitPart= "+exitParts[i]);
                System.out.println("exitPart[+1] ="+exitParts[i+1]);
                String direction = exitParts[i];
                int destination = Integer.parseInt(exitParts[i+1]);
                location.addExit(direction,destination);

            }
        }
        return location;
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

    public void close() throws IOException {
        ra.close();
    }
}
