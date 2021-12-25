package com.readwrite2;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main16 {

    public static void main(String[] args) {

        //In a real world examples we will use File separators instead of providing backslashes like we use do earlier
        //Just for testing we can print the File separators used in windows  lik this
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);



        //we can  also create the above filter  using a lambda expression like below
        DirectoryStream.Filter<Path> filter = p->Files.isRegularFile(p);

         //We can use File.separator in our application like this. so instead of \\ use the below.
        Path directory =  FileSystems.getDefault().getPath("FilesTree"+File.separator+"Dir2");

        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,filter)){
            for(Path file:contents){
                System.out.println(file.getFileName());
            }


        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        //Creating temporary files. We can create temporary files in Java like below
        //Here first argument is the name of our file we want to create and second argument is the extension of the file
        //We can have a third  optional parameter as well that specifies the attributes of the file. But we don't need that
        // for temp files.


        try{Path tempFile = Files.createTempFile("myapp",".appext");
            System.out.println("Temporary file path is "+tempFile.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }


        //We can even print volumes on which our drives are mounted and actual drives using below methods
        //Here getFileStores returns an iteratable of all volumes on our System.
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store :stores){
            //This will print name of volume name and driver letter. In our case it just drive names
            //like c drive etc
            System.out.println("Voume name/drive letter  "+store);
            //This will print just the file store. But it does not print anything in our case
            System.out.println("File Store: "+store.name());
        }
        //We can also parse the String to get drive letter. Some developers find it risky based on formatting of
        //String that is happening but likely hood of that happening is very very low.

        //We can do things in another way as well. The way we will be doing it is not ideal though . but lets still try
        //It will print all drive letters like C:\ ,E:\ etc. It will print all available drive letters like
        // it will also print  E drive which is not always there on our System but is only available when we connect
        // a usb or phone to our pc
        //These methods to print drives are not very useful as there are
        //  are not many use cases as once an application is installed on a System ,it remembers
        // where it is installed . So we may never need to know root directories etc. but just in case we do the
        // method is below
        System.out.println("--------------------------------------------------------");

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths) {
            System.out.println(path);
        }
    }
}
