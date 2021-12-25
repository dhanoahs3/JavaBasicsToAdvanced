package com.mycollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre1 {

    public final String theatreName;
    public List<Theatre1.Seat> seats = new ArrayList<Theatre1.Seat>();

    public Theatre1(String theatreName, int numRows , int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow =  'A' + (numRows-1);
        for(char row = 'A';row<=lastRow;row++){
            for(int seatNum =1; seatNum <=seatsPerRow;seatNum++){
                Theatre1.Seat seat  = new Theatre1.Seat(row+String.format("%02d",seatNum));
                seats.add(seat);
            }
        }
        Seat seat = new Seat("B10");
        seats.add(seat);
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        /*First way to look for  a seat is by the method used below. Another
         * and much faster way is to extend the comparable interface for seat class
         * and override the compareTo method . if we use the second method we then use the uncommented
         * code below to reserve  a seat*/

        /*
        Seat requestedSeat  = null;
        for(Seat seat: seats){
            if(seat.getSeatNumber().equals(seatNumber)){
                requestedSeat  = seat;
                break;
            }
        }
        if(requestedSeat==null){
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
        return requestedSeat.reserve();*/
        Theatre1.Seat requestedSeat = new Theatre1.Seat(seatNumber);
        /*The whole point is binary search. we can use Collections.binarySearch to find an
        * element in a list .We pass the list and the object to find as arguments and it will return
        * to us the index position of that element if it is there in the list ,otherwise will return -1
        * Most important thing to use binary search is we have to implement the comparable interface
        * on the object on which we want to use the binarySearch.like in our case we implemented the
        * compare to for Seat class. Another thing to note is , we override the compareTo method of
        * comparable interface. we overide it to decide if two seat objects are equal based on the seat no .
        * What that means is if we create a seat object like we did above this comment block
        * and pass it to binarySearch method below , if there is another seat object in the list with the same
        * seat object it will return the index of that object. Although the seat object we defined above and one
        * in the list are technically not equal but since we are comparing then based on seat no in compareTo
        * so they are considered equal.
        * */
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
    }

    public void getSeats(){
        for(Theatre1.Seat seat:seats){
            System.out.println("The seatNumber is "+seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Theatre1.Seat> {

        private final String seatNumber;
        private  boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }
        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat "+seatNumber + " reserved");
                return true;
            }
            else {
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
        public int compareTo(Theatre1.Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }

}
