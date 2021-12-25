package com.readwrite3;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main1 {

    public static void main(String[] args) {
              System.out.println("Walking Tree for Dir 2");
              Path dir2Path = FileSystems.getDefault().getPath("FileTree1"+File.separator+"Dir2");
              try{
                  //So walk Tree is the method to print all files in Dir ,even file inside other directories in Dir2
                  //and we already made the class PrintNames and overrode all required methods.
                  Files.walkFileTree(dir2Path,new PrintNames());
                  //There is another version of walkFileTree that accepts 4 parameters.
                  //Additional 2 parameters tell us the no of levels to traverse and to pass a set of FileVisit options
                  //right now the only option available is the one that follows symbolic links

                  //When we are only printing names it doesn't matter if we are using preVisitDirectoryMethod
                  //or postVisitDirectory Method
                  //But it matters if we want to copy a file then we want to handle  directory before
                  // we handle the entries because the copy of the directory will have to exist before we copy
                  //entries into it. In that scenario we handle the directory using preVisitDirectory method.
                  //On the other handle if we want to delete a directory we will need postVisitDirectory method as we
                  //need to delete all entries in a directory and all its descendants before we delete the actual directory
                 //so whether to use preVisitDirectory  or postVisitDirectory depends upon the task we are about to perform .
              }
              catch (IOException e){
                  System.out.println(e.getMessage());
              }

              System.out.println("-------Copy Dir3 to Dir4/DirCopy------------");
              Path copyPath = FileSystems.getDefault().getPath("FileTree1"+File.separator+"Dir4"+File.separator+"Dir2Copy");
              System.out.println(copyPath);

              //so path will be like FileTree1\\Dir4\\Dir2Copy

           try{
               Files.walkFileTree(dir2Path,new CopyFiles(dir2Path,copyPath));
           }

              catch(Exception e){
               System.out.println(e.getMessage());
              }
    }
   //In real world we need to look into if files or directories already exist . i

    //if file already exist we can prompt user whether to override the file or not.
    //if file already exist we can prompt user whether to override the file or not.

    //if dir  already exits we need to decide if it was an error.
    // we can pass more parameters to copy method to figure out what to do if destination already exists .
}
