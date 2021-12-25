package com.readwrite2;

import java.io.IOException;
import java.nio.file.*;

public class Main15 {

    public static void main(String[] args) {
 //If we want to print only files and not the directory we can use something like below
        //We make a filter that checks if a path is a regular file i.e it is not a directory.
        DirectoryStream.Filter<Path> filter =
                new DirectoryStream.Filter<Path>() {
                    public boolean accept(Path path) throws IOException {
                        return (Files.isRegularFile(path));
                    }
                };

        //we can  also create the above filter  using a lambda expression like below
       // DirectoryStream.Filter<Path> filter = p->Files.isRegularFile(p);


        Path directory =  FileSystems.getDefault().getPath("FilesTree\\Dir2");
        //Then pass the above filter to the  method newDirectoryStream and it will print only files and not the
        //directory
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,filter)){
            for(Path file:contents){
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

    }
}
