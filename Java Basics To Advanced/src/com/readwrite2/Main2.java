package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;



public class Main2  {
/*
   Here we will learn how to write data in binary format. In the earlier class we learned how to write in text format
*/

    public static void main(String[] args) {

        //So for that we create a FileOutputStream
        //Then we need to create a file buffer.
        //buffer capacity is maximum no of elements it can contain
        //Buffer position is the next location from which it can read or write.


        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            //After creating a FileOutputStream object above for the file we want to write we will create a channel
            // below which we will use to write to the above file.

            FileChannel binChannel = binFile.getChannel()){
          //create a byte array we want to write to file
            //and since we are using try with resources above it will automatically close the file output stream
            //and channel we are creating above
            byte[] outputBytes = "Hello world!".getBytes();
            // create byte buffer.wrap to create byte buffer.
          // wrap method wraps byte array to buffer.
        // if we use buffer to write String or   bytes and then use it to read  from file ,
            // the output byte array will be changed.
            //so when we use wrap method we are telling run time to use the byte array we created above as the buffer
        //wrap also sets the initial position of buffer to 0.
        //wrap will set buffer capacity to byte array length


            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            //we then use file channel to write our buffer
            //Here we can simply have used binChannel.write(buffer).
            //We are using numBytes simply to get the no of bytes we want to write.
            int numBytes = binChannel.write(buffer);
            //we can then print the no of bytes written
            System.out.println("numBytes written was: "+numBytes);

            //Now lets create a int buffer to write integers to file

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(234);
            //Now very imp thing to note here. When  we created the int buffer above it will set
            //position of buffer to 0.
            //Then after we use putInt method it will set position of buffer to after the int.
            //Then if we use write it will be positioned after the position of above int.
            //So in order to read the data we have to reset the buffer position to 0 to read data
            //after every write as we have done below.
            //Please also note that for wrap method we never used flip as wrap takes care of resetting the
            //buffer all by itself.
            //Also another thing to note is for all other methods like putInt,putLong etc we don't have to use flip
            //after every write. we can write 10 lines of code and use flip in the end.
            //Also note we can use putInt to write to a specific index as well by passing the index as second
            //argument to put method.
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: "+numBytes);

           //Now if we try to write another integer to the file after using flip method above we got an error
            //saying java.nio.BufferOverflowException
            //The issue is after we write the last buffer the buffer position is set to 4. But 4 also the maximum position
            //for our buffer as defined here as Integer is four bytes (ByteBuffer.allocate(Integer.BYTES)
            // that is why the above error.
            //so to solve this issue we have to flip before putInt method and before write as well.
            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: "+numBytes);

            //So in a nutshell always call flip when flipping from reading and writing .
            //also use it every time we are about to write data to file

/*
            Now let us read the data.dat file that we have written above using a RandomAccessFile
            We define a byte array below and we define it to the length of String Hello World we defined above
            We then read both integers 1 and 2 using readInt
            So what we have demonstrated here is there is no association between the way can read and write data
            What that means in above we use java.nio package to write data to file.
            But below we use RandomAccessFile from java.io class to read that data and even though we
            wrote data to bytes above in java.nio package.
            But random access file is still able to know what data is String and which one is int and hence we can
            read it using readInt methods etc.
*/

            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");

            byte[]b = new byte[outputBytes.length];
            ra.read(b);
            System.out.println(new String(b));

            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);


        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}



