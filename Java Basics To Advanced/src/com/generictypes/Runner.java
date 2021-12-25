package com.generictypes;

import java.util.ArrayList;

public class Runner {
/*It is always best practice to define what type of objects a ArrayList is about to hold
* so that if we try to add an object of any other type rather than the one defined we will get an error at compile
* time itself rather than getting error at run time
* For example if we dont define the type like this
* ArrayList items = new ArrayList();
* then add a few objects of type Integer  items.add(2); items.add(3);
* Then trying adding a String         items.add("tim");
 we will only get an error at run time which is not good
 * So we want ot get error at compile time itself so we use generics for that
 * i.e we define our Arraylist like this
 *         ArrayList<Integer> items = new ArrayList();
 *  * Then this will give error compile time itself         items.add("tim");
 * if version of java is less than eight define object type on right side as well like this
 *         ArrayList<Integer> items = new ArrayList<Integer>();
 *Please note we also need to define object type when passing Arraylist as parameter to methods
 *     public static void printDoubled(ArrayList<Integer> n){

*/
    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);//Here the primitive type 1 is converted to the "object Integer" as Arraylist only stores integers
        items.add(2);
        items.add(3);
     //   items.add("tim");
        items.add(4);
        items.add(5);
        printDoubled(items);
    }
    public static void printDoubled(ArrayList<Integer> n){
        for(int i:n){
         System.out.println(i*2);
        }
    }
}
