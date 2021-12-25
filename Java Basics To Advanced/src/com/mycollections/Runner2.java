package com.mycollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner2 {

    /*Things to note
    *         Collections.sort(seatCopy);  //this method used compareTo from seat class to sort lists.
    * And since in compareTo we have implemented the mechanism to compare based on both price and seatNumber
    * so if we add B10 with price 7.00 at the end of the list in Theatre2 and over here if we sort B10 with price 7.00
    * will appear first in the list
    *
    * But
    *        Collections.sort(pricedSeats,Theatre2.PRICE_ORDER); //this method will use compare method
    * of comparator.
    * but since in the compare method we are only comparing based on price only  so objects will be sorted
    * only on based on price and if two objects have same price  ,they will appear in the list in the order
    * in which they were added ,and that means B10 with price 7.00 will appear after all the elements of the same
    * price


     * */

    public static void main(String[] args) {

        Theatre2 mytheatre2 = new Theatre2("olympian", 8, 12);
        List<Theatre2.Seat> myList = new ArrayList<>(mytheatre2.getSeats());
        printList(myList);
        if(mytheatre2.reserveSeat("B12")){
            System.out.println("Please pay for the seat B12");
        }
        else{System.out.println("Seat B12 is already reserved");
        }

        if(mytheatre2.reserveSeat("B12")){
            System.out.println("Please pay for the seat B12");
        }
        else{System.out.println("Seat B12 is already reserved");
        }

        System.out.println("==================================================================");
        List<Theatre2.Seat> reversedSeats = new ArrayList<>(mytheatre2.getSeats());
        Collections.reverse(reversedSeats);
     //     printList(reversedSeats);


        List<Theatre2.Seat> seatCopy= new ArrayList<>(mytheatre2.getSeats());
        Collections.sort(seatCopy);
        System.out.println("================Sorting based on compareTo method=================");
        printList(seatCopy);

        List<Theatre2.Seat> pricedSeats = new ArrayList<>(mytheatre2.getSeats());
        pricedSeats.add(mytheatre2.new Seat("C00",13.00));
        pricedSeats.add(mytheatre2.new Seat("B00",13.00));
       Collections.sort(pricedSeats,Theatre2.PRICE_ORDER);
       System.out.println("================priced seats====================================");
       printList(pricedSeats);






      /*  if(mytheatre2.reserveSeat("B13")){
            System.out.println("Please pay for the seat B13");
        }
        else{System.out.println("Seat B13 is already reserved");
        }
        List<Theatre2.Seat> reverseSeats  =  new ArrayList<>(mytheatre2.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre2.Seat> pricedSeats  =  new ArrayList<>(mytheatre2.getSeats());
        pricedSeats.add(mytheatre2.new Seat("B00",13.00));
        pricedSeats.add(mytheatre2.new Seat("A00",14.00));
        Collections.sort(pricedSeats,Theatre2.PRICE_ORDER);
        printList(pricedSeats);*/

    }

    public static void printList(List<Theatre2.Seat> list){
        for(Theatre2.Seat seat : list){
            System.out.println(" "+seat.getSeatNumber()  +" "+seat.getPrice());
        }
        System.out.println();
        System.out.println("===========================================================================================");
    }
}