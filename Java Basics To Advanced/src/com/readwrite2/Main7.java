package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;



public class Main7 {
    /* Lets learn to copy files. We will copy from data2.copy and paste in datacopy.dat file.
    */

    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("data2.dat");
             FileChannel binChannel = binFile.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello world".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos+Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos+Integer.BYTES+outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data2.dat","rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = +"+readBuffer.getInt());
            readBuffer.flip();

            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = +"+readBuffer.getInt());
            readBuffer.flip();


            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = +"+readBuffer.getInt());



            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat","rw");
            FileChannel copyChannel = copyFile.getChannel();
            //Please note that when we are using transferFrom method we are passing the source channel
            //that we defined one line 35 using this
           /* RandomAccessFile ra = new RandomAccessFile("data2.dat","rwd");
            FileChannel channel = ra.getChannel();*/
           //Also note that we are using transferFrom method on copyChannel where copyChannel is destination
            //channel which we got above. We first created copyFile using destination location above and then
            // we created a FileChannel object for destination channel using  copyFile.getChannel
            //Also 0 is starting position  and channel.size is the no fo bytes we want to copy.
            //Also note that copyChannel.transferForm returns no of transferred bytes and we store it in a long
            //variable named numTransferred.
            //Now if we run the code like this we will see that datacopy file is created but it contains only gibberish
            //The reason for that is channel we passed in below method is same channel we used above to read integers
            //above and it is currently at the position after the last integer read.
            //The last integer we read above is int 1 on line 53 . and since transferFrom uses relative position
            //so for channel it will try to read after postion of int 1.
            //so to fix this we have to use absolute position i.e set position of int to 0. before using transferFrom
            // as we do below.
            channel.position(0);
          //  long numTransferred = copyChannel.transferFrom(channel,0,channel.size());

            //No similar  to transferFrom we have a transferTo method which is actually used on source channel rather
            //destination channel . So kind of opposite of transferFrom but does the same job that is transferring files.
            //so we see paramters are little different than transferFrom.
            // we pass the position as first argument , then total byte size and since we are using this method
            //on source channel , we pass destination channel as argument.
            //Please note that transferTo and trasnferFrom can be used to copy data when source or destination files are
            //open .
            //If not we can even transfer data using File class.
            long numTransferred = channel.transferTo(0,channel.size(),copyChannel);

            System.out.println("Num transferred = "+ numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();






        }

        catch (IOException e){
            e.printStackTrace();
        }


    }


}



