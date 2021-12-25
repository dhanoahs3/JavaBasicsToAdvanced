package com.exceptionspackage;
/*Two ways to write a program
* 1.Look before you leap - check all the conditions before hand. i.e check conditions like
* map is not null or no is not 0 etc etc so that no exception is thrown. example all LBYP methods below
* 2 Easy to ask for forgive and permissions - second method is to use exceptions. example all EAFP methods below.*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args){
        int x = 10;
        int y =0;
        System.out.println(divLBLY(x,y));
        System.out.println(divEAFP(x,y));
     //   System.out.println(div(x,y));
           int number =  getIntLBYP();
           System.out.println("The number entered is "+number);

           number =  getIntEAFP();
           System.out.println("The number entered is second method is  "+number);
    }


    public static int  divLBLY(int x,int y){
        if(y!=0){
            return x/y;
        }
        return 0;
    }

    public static int  divEAFP(int x,int y){
        try {
            return x / y;
        }
        catch(ArithmeticException e) {
                return 0;
        }
    }

    public static int  div(int x,int y){
            return x / y;
    }

    public static int getIntLBYP() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter your integer");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            System.out.println("The character is " + input.charAt(i));
            if (!Character.isDigit(input.charAt(i))) {
                System.out.println("in the inner if");
                isValid = false;
                break;
            }
        }
            if (isValid) {
                return Integer.parseInt(input);
            }
        return 0;
    }

    public static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter your integer");
        try {
            int input = s.nextInt();
            return input;
        }
        catch(InputMismatchException e){
            return 0;
        }

    }
}
