package com.mycollections;

import java.util.*;
/*There are two ways to compare objects of a list .First one is to use compareTo method and for that
* we have to implement Comparable interface. Another way is to use Comparator interface. For that
* we don't have to implement that interface. We can just use its single method "compare" to compare items
*    static final Comparator<Seat> PRICE_ORDER  = new Comparator<Seat>() { }
* Above we are not making an object of Comparator but instead we are creating an anonymous inner class
* that define the single method compare of Comparator.
* Please note one major difference between compareTo and compare method
* compareTo method is consistent as it will ony return 0 if seat.getNumber for two seats is equal
* which means the the two seat objects are actually equal.
*          public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
        * But compare method for Comparator
        * comparing two seats with same price will return 0 although two seats have same
        * price but they  are not equal.So we have to do further testing here based on seatNumber etc.
        * The issue is we are passing two objects seat1 and seat2 to compare method and then just checking the
        * price and deciding based on price if two seat objects are equal . So two seats can have same price but
        * that doesn't mean seat nos are equal . So we have to check seatNumber as well or
        * else we use compareTo method because here only one object is passed and comparision is done based
        * on this.seatNumber.compareToIgnoreCase(seat.getSeatNumber())
        */

public class Theatre2 {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

    static final Comparator<Seat> PRICE_ORDER  = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice()<seat2.getPrice()){ {return -1;}
            }
            else if(seat1.getPrice()>seat2.getPrice()){
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    //  private List<Seat> seats = new LinkedList<Seat>();

    //  private Collection<Seat> seats = new LinkedList<Seat>();

    //     private Collection<Seat> seats = new HashSet<Seat>();

    //      private Collection<Seat> seats = new LinkedHashSet();

    public Theatre2(String theatreName, int numRows , int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow =  'A' + (numRows-1);
        for(char row = 'A';row<=lastRow;row++){
            for(int seatNum =1; seatNum <=seatsPerRow;seatNum++){
                double price = 12.00;
                if((row<'D')&&(seatNum>=4 &&seatNum<=9)){
                    price =14.00;
                }
                if((row>'F')&&(seatNum>=4 &&seatNum<=9)){
                    price =7.00;
                }
                Seat seat  = new Seat(row+String.format("%02d",seatNum),price);
                seats.add(seat);
            }
        }

        Theatre2.Seat seat = new Theatre2.Seat("B10",7.00);
        seats.add(seat);
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){

        Seat requestedSeat = new Seat(seatNumber,500.00);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
    }

    public Collection<Seat> getSeats(){
        return seats;
    }

    public class Seat implements Comparable<Seat> {

        private final String seatNumber;
        private double price;
        private  boolean reserved = false;

        public Seat(String seatNumber,double price) {
            this.seatNumber = seatNumber;
            this.price = price;
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
        public double getPrice() {
            return price;
        }


        @Override
        public int compareTo(Seat seat) {
            //To sort based on two fields. first on the basis of price and then double we use this
            int c=Double.compare(this.price,seat.getPrice());
            if(c!=0){
                return c;}
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

    }

}

