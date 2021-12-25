package com.readwrite2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main12 {

    public static void main(String[] args) {
        //code to copy file1.txt from examples folder and make a new copy in the same folder under the name filecopy.txt
        //First time we run the program it will create the copy as filecopy.txt does not exist
        //second time we run it will throw exception saying filecopy.txt already exists. So to overwrite the existing
        //file we can do the following i.e pass a third parameter to overloaded copy method to replace existing file
        // Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);

        try{
            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples","filecopy.txt");

          //  Files.copy(sourceFile,copyFile);
           // Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);

            //We can even copy an entire Dir as follows. Below we can make a copy of Dir1 and name it as Dir4
            //Please note that the below code will only copy the folder Dir1 and not any of the files in Dir1

            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
            copyFile = FileSystems.getDefault().getPath("Examples","Dir4");
         //   Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);


           /* Now let us say how to move a file from one folder to move.

            Path fileToMove = FileSystems.getDefault().getPath("Examples","filecopy.txt");
            Path destination  = FileSystems.getDefault().getPath("Examples","Dir1","filecopy.txt");
            Files.move(fileToMove,destination);
*/

           /*Renaming a file is similar to move. We do the same as above. Only difference is source and destination folder
                    are the same. that is move the file to the same folder. only name it differently

            Path fileToMove = FileSystems.getDefault().getPath("Examples","file1.txt");
            Path destination  = FileSystems.getDefault().getPath("Examples","file1.txt");
            Files.move(fileToMove,destination);

            */

           // Lets delete a file now
            Path fileToDelete  = FileSystems.getDefault().getPath("Examples","Dir1","filecopy.txt");

        //    Files.delete(fileToDelete);

            //Please note the above line of code will throw an error if file to be deleted does not exist.
            //To overcome this exception we use the following

            Files.deleteIfExists(fileToDelete);

            //Also note that if we try to delete a Directory that is not empty an exception will be thrown
            //We will see more about deleting directories in next video.






        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}