package com.readwrite2;

import java.io.IOException;
import java.nio.file.*;

public class Main14 {

    public static void main(String[] args) {
      //In this class we will see how to read contents of a directory.
        //We get path of directory here
        Path directory =  FileSystems.getDefault().getPath("FilesTree\\Dir2");

        //Files.newDirectoryStream returns a directory stream of paths
        //DirectoryStream is an interface that implements iterable interface .so we can iterate over the contents
        // of the Path to get all contents of the dir folder.
        //Please note that below code will only print contents of dir one level down.
        //i.e it will print Dir3 which is directory in Dir2 ,but it will not print any contents of Dir3.
      //  try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory)){

            //Also as we know if there are chances of two different kind of exceptions to be thrown then instead of using
            //two different catch blocks we can simply use a pipe character | and put both exception in one catch block
            //like we have done below for IOException and DirectoryIteratorException

        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,"*.dat")){




            for(Path file:contents){
                System.out.println(file.getFileName());
            }

          //We can even filter our directory to only print specific files in  a directory
          //We can do that using a filter as second parameter to newDirectoryStream method.
          //Few examples are
            // *.dat will any path with a .dat extension
            //*.{dat,txt} will match any path that has the extension .dat or .txt
            //? matches exactly one character . like ??? will ,match a three character file
            //myfile* matches any path that begins with myfile
            //b?*.txt matches any path that are atleast two characters and begins with a b.
            // so b and then atleast one character ? and 0 or more characters for *

        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

    }
}