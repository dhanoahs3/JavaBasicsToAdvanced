package com.readwrite3;

 /*  Now we know if we want to search for all files in Dir2 folder there is an issue.
        Dir2 will be considered the root of file tree ,but it will only search all files that are directly under Dir2
        that is like Dir3 ,File1.txt etc but will not search any files that are in Dir3 directory.

        Same way if we want to copy files from Dir2 it will never copy files that are one level down i.e in dir Dir3.
        If will only copy files that are under Dir2 like File1.txt etc

        so for the above actions we have to walk down the file  tree to Dir3 etc.

        To walk down the file tree we need to use FileVisitorInterface.
        Using this interface we can run code at each stage of traversal process.

        Some methods of this interface are
        1. preVisitDirectory() -This method accepts reference to the directory and the basicAttributes instance for the
        directory.It is called before entries in the directory are visited.

        2. postVisitDirectory() -This method accepts reference to the directory and an exception object(when necessary)
        .It is called after entries in the directory  and all its descendants are visited.The exception parameters will
        be set when an exception happens during the traversal of the entries and the descendants.
        There a way  to skip files as you are traversing so not every file has to have been visited for this method to be
        called. Every file has to be visited or  explicitly skipped. Of course if an exception is thrown and not handled
        the traversal will prematurely end and postVisitDirectory  will be called.

        3. visitFile() - This method accepts a reference to the file and a BasicAttributes instance. This is where you
        run the code that will operate on the file. Its only called for files.

        4.visitFileFailed() - This method is called when a file can't be accessed . The exception that is thrown is
         passed  to the method. We can decide what to do with it (throw it ,print it or anything else that makes sense
         for the application and operation being performed. Can be called for files and directories)

             So for all the above methods we will simply extend a class called SimpleFileVisitor that implements
          FileVisitor Interface. so we can use some of the methods of this class SimpleFileVisitor to transverse
          through all directories of Dir2 and print all the contents of each sub directory as we go
        */


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//Please note when extending SimpleFileVisitor we are specifying it as of type Path
//So the methods we will be extending will also have first parameter as of type Path
public class PrintNames extends SimpleFileVisitor<Path> {

    //Now let us override visitFile method

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //Here wew  are printing the complete filepath
        System.out.println(file.toAbsolutePath());
        //Here we are returning CONTINUE
        return FileVisitResult.CONTINUE;
        //we can even return SKIP_SIBLINGS which means traversal should skip all other entries in the same directory
         //as the file

        //SKIP_SUBTREE is used when we want to skip a directory
        //TERMINATE is used when we want to stop a traversal. like when we have found a file and want to stop
        //the traversal so we retun TERMINATE once file is found.
        //It only makes sense to return SKIP_SUBTREE from pre visit directory method.
        //Returning it from other methods is equivalent to CONTINUE.
        //Also if we return SKIP_SIBLING from pre visit directory then directory itself is also skipped and post visit
        //directory method is never called for that directory. so we are basically saying is we  want to completely
        // want to ignore directory and its contents
    }

    //Now let us override preVisitDirectory and postVisitDirectory  as well

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;    }


        //if we don't implement the visitFileFailed method and an error occurs then IOEXception will be thrown
        // But we can actually notify the user and continue the traversal using the below method.
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error access file :"+file.toAbsolutePath()+ "  "+exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}