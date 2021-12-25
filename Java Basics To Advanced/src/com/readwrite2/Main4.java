package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;



public class Main4  {


    public static void main(String[] args) {

        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()){
            //create a byte array we want to write to file
            byte[] outputBytes = "Hello world!".getBytes();

          /*  let use allocate method to read the String .Then we have to pass the length of outputBytes
            then we have to use buffer.put
            So instead of using wrap method and passing a byte array we have used allocate method instead
             and then using put method we are copying the content of byte array into the buffer.
            It is imp to remember that when we use the wrap method the byte array passed to to the method is
             used  as byte array that backs the buffer
            but when we use allocate a new byte array is created and that is used to back the buffer
             earlier when we used buffer created by  wrap method to read the String the output bytes array was updated
            because that backed the buffer*/

            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);

             //another very imp thing to note is we have to add flip here otherwise our code will throw an error.
            //The reason is when we use buffer.put above we wrote to the buffer but when we use binChannel.write we
            // are reading from the buffer. So we need to add flip here

            buffer.flip();


            int numBytes = binChannel.write(buffer);
            //we can then print the no of bytes written
            System.out.println("numBytes written was: "+numBytes);

            //Now lets create a int buffer to write integers to file

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(234);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: "+numBytes);
            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: "+numBytes);

            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] ='a';
            outputBytes[1] ='b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);

            if(buffer.hasArray()){
                System.out.println(" byte buffer = "+new String(buffer.array()));
            }

            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            channel.close();
            ra.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}





