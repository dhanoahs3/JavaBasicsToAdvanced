package com.arrayspackage;

import javax.swing.*;
import java.util.Arrays;

/*Two ways of defining an array. We can either define an array and all its values there itself or we can define
 * then one by one in coming lines. to find length of array we use length
 * Please note on right hand side in second case we have to  define  new String i.e the data type .
 * it can also be new Int and then give the size of array like new String[3]
 * we can even pass an array to function as below or return an array well from a function
 * So major takeway is when ever we want to pass an array or define an array that returns an array we have to use
 * square brackets along with data type like String[] or int[]
 * To print an array we use  System.out.println(Arrays.toString(myIntArray));
 * another concept is of reference and values
 *  String[] stringArray = new String[3];
 * Here stringArray is reference and newString[3] is a value
 * two references can point to same value   String[] anotherStringArray = stringArray
 * above the newly created reference will point to the same value to which stringArray is pointing to
 * And we can also make a reference to point to a new value
 * string Array = new String[3]
 * By doing above reference to  value new String[3] if no reference points to it.

 * */

public class Runner {
    public static void main(String[] args) {

   int[] integerArray = {1,2,3,4,5,6,7,8,9,10};
        String[] stringArray = new String[3];  //
        stringArray[0] = "Hello";
        stringArray[1] = "World";
        stringArray[2] = "Program";
        for(int i=0; i<integerArray.length;i++){
            System.out.println("The "+ i +" th element of integer array is "+integerArray[i]);
        }
        passArray(stringArray);
        String[] newStringArray = returnArray();
        for(int i=0; i<newStringArray.length;i++){
            System.out.println("The "+ i +" th element return  array is "+newStringArray[i]);
        }

        int[] copiedIntegerArray =   copyArray(integerArray);
        for(int i=0; i<copiedIntegerArray.length;i++){
            System.out.println("The "+ i +" th element of copied integer array is "+copiedIntegerArray[i]);
        }

        int[] myIntArray = new int[]{1,2,3,4,5};
        int[] anotherIntArray = myIntArray;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherIntArray));
        myIntArray = new int[]{6,7,8,9,10};
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherIntArray));



    }
    public static void passArray(String[] strArray){
        for(int i=0; i< strArray.length;i++){
            System.out.println("The "+ i +" th element of string array is "+strArray[i]);
        }
    }
        public static String[] returnArray(){
         String[] newArrayStr = new String[2];
         newArrayStr[0] = "New";
         newArrayStr[1] = "Array";
         return newArrayStr;
    }

    public static int[] copyArray(int[] intArray){
        int[] newIntegerArray = new int[intArray.length];
        for(int i=0; i< intArray.length;i++){
            newIntegerArray[i] = intArray[i];
        }
        return newIntegerArray;
    }

    }