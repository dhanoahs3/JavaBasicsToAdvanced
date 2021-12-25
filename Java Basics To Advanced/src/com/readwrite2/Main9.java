package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.file.*;
import java.util.*;



public class Main9 {


    public static void main(String[] args) {
        //We will use two threads. one that writes to the sink channel and one that reads from the source channel.
        try{
            Pipe pipe = Pipe.open();
            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        //Here write method is calling pipe.sink method to get the sink channel
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        //it then allocated a buffer
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "This line is: =" + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            //Now lets read from the source channel

            Runnable reader  = new Runnable() {
                @Override
                public void run() {
                    try {
                        //calling pipe.source method to get to the source channel
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString  = new byte[bytesRead];
                            buffer.flip();
                            //Then we are writing to the buffer and reading from the channel.
                            buffer.get(timeString);
                            //Then we are writing to the console after reading from the buffer
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(1000);
                        }
                    }

                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();


        }

        catch(Exception e){
            e.printStackTrace();
        }

    }


}





