package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;



public class Main6 {
          /* Lets learn to use random access using java.nio i.e how to actually read data randomly from a file
          that is read data non-sequentially.
          * for that we use interface called seekable byte channel. it has 6 methods as well.
          * 1. read(ByteBuffer) -reads bytes at beginning of channels current position and after the read ,updates the
          positions accordingly.Note here we are talking about channels position and not the byte buffer position
          Off course bytes will be placed in channel starting at current position.
          * 2. write(ByteBuffer)- same as read ,but it writes data to file.Tere is one exception. if datasource is opened
          in APPEND mode ,then first write will take place starting at end of datasource rather than position 0 .After
          the write the position will be u[dated accordingly.
          * 3. position - returns the channel's position
          * 4. position(long) - sets the channel's position to passed value.
          * 5. truncate(long) - truncates the size of attached datasource to the passed value.
          * 6.  size() -returns the size of attached datasource

          * */


    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("data2.dat");
             FileChannel binChannel = binFile.getChannel()) {

            //So in this code what we will do is we save start position before writing integers to file.
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello world".getBytes();
            buffer.put(outputBytes);
            //so before writing int 245 we find its start position  . so its start position will be
            // equal to length of Hello world String.
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            //position of -98765 would be position of intpos1 plus the size of int 245 which
            //is equal to Integer.BYTES.
            long int2Pos = int1Pos+Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            //position of 1000 would be position of intpos2  plus the size of int -98765 which
            //is equal to Integer.BYTES and plus the size of outputByte2 as we wrote outputByte2 as well
            // after we wrote -98765  so position would be addition of all 3 positions.
            long int3Pos = int2Pos+Integer.BYTES+outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

            //Now we have calculated the positions of 3 integers earlier and here we are going to
            //read 3 integers in reverse order. i.e read 1000 ,then we will read 98765 and then we will read 245
            //based on positions we calculated above.

            RandomAccessFile ra = new RandomAccessFile("data2.dat","rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            //get position of int3
            channel.position(int3Pos);
            //then read the channel and write data to buffer
            channel.read(readBuffer);
            //then if we want to write data to console using System.out.println we need to use flip before
            //doing that.
            readBuffer.flip();
            System.out.println("int3 = "+readBuffer.getInt());
            //Then after writing the data to console we need to flip again to read data from position2 for channel as well
            // and write it to buffer from channel
            readBuffer.flip();

            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = "+readBuffer.getInt());
            readBuffer.flip();


            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = "+readBuffer.getInt());


           /*Now let us try one more thing. let us write data to file in non sequential manner. i.e write data to file
           * based on positions rather than writing data in a particular sequence.
           * For that we set the positions af both the Strings and all the 3 integers.
           * */

            byte[] outputString = "Hello world".getBytes();
            long str1Pos =0; //position of Hello world String is 0.

            long newInt1Pos = outputString.length; //position of first int is after Hello world String.

            long newInt2Pos = newInt1Pos+Integer.BYTES;   //position of second int is after position of first int.

            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES; //position of second String if after the second int
            long newInt3Pos = str2Pos+outputString2.length; // position of third int is after String "Nice to meet you"

            //Then down below we are writing all the 3 integers. So for each integer we are writing the values to the buffer
            // then we flip the buffer to prepare to write it to the channel. we set the channel position to where we
            //want to write and then we write to that location.

            //Basically its all about flip. first we are writing data to buffer using putInt method.
            //and after that we are reading from buffer but writing to channel using binChannel.write.
            //Now if we don't use flip after putInt then position in the buffer will be after the location of integer
            //and when channel tries to read from buffer it will not find anything as position will be after the 5 of 245
            //so it will throw buffer overflow error.
            //so when we use flip after putInt(245) the position of buffer will be set back to start of 245 so that channel
            // can read from the buffer to write it to the file.

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            //then we again flip the buffer to write next int to the buffer
            intBuffer.flip();
            intBuffer.putInt(-98765);
            //Then again flip to write to the channel.
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            //writing the Strings is simpler . we use wrap method here instead of flip. so wrap takes care of flipping
            //and writing so code is simpler.

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));

            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));

            //so after we run this code nothing will change in data2.dat file as we have written the code in the
            //same positions as before . only difference is we have not written data in sequence but have instead written
            // at certain positions

        }

        catch (IOException e){
            e.printStackTrace();
        }


    }


}



