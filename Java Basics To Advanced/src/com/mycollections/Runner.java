package com.mycollections;

public class Runner {
    public static void main(String[] args) {
     Theatre mytheatre = new Theatre("olympian",8,12);
      mytheatre.getSeats();
     System.out.println("==========================================================================");
     /*if(mytheatre.reserveSeat("B15")){
         System.out.println("Please Pay");
     }
     else{
         System.out.println("The seat is already reserved");
     }*/
     mytheatre.reserveSeat("H11");
     mytheatre.reserveSeat("H11");
     mytheatre.reserveSeat("B15");


/*

        if(mytheatre.reserveSeat("H02")){
            System.out.println("Please Pay");
        }
        else{
            System.out.println("The seat is already reserved");
        }
*/

    }
}