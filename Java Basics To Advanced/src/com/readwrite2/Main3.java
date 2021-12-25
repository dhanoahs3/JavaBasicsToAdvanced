package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;



public class Main3  {


    public static void main(String[] args) {

        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()){
            //create a byte array we want to write to file
            byte[] outputBytes = "Hello world!".getBytes();

            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            //we then use file channel to write our buffer
            int numBytes = binChannel.write(buffer);
            //we can then print the no of bytes written
            System.out.println("numBytes written was: "+numBytes);

            // We will create another buffer to write to an integer
            // Now lets create a int buffer to write integers to file
            //We will allocate total memory to this buffer. total memory allocated will be the size of an integer

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);

            //Now we know in case of wrap we simply used             ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            // and everything was taken care of

            //In case of writing integers  we have to use putInt method as wrap is convenient to be used with bytes
            // but for integers , shorts ,double etc we use methods like putInt , putShort etc
            //But wrap methods takes care of flip method all by itself and for put we have to reset the buffer
            intBuffer.putInt(234);
            //What happens is after putInt the buffer is set to position after the location of last element we have written
            //Then if we want to read from the buffer and write to the file we need to set the buffer position back to the
            //start of the buffer.
            //If we are writing 20 different integers we can allocate a buffer with memory equal to size of 20 integers
            //then use putInt 20 times and after writing all 20 ints to buffer we use flip to reset buffer position back
            //to 0 and then we read all 20 ints from buffer and write to file.
            //We can even write to a specific index in the file and in that case we can pass the specific index as second
            //argument to putInt method
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: "+numBytes);

            //Now let us say we want to write another int to the file.
            //Please note that  we have allocated 4 bytes to buffer above
            //now buffer is pointing to end of buffer after we read from buffer and write to file in above line
            //so if we use putInt again before flipping the buffer it will throw
             //java.nio.BufferOverflowException as we have reached end of buffer above so we need to use flip again
            // to set to postion 0 as below we will again be writing to the buffer
            intBuffer.flip();
            intBuffer.putInt(-98765);
            //Flip the buffer again as we are reading from buffer now and writing to file.
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: "+numBytes);

            //So in a nutshell always call flip when flipping from reading and writing .
            //also use it every time we are about to write data to file

/*
            Now let us read the data.dat file using nio package.
            We know we need to switch from write to read before reading using the flip method
            But let us say we don't use flip and simply read the data like this

            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = ra.getChannel();
            long numBytesRead = channel.read(buffer);

            if we do like we did above we will see Hello World printed but please note since we did not use flip
            the Hello world we are getting is not from the file but from the buffer we defined above i.e this one

            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);

            To demonstrate this we can even change bytes in our buffer and it will read something like abllo world!
            although the data in actual file data.dat is Hello World!

             RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] ='a';
            outputBytes[1] ='b';
            long numBytesRead = channel.read(buffer);
            System.out.println("Output byte "+new String(outputBytes));

            so the correct way of doing this is always call the flip method before switching between reading and writing
            as we have done below and in that way even if we add bytes like a ,b to the buffer the correct String
            Hello world will be printed as it is reading from the actual file.

*/

            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] ='a';
            outputBytes[1] ='b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            System.out.println("Output byte "+new String(outputBytes));

            System.out.println("-------------------------------------------------------------------");


            /*------------------------------------------------------------------------------------------------*/
             //Now we can comment out the above System.our.println and use the below method to read data as well

            if(buffer.hasArray()){
               System.out.println(" byte buffer = "+new String(buffer.array()));
           }

            System.out.println("-------------------------------------------------------------------");


            //Then we can use the intBuffer method to read the two integers as well
            //Relative read

            //Please note that we have to use flip a few times below . before read and before get Int as well
            //To avoid using flip again and again we can use another version of getInt method
            //The below method is called Relative read as we have not defined any index to read from
            //Example of absolute read is after this example.
           /* intBuffer.flip();
            numBytes = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());

            intBuffer.flip();
            numBytes = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            channel.close();
            ra.close();*/

            //Absolute read
            //So in the below method we don't have to use flip method after reading from the file channel as we
            //are using the absolute version of getInt method where we are passing index 0.So basically we are telling
            //to read from index position 0 of the buffer .
            //So we can either flip method or we can use index position.
            //in below method we only use flip when we are reading from file channel
            // we don't use it when we read from buffer and write to console as we are passing the index from which
            //position we want to read from the buffer

            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            channel.close();
            ra.close();

          /*Below code is only for demonstration purposes . We have to keep in mind that if we use absolute read the
          * buffer position is not updated after each read. to demonstrate this lets flip the buffer ,do a absolute read
          * and then do a relative read.*/

           /* intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            // so after read lets flip the buffer as after the absolute read we will be using relative read.
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));
            //so here we use relative read. So if we run our code it will print the last integer -98765 twice
            //th reason is absolute read never changes the buffer position because otherwise the above line of code
            //would have taken buffer to end of file and below line would have thrown bufferoverflow error.
            //so moral of story is either use absolute read or relative read but never use both otherwise it can lead to
            //to many errors.
            System.out.println(intBuffer.getInt());
            channel.close();
            ra.close();
*/






        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}




