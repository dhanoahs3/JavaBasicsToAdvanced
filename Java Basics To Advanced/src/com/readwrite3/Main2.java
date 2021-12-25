package com.readwrite3;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main2 {

    public static void main(String[] args) {

        //Now we all know that older versions of java used io methods and new ones use
        //java.nio
        //we can convert from java.io to java.nio like we are doing with  a File below

        //Please note that just like paths the file name we pass in File constructor does not have to exist until
        // we use it. and even then it is sometimes ok when file does not exist  when using with streams as in that
        //case the file will then be created
          //So we can convert a java.io File instance to Path instance as below.
        File file = new File("C\\Examples\\file1.txt");
        Path covertedPath = file.toPath();
        System.out.println("The converted path is " + covertedPath);
        //Now once we got path object we can then use it with all java.nio methods
        //Like is last video we have seen path.resolve method that takes part of path and results in
        //relative to another path instance
        // We can do the same using File  class but we can only do that when object of file is created using
        //the version of constructor that takes the file and String as parameter or the extracted version that takes
        //two Strings

        File parent = new File("C:\\Examples");
        //so here we created instance of parent that is use to invoke the resolve method
        // and we pass it as argument to new File and child part of file as other parameter
        File resolvedFile = new File(parent, "dir\\file.txt");
        // and we use resolvedFile method to get the path
        System.out.println("The resolved path is " + resolvedFile.toPath());

        //Another way of doing it is like below. Here we are passing both parent and child as String and we get same results

        resolvedFile = new File("C:\\Examples", "dir\\file.txt");
        System.out.println("The resolved path is " + resolvedFile.toPath());


        //Both methods used above are also  equivalent to doing something like below


        Path parentPath = Paths.get("C:\\Examples");
        Path childRelativePAth = Paths.get("dir\\file.txt");
        System.out.println("The resolved path is " + parentPath.resolve(childRelativePAth));


        // io methods to rename and delete files are File.renameTo() and File.delete()

        // Now we know we have used   Path copyPath = FileSystems.getDefault().getPath   to get current working directory.
        //But when we are working with java.io we have to use File instance and not paths so there are many drawbacks to get
        //working directory
        //that is why java.nio is much better than java.io when working with paths.

        //But there is a hack for java.io to get current Working directory

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("The current working directory is "+workingDirectory.getAbsolutePath());

        //The reason above method works is when we pass empty String to File constructor it translates it to
        //current  directory for us which is working directory for us

        //Another difference between java.io and java.nio methods is the way they list contents of directory for us
        //We have seen when working with nio we use directory streams but when we work with io we use file.list and
        // file.listFiles method

        //These  methods do the same thing but list method returns an array of String and listFile method returns array
        //of files
        //we can also pass an optional filtering parameter to that method

        //Please note the below method will only print one level deep that is it will print Dir3 but not anything
        //inside Dir3. For printing contents inside Dir3 we use walkFileTree methods in java.nio package.

        System.out.println("------------print Dir2 contents using list method");
        File dir2File =  new File(workingDirectory,"\\FileTree1\\Dir2");
        String[] dir2Contents =   dir2File.list();
        for(int i = 0;i<dir2Contents.length;i++){
            System.out.println("i="+i+" : "+dir2Contents[i]);
        }

        //Now lets do the same using listFiles method. This method will also  only print one level deep
        // that is it will print Dir3 but not anything inside Dir3.
        System.out.println("------------print Dir2 contents using listFiles method");
        File[] dir2Files =  dir2File.listFiles();
        for(int i = 0;i<dir2Files.length;i++){
            //only major difference in list and listFiles method is here we are using getName
            //method to print and it returns the last segment of filePath which in case in the file name
            System.out.println("i="+i+" : "+dir2Files[i].getName());
        }


        //Now we have discussed before how to get Systems root drives and file stores and how this can be
        //problematic.  we can use the files.listRoots  method to get the roots ,but it has the same problems
        //as fileSystem.getRootDirectories method .So it list drive letters for drives that actually aren't available.

        //So if there is one thing that we can take away from all the discussions is we should use java.nio methods
        //when working with FileSystems ,but when it is reading and writing file contents sometimes java.io is better
        //choice
        // we should not benchmark and decide what is best for our application and as mentioned use java.nio
        //when working with FileSystems ,but when it is reading and writing file contents sometimes java.io is better
        //choice




    }

}

