package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;



public class Main5 {
          /* In the early main examples what we were doing is we were writing one String or int to the buffer and
          then we were reading it from the buffer and writing it to the channel
          In below example we will write one String , 2 integers ,then another String and then again one integer to
          the buffer and then only after that we will read from this buffer and write to the channel.
           Here in this method we have seen  we allocate maximum buffer size to 100
           and another thing to note is
          that we have only used flip once  after writing all values
          * to the buffer and before reading the values from buffer to write to the channel
          Another thing to note is we have not used any indexes with put methods so all these reads are relative reads
          and not absolute reads.*/

    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("data2.dat");
             FileChannel binChannel = binFile.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
          /*  byte[] outputBytes = "Hello world".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            // flip sets buffer position to zero. if we don't use the below flip statement
            // the buffer position will be set after the last byte 1000 was written and since there is nothing in the
            //buffer after the position of 1000 so binChannel.write will not write anything to the file.
            buffer.flip();
            binChannel.write(buffer);*/



            /*Another way to  write data to file is to chain the put methods all together.so if we comment out all
            * the code from byte[] outPutBytes till buffer.putInt(1000) . then we can try something like this to chain all
            * puts together and results will still be the same .We will also comment the buffer.flip and bitChannel.write
            * statements  above to see how we can chain the puts together*/

            byte[] outputBytes = "Hello world".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
            buffer.flip();
            binChannel.write(buffer);














            /*Now lets read from the file using the above technique . that is read all data into the buffer
            * in one go and before flipping and writing to the output channel . For reading we can use the same
            * buffer as we used above but then the contents of buffer will already be set to the contents we wrote to the
            * file . so to make sure we are reading from actual file and not a buffer we use are using new buffer
            * and not the buffer we declared above for writing */

            RandomAccessFile ra = new RandomAccessFile("data2.dat","rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = "+new String(inputString));
            System.out.println("int1 = "+readBuffer.getInt());
            System.out.println("int2 = "+readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = "+new String(inputString2));
            System.out.println("int3 = "+readBuffer.getInt());


        }

        catch (IOException e){
            e.printStackTrace();
        }


    }


}


