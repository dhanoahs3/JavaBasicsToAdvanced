package com.mycollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*By using methods provided by java.util.collections we can create a shallow copy of another ArrayList
* The method we used is create a new List that contains all the elements that were passed to it in the
* constructor. List<Theatre1.Seat> seatCopy = new ArrayList<>(mytheatre1.seats);
* Please note that it just a shallow copy meaning the contents in the seatCopy ArrayList are exactly the same
* Seat objects that were there mytheatre1.seats Arraylist. Both lists point to the exact same objects.
* so if we reserve any one of the objects by accessing it using seatCopy it will not be reserved again using
* mytheatre1.seats where mytheatre is an object of Threatre1 Class and seats in an ArrayList in that class
* Other methods that are provided by collections framework that can be applied to ArrayList are
* These methods are Collections.reverse(ArrayList)
* Collections.shuffle(ArrayList)
* Collections.sort(ArrayList)
* Please note all these methods sort the actual list so after we apply the above methods and print our seat Copy
* it prints different(reversed,shuffled or sorted list) as compared to the mytheatre1.seats list.
* The actual elements (Seat objects in our case are the same) in both the lists but yes again seats are different
* One method to create a copy of list is the one we used here
* List<Theatre1.Seat> seatCopy = new ArrayList<>(mytheatre1.seats);
*Another method is Collections.copy  ,which takes two arguments a destination and a source.Destination  is
* a generic type  which can be a  Collection, Iterable or List and source is an
*  actual list itself like ArrayList.
* The problem with this approach is
* if destination collection does not has same amount of size as source list then the copy will fail.
* So if we try something like this that is create a List named newCopy that points to a ArrayList which has
* size equal to my.theatre.seats and then if we try to copy the mytheatre.seats list into it we will get
* Exception in thread "main" java.lang.IndexOutOfBoundsException: Source does not fit in dest
* so even if we defined the newCopy as same size as mytheatre.size it is still complaining about the size
* what that means is unless we actually instantiate the new list and  fill it with 96 objects and then try
* to copy the old list into this new list the copy wont work.
* so this is stupid method and is rarely used.
*
* Takeways -to copy a list  pass it to constructor
* of Arraylist       List<Theatre1.Seat> seatCopy = new ArrayList<>(mytheatre1.seats);
*
* Then we are reverse ,shuffle or sort a list
*         Collections.reverse(seatCopy);
*         Collections.shuffle(seatCopy);
        Collections.sort(seatCopy);
        * Then to find min and max items in a List
        *  Collections.min(seatCopy);
       Collections.max(seatCopy);
        * Imp thing to note is if we add a new seat in the end like "B10" again and then print the list it
        * will be the last item in the list . But if we run sort it will put it right after our first B10
        * or even if we just type Collections.max it will just sort the list and return H12 and note B10 which we added
        * in the end.
        *
        * */
public class Runner1 {

    public static void main(String[] args) {
        Theatre1 mytheatre1 = new Theatre1("olympian",8,12);
        List<Theatre1.Seat> seatCopy = new ArrayList<>(mytheatre1.seats);
        Theatre1.Seat maxseat1  = Collections.max(mytheatre1.seats);

       System.out.println("---------------------------->"+maxseat1.getSeatNumber());

        printList(seatCopy);

        List<Theatre1.Seat> newCopy = new ArrayList<>(mytheatre1.seats.size());
     //   Collections.copy(newCopy ,mytheatre1.seats);


        seatCopy.get(1).reserve();
        if(mytheatre1.reserveSeat("A02")){
            System.out.println("Please pay for the seat A02");
        }
        else{System.out.println("Seat A02 is already reserved");
        }
      //  Or we can try like this as well
        if(mytheatre1.seats.get(1).reserve()){
            System.out.println("Seat reservation successful");
        }
        else{System.out.println("Seat already reserved");}


        Collections.reverse(seatCopy);
        System.out.println("Printing the reversed seatCopy");
        printList(seatCopy);
        System.out.println("Printing the mytheatre1.seats");
        printList(mytheatre1.seats);



        Collections.shuffle(seatCopy);
        System.out.println("Printing the shuffled seatCopy");
        printList(seatCopy);
        Collections.reverse(seatCopy);
        System.out.println("Printing the reverse shuffled seatCopy");
        printList(seatCopy);
        System.out.println("Printing mytheatre1.seats");
        printList(mytheatre1.seats);

        Theatre1.Seat minseat  = Collections.min(seatCopy);
        Theatre1.Seat maxseat  = Collections.max(seatCopy);
        System.out.println("Min seat is :"+minseat.getSeatNumber());
        System.out.println("Max seat is :"+maxseat.getSeatNumber());

        Collections.sort(seatCopy);
        System.out.println("Printing the sorted seatCopy");
        printList(seatCopy);



    }
    public static void printList(List<Theatre1.Seat> list){
        for(Theatre1.Seat seat : list){
            System.out.print(" "+seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===========================================================================================");
    }

}