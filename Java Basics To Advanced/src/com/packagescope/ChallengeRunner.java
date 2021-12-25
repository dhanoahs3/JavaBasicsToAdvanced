package com.packagescope;

import java.util.Scanner;
/*Please note this is just an example where we have named a class X . We named class variable as x. We named variable in
* for loop as x as well. We named method as x(). We even tried with scanner variable Scanner x
* Naming everything as x is very bad coding practice. We have just named x to demonstrate between class variable x
* and for loop variable x*/
public class ChallengeRunner {
    public static void main(String[] args) {
     /* Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter a no of your choice");
      X x = new X(scanner.nextInt());*/
     //One approach can be the one used in above three lines
        // A different approach the below one line. the last line remains
        // the same for both the approaches.
        // Please change the constructor in X class as well.

        X x = new X(new Scanner((System.in)));
        x.x();


    }
}
