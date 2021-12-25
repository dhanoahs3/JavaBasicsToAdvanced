package com.readwrite3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//Now what  we are trying to do is copy File named File1.txt from Dir3 directory from Dir2
// to  a folder named DirCopy in Dir4.
//Please note DirCopy still does not exist in Dir2. it will be created when we copy files.
// So relative path of file in both source and destination will be Dir3\file1.txt
//So we going to call relativised method to get relative path to the source root
//So an example is as below


// sourceFolder = "FileTree\Dir2\Dir3\File1.txt";
// sourceRoot = "FileTree\Dir2";
//targetRoot = "FileTree\Dir4\DirCopy;
//relativizedPath = sourceRoot.relativize(sourcePath);  which will be "Dir3\File1.txt"
//relativizedPathForCopy = targetRoot.resolve(relativizedPath); which will be
//"FileTree\Dir4\Dir\DirCopy\Dir3\File1.txt

//So what be are doing above basically is we are figuring out relative path to source Root and appending it to
//target root because when doing a copy of relative path to both source and target, roots will be the same
//We have also seen we need both sourceRoot and targetRoot path to figure out path for  the copy
// but preVisitDirectory method
// and visitFile method are only passed a reference to the directory or file being visited.
//so we have to save the source and destination roots as instance variables in CopyFile class that we have created
//So we will add those fields in this class and constructor to handle this.


public class CopyFiles extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error access file :"+file.toAbsolutePath()+ "  "+exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        //To construct the path we use Path.relativize method .This method constructs a relative path
        // which resolves to a given path
        //For example if path to relativize against is C:\path1 and given path is C:\path1\path2\path3
        // then the relativised path is \path2\path3 which is given path relative to C:\path1
        //Now once we got the relative path  we then need to resolve it against copied directories locations by calling
        //by calling path.resolve method and that will turn the relative path we go from relativised method into the full
        //path for the copied file.


        //So over here we are getting relativized path for source directory and target directory
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("RelativisedPath = "+relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("RelativisedPath = "+copyDir);


        try{
            //We are then copying the files
            Files.copy(dir,copyDir);
        }
        catch(Exception e ){
            e.printStackTrace();
            //If an exception occurs  we will skip the subtree by using
            //  the below line of code i.e we will stop processing files for that subtree
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;

    }

    //Here we override visitFile method
    //In this method  ,just as in directory method
    // we use relativised method to find paths for copied files and then we can use
    //copy method to copy those files.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        //So over here we are getting relativized path to find paths for copied files.
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("RelativisedPath = "+relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("RelativisedPath = "+copyDir);


        try{
            //We are then copying the files
            Files.copy(file,copyDir);
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }
}
