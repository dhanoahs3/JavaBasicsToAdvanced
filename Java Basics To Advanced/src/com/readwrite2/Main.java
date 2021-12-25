package com.readwrite2;



import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;

/*Here in this class we will learn to read and write solely using java.nio packages.
java.nio reads and writes data in buffers or  blocks rather than one byte or character at a time
//In old java i/o packages data was read in bytes ,one byte or character at a time. and data was buffered when we
// wanted to read and write it in buffers.
//In java nio data is processed in blocks and instead of bytes on streams and we read/write blocks at a time

//We use channels and buffers to read and write blocks.

channel is data source we are reading or writing from like text file ,socket etc

Buffers are containers for block of data we want to read and write. We need to define the type of the container
i.e what type of data it is reading and also can define max size of container.

Selectors allow single threads to read and write . We won't we covering selectors here.
Earlier we used to create two instances to read and write data , like FileWriter and FileReader but
in nio we only need one instance to both read and write data
Also we don't need use buffered readers or writers as data we read or write using java.nio package is already
read or written in blocks.
   */

public class Main  {

    public static void main(String[] args) {
       /* Lets create a channel to read and write from a file
        We have created an instance of FileInputStream and then using file.getChannel method to create an
        instance of channel
        We said above that we can use only one channel to read and write data but here the case is different
         FileChannel is an exception to the rule. so if FileChannel is created using FileInputStream it will be
         only used for reading and if FileChannel is created FileOuutputStream it will be only used for writing
         Next we will create a buffer to read and write from a file.
         When we create a buffer  to use with a channel we need to define  size of buzzer to tell how many
         bytes will be read in one time.
         So what would be the size of the buffer in our case?
         We can create a buffer that size equal to length of each line  in our file as all lines in data.txt has
         same size. But what if lines in a file are of variable length? For example if first line is 25 bytes and then
         on second line its 100 bytes then if we make buffer size is 25 bytes then only 25 bytes will be read from second file
         and if we set buffer to 100 bytes then it will read 25 bytes from first line and then start reading from
         line two. so these are some of the problems with java.nio thats why its not widely used as java.io . These issues
         were fixes in java 8 but still java.nio is unpopular.
                */

        try{
            /*FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();*/

            //So due to issues we discussed above we will not be using the filechannel but instead we will read data
            //using below methods. Here we create object of filepath and then we use readAllLines which returns us
            //each line of data in form of String array.So instead of passing the no of bytes etc as above we discussed
            //we won't know what is the total size of bytes on each line we just use readAllLines and it reads one
            //line at a time

            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            //Now once running the below code and reading the data . we will now see how to write data. now for java.nio
            //each write is an individual operation so it will open file write data close file and then repeat the same
            //procedure again
            //So to avoid opening any closing files we should write data in chunks using String builder class
            //and since data is only written in bytes so we better convert String to bytes before writing.
            // here we are writing "Line 5 to a new line and need to convert it to bytes  and provide
            //charset type
            //The last parameter StandardOpenOption is imp. Using APPEND we are telling it to append at the end of
            //existing file.
            //StandardOpenOption.TRUNCATE_EXISTING - deletes the content of current file and writes again
            //StandardOpenOption.CREATE -created a new file.
            Files.write(dataPath,"\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);

            List<String> lines = Files.readAllLines(dataPath);
            for(String line:lines){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}


