package com.arrayspackage;

import java.util.ArrayList;
/*Arraylist is a class that inherits the List interface
* To define a list ---> ArrayList<String> groceryList = new ArrayList();
* to add items -->  groceryList.add("apples");
* to print items from a list groceryList.get(i)
* to change value at a particular index in list  groceryList.set(1,"kiwis");
* to remove an item as well as the index from the list   groceryList.remove(1);
* to check if a particular item is there in the list groceryList.contains("apples");
* to find the index no of an item in the list groceryList.indexOf("apples")
 * */
public class ArrayLists<D extends Number> {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList();
       groceryList.add("apples");
       groceryList.add("bananas");


       for(int i=0;i<groceryList.size();i++){
           System.out.println("The "+ (i+1)  + "th item in the groceryList is "+groceryList.get(i));
       }

       groceryList.set(1,"kiwis");

        for(int i=0;i<groceryList.size();i++){
            System.out.println("The "+ (i+1) + "th item in the updated groceryList is "+groceryList.get(i));
        }

        groceryList.remove(1);
        for(int i=0;i<groceryList.size();i++){
            System.out.println("The "+ (i+1) + "th item in the  groceryList after deleting an index is "+groceryList.get(i));
        }

        System.out.println("Does the grocery list contains apples "+groceryList.contains("apples"));
        System.out.println("The index of apples in grocery list is "+groceryList.indexOf("apples"));

        System.out.println("Does the grocery list contains pearls "+groceryList.contains("pearls"));
        System.out.println("The index of pearls in grocery list is "+groceryList.indexOf("pearls"));
    }


}
