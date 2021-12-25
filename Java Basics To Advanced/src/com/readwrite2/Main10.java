package com.readwrite2;



import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.file.*;
import java.util.*;

/*File Paths . We know C:\downloads\file.txt is an absolute path where C is the root node
* But we also know that photos\img1.jog is a relative path so this path need to be combined with another path that
* contains the root node.
* On windows delimiter is a backslash, on unix its a forward slash.
* In earlier examples we have seen this
*
* Path dataPAth = FileSystems.getDefault().getPath("data.txt");
*
* So in this example getDefault method returns the current working directory.
* The working directory is then combined with the the path we provided in getPath("" ) to get the complete path
*
* So we can also do the following to provide the absolute path as well. Please note we have to use another backslash
* \ to escape the backslash being used in our file path
*
* Path dataPath = Paths.get("C\\MyIdeaProject\\Projects\\data.txt");
*
* We create a new file by right clicking on project and name it WorkingDirectoryFile.txt and paste something in it.
* Then we create a new directory by right clicking on project and name it files.
* Then in this files directory/folder and we add a new text file named SubDirectory.
*
* Then in C drive in reports folder we can add a new txt file named outhere.txt
** */

public class Main10 {


    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        System.out.println("----------------------------------------------------------------------");

        Path subDirPath  = FileSystems.getDefault().getPath("files","SubDirectoryFile.txt");
        printFile(subDirPath);


        System.out.println("----------------------------------------------------------------------");

        Path outsideDirPath  = Paths.get("C:\\report\\outthere.txt");
        printFile(outsideDirPath);

        System.out.println("------------------  To print complete path -----------------------------");


        Path  filePath = Paths.get("."); //This gives the absolute or complete path of our working directory of our project
        //we can then print the path represented by above Path object using toAbsolutePath method.
        //Please note it will append a /. at the end of or project directory
        //C:\web-tests\Java Basics to Advanced\.
        System.out.println(filePath.toAbsolutePath());


        //Now we know we used this to build path to one of our directories
       // Path subDirPath  = FileSystems.getDefault().getPath("files","SubDirectoryFile.txt");
       // We can do it the other way around as well using the . as we have done below

        System.out.println("------------------  printing sub dir again -----------------------------");

       //Please note we can pass as many arguments we want to Paths.get to move down a directory structure.
        //Like we can do ".","files" ,"subfilesfolder" ,"anotherfolderinsubfiles" ,"subDirectoryFile.text" etc
        subDirPath  = Paths.get(".","files","SubDirectoryFile.txt");
        printFile(subDirPath);

        System.out.println("------------------  printing outside dir again another way -----------------------------");

        outsideDirPath  = Paths.get("C:\\","report\\","outthere.txt");

        //Another way to do the same is using single forward slash instead of backslash line we have done below
       // outsideDirPath  = Paths.get("C:","/report","/outthere.txt");

        printFile(outsideDirPath);


        System.out.println("------------------normalised path -----------------------------");

        //we have seen above that if we print the absolute path its prints a /. at the end of the path of our current
        //directory. Now lets look at an example of playing with dots.
        //The below example will first get project path using . although . is not needed as we are using getDefault().getPath()
        // and not using Paths.get()
        //Then we are going to files. But then we are using .. to move one level up . so it will move back from files to
        //project folder level and then we again go to files and then go to subDirectoryFile
        //then we use normalise to print the complete path in next line
        //then we use printFile to print entire path.
        //Please note its better to use normalise when printing contents of a file when we are building path based on
        //lots of dots(..)

        subDirPath  = FileSystems.getDefault().getPath(".","files","..","files","SubDirectoryFile.txt");
        System.out.println("The normalised path is ----->"+subDirPath.normalize().toAbsolutePath());
        printFile(subDirPath.normalize());

        //Now another discussion . We know that File class can also return the path of a File.
        //So why did java come up with  Path class to get paths of a file
        //Reason is java File class has few problems.
        //It does not throw exceptions or specific errors if something fails.
        //For example File.delete() returns true or false if file is deleted successfully.
        //But if it fails to delete the file it doesn't tell whether deletion failed because file does not exist
        // or we don't have permissions to delete the file.

        //Another example is File.rename -->It works differently on different OS like windows ,macs etc although
        //they are supposed to work the same on all OS.

        //Another issue is File class has no support for symbolic links.
        //Symbolic links are used when one files points to another

        //Also File class does not provide info about meta data in a file . like file permissions etc

        //One last issue is many methods in File class don't perform well with lots of data.
        //Like if we use File class to find all files in a directory the method can hang is there are lots of files
        //in that directory.

    }


     public static void printFile(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;
            while((line=fileReader.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
}



}






