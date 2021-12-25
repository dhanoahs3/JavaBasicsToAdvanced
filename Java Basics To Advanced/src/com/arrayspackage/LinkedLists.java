package com.arrayspackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*Linked lists store items at indexes and are defined like this-->  LinkedList<String> stringLinkedList = new LinkedList();
we can then add items to the list like this and they will be added to the list at positions 0,1,2,3 etc
  stringLinkedList.add("String at position 0");
        stringLinkedList.add("String at position 1");
        stringLinkedList.add("String at position 2");

we can add item at particular index as follows later on and other items will move one index below the list
        stringLinkedList.add(3,"abcbcbcbcbcbcb");

we can remove item at a particular index as well and all items will move one index up.
        stringLinkedList.remove(5);

 Iterator it  =  l.iterator();
            while(it.hasNext()){
                System.out.println("The current string is "+it.next());
            }

            String List iterator is defined by the following format where stringListIterator is the name we can provide
            and l is name be came to our String LinkedList
            ListIterator<String> stringListIterator = l.listIterator();

   addInOrder method is to organise a list in ascending order
 */
public class LinkedLists {

    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList();
        stringLinkedList.add("String at position 0");
        stringLinkedList.add("String at position 1");
        stringLinkedList.add("String at position 2");
        stringLinkedList.add("String at position 3");
        stringLinkedList.add("String at position 4");
        stringLinkedList.add("String at position 5");
        stringLinkedList.add("String at position 6");
        stringLinkedList.add("String at position 7");
        stringLinkedList.add("String at position 8");
        stringLinkedList.add("String at position 9");
        stringLinkedList.add("String at position 10");

       printLinkedList(stringLinkedList);

        stringLinkedList.add(3,"abcbcbcbcbcbcb");
        System.out.println("After adding gibberish at index postion 3 ----------------->");
        printLinkedList(stringLinkedList);
        stringLinkedList.remove(5);
        System.out.println("After removing value at index position 5 ----------------->");
        printLinkedList(stringLinkedList);



        /*----------------------------Linked list iterator------------------------------>*/
        System.out.println("----------------------------------------------------------------------------------");
        LinkedList<String> placesToVisit = new LinkedList();
        addInOrder(placesToVisit,"Toronto");
        addInOrder(placesToVisit,"Montreal");
        addInOrder(placesToVisit,"Quebec city");
        addInOrder(placesToVisit,"Niagra");
       /* addInOrder(placesToVisit,"Vancouver");
        printLinkedList(placesToVisit);
        addInOrder(placesToVisit,"Kelowna");
        printLinkedList(placesToVisit);
        addInOrder(placesToVisit,"Niagra");*/
        printLinkedList(placesToVisit);
        visit(placesToVisit);


    }
    public static void  printLinkedList(LinkedList<String> l) {
        Iterator it = l.iterator();
        while (it.hasNext()) {
            System.out.println("The current string is " + it.next());
        }
    }

    public static boolean  addInOrder(LinkedList<String> l,String cityName){


        ListIterator<String> stringListIterator = l.listIterator();

            while(stringListIterator.hasNext()){
                String cityToIterate = stringListIterator.next();
                int comparision = cityToIterate.compareTo(cityName);
                if(comparision==0)
                {
                    System.out.println(cityName + " is already in the list");
                    return false;
                }
                else if (comparision>0){

                    System.out.println("Greater than 0 while comparing "+cityToIterate + " and "+cityName);
                  //  System.out.println("comparing "+cityToIterate+" and " +cityName +" and comparision is "+comparision);
                    stringListIterator.previous();
                    stringListIterator.add(cityName);
                    return  true;
                }

                else if (comparision<0) {
                    System.out.println("Less than 0 while comparing "+cityToIterate + " and "+cityName);

                   // System.out.println("comparing" +cityToIterate +"  and " +cityName+" and comparsion is " +comparision);

                }
            }
        System.out.println("Finally here after all the loops ");

        stringListIterator.add(cityName);
            return true;
        }

     public static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String>listIterator = cities.listIterator();
        if(cities.isEmpty()){
            System.out.println("No cities in the itenary");
        }
        else{
            System.out.println("Now visiting "+listIterator.next());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Vacation over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting "+listIterator.next());
                    }
                    else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;

                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting "+listIterator.previous());
                    }
                    else {
                        System.out.println("Reached the end of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
     }

     public static void printMenu(){
        System.out.println("Available actions \n press");
         System.out.println("0 to quit \n"+
                 "1 to go to next city \n"+
                 "2 to go to previous city \n"+
                 "3 to print menu options");


     }
    }


