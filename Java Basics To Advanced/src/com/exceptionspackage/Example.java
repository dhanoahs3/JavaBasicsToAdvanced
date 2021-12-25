package com.exceptionspackage;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/*We can have more than one catch blocks for a try block or as shown below we can have two try or more
exceptions in one catch block  using | symbol. Please note this (|)feature  for catch block
is only available since java 7.
And for the catch block we can either have e.toString() to have a brief message about which exception was
thrown or we can print the entire stackTrace like this
     e.printStackTrace();

*/
public class Example {
   public static void main(String[] args){
       try{
       int result = divide();
       System.out.println(result);
       }
       catch(NoSuchElementException |ArithmeticException e){
           System.out.println(e.toString());
       }
      /* catch(NoSuchElementException e ){
           System.out.println(e.toString());
       }
       catch (ArithmeticException e){
           System.out.println(e.toString());
       }*/
   }

   public static int divide(){
       int x = getInt();
       int y = getInt();
       System.out.println("x is "+x +" and y is "+y);
       return x/y;
   }
   public static int getInt(){
       Scanner s= new Scanner(System.in);
       System.out.println("Please enter the no of your choice ");
       while(true) {
           try {
               /*if no entered by user is valid just return that no
               i.e get out of while loop and get out of getInt function itself
               and hence never go to catch block*/
               return s.nextInt();
           } catch (InputMismatchException e) {
               /*if we are in catch block that is user didn't enter any valid no
               * then go to next line ,print message that please enter no between 0 to 9
               * and since we are using while(true) it will run try block again */
               s.nextLine();
               System.out.println("Please enter a number between 0 and 9");
           }
       }
   }
}
