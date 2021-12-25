package com.readwrite2;

import java.nio.file.*;

public class Main11 {

    public static void main(String[] args) {

        //Pleas note that Path class never knows if a path actually exists or not.
        //So if we try something like this it will simply print  the path and will not through an error
        Path path  = FileSystems.getDefault().getPath("files","thispathdoesn'texist");
        System.out.println(path.toAbsolutePath());

        //Same way it will print absolute path without knowing if it exists or not

        System.out.println("----------------absolute path-----------------------------");

        Path path2  = Paths.get("C:\\","report\\","thispathdoesn'texist");
        System.out.println(path2.toAbsolutePath());

        //So if we are creating a bufferedreader to read the file only then an exception will be thrown
        //that files does not exist otherwise Path class is just happy simply printing the path
        // Now if we are creating a new file we don't care if it exists or not.
        //But we need to find out if the directory in which we want to create a file exits or not
        // Now to find out  the existence of a file or directory we do the following

        System.out.println("----------------To check if directory named files exists or not--------------------");


        Path filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Directory Exists = "+ Files.exists(filePath));

        System.out.println("Directory Exists = "+ Files.exists(path2));


        //We can even check whether a file exits or not like this

        System.out.println("File exists = "+ Files.exists(path));





    }
}
