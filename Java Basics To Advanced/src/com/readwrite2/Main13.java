package com.readwrite2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main13 {

    public static void main(String[] args) {
        //To create a file we use the following
        //Please note that to write to this file we need to create a channel so there is no point in creating a file
        //like the one below.
        //But the method is there for knowledge sake.
        try {
           // Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
           //   Files.createFile(fileToCreate);


           /* Now lets create a directory

            Path directoryToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.createDirectory(directoryToCreate);*/

          /* Now lets create multiple directories in one go i.e dir 4 ,dir 5,dir 6 all in one go in dir 3

            Path directoriesToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
            Files.createDirectories(directoriesToCreate);*/

            //or we can do something like this

           // Path directoriesToCreate1 = FileSystems.getDefault().getPath("Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
          //  Files.createDirectories(directoriesToCreate1);

          //Now lets see how to get File metadata or File attributes. i.e file size , last modified date etc.

            Path file = FileSystems.getDefault().getPath("Examples", "Dir1","File1.txt");
            System.out.println("The size of file is "+Files.size(file));
            System.out.println("The file was last modified "+Files.getLastModifiedTime(file));

            //Another way to get all the arrtibutes of a file in one go is use the BasicFileAttributes class like below


            BasicFileAttributes attrs = Files.readAttributes(file,BasicFileAttributes.class);
            System.out.println("The size of file is "+ attrs.size());
            System.out.println("The file was last modified "+ attrs.lastModifiedTime());
            System.out.println("The file was created on  "+ attrs.creationTime());
            System.out.println("Is it a directory ? "+ attrs.isDirectory());
            System.out.println("Is it a regular file ?  "+ attrs.isRegularFile());

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }


}