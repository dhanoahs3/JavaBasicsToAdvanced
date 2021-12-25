package com.mycollections;

import java.net.StandardSocketOptions;
import java.util.*;
/*Collections -all of them are there in java.util class
* ArrayList and LinkedList extend List Interface.
* And List extends Collection
* Other than ArrayList and LinkedList we can use HashSet and LinkedHashSet
* if we change the type of our variable from List to Collection.
* Basically List , Set ,Queue and DeQueue extends Collection
* Another thing to note is for ArrayList ,LinkedList and LinkedHashSet items appear in order in which
* they were added .In HashSet they were not in order.
* Also note in Sets we can't add duplicate items but since new Seat("B12") and new Seat("B12")
* are two different objects so both can be added. more about this comparison in Sets later.
*/
/*Other things to note
*   int lastRow =  'A' + (numRows-1);
        for(char row = 'A';row<=lastRow;row++){
* The above code loops from A to H(if numRows = 8 for example)
*         for(Seat seat: seats){
The above for loop will iterate through all elements of an List .In our case List contains elements of type Seat
*so that's why .Basically look at the way we can loop through elements of the list.
*
* Please also note that if the Class Seats extend comparable and then if we override the compareTo method
* we can then use the below code to to find an element in a list
*          int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
* After we add compareTo then Collections.min,max and sort use the overriden comparision method.
* And we can compare multiple fields as well like we have done in Theatre2.java
*
To sort based on two fields. first on the basis of price and then double we use this
 */
            /*int c=Double.compare(this.price,seat.getPrice());
            if(c!=0){
                return c;}
                return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());

*
* Above seats is the name of the list , requestedSeat in the object we are looking in the list
* Please note that binarySearch is very fast operation . 20 comparisons can help in Search millions of items
* and 64 comparisons can compare a huge no.
* Also note binary search method is only applicable to Lists and not Sets.

* */

public class Theatre {
    private final String theatreName;

     private List<Seat> seats = new ArrayList<Seat>();

     //    private List<Seat> seats = new LinkedList<Seat>();

 //  private Collection<Seat> seats = new LinkedList<Seat>();

    //private Collection<Seat> seats = new HashSet<Seat>();

  //    private Collection<Seat> seats = new LinkedHashSet();

  //  private Collection<Seat> seats = new TreeSet<>();


    public Theatre(String theatreName, int numRows , int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow =  'A' + (numRows-1);
        for(char row = 'A';row<=lastRow;row++){
         for(int seatNum =1; seatNum <=seatsPerRow;seatNum++){
        //     System.out.println(row+seatNum+"======================="+row+String.format("%02d",seatNum));
             Seat seat  = new Seat(row+String.format("%02d",seatNum));
             seats.add(seat);
         }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        /*First way to look for  a seat is by the method used below. Another
        * and much faster way is to extend the comparable interface for seat class
        * and override the compareTo method . if we use the second method we then use the uncommented
        * code below to reserve  a seat
        * Please note that Collections.binarySearch method is much faster and more preferred.
        * In this method we just pass the entire list ,in our case the Arraylist named seats ,the
        * actual element in our list we want to search for which in our case is a seat object we created
        * using the seat number and null and the binarySearch will return to us the position of the
        * element if it is found . So if element is found then position will be >=0 or otherwise
        * it will be negative.So in case of our list objects A01 will have position 0 and H12 will have
        * position 95.*/

        Seat requestedSeat  = null;
        for(Seat seat: seats){
            System.out.print(".");
            if(seat.getSeatNumber().equals(seatNumber)){
                requestedSeat  = seat;
                break;
            }
        }
        if(requestedSeat==null){
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
        return requestedSeat.reserve();
       /*  Seat requestedSeat = new Seat(seatNumber);
         int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
         System.out.println("The position of element in the list is "+foundSeat);
         if(foundSeat>=0){
             return seats.get(foundSeat).reserve();
         }
         else{
             System.out.println("There is no seat "+seatNumber);
             return false;
         }*/
    }

    public void getSeats(){
        for(Seat seat:seats){
            System.out.println("The seatNumber is "+seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {

      private final String seatNumber;
        private  boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }
        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat "+seatNumber + " reserved");
                System.out.println("Please pay for requested seat now");
                return true;
            }
            else {
                System.out.println("The seat is already reserved");
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat with "+seatNumber + " cancelled");
                return true;
            }
            else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }

}
