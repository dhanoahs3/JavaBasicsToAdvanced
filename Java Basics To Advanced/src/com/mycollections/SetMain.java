package com.mycollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*addAll is used to add one set to another
        union.addAll(cubes);

        Down below .split converts a String to an Array of Strings
        and then Array.asList(arrayWords) coverts the array of Strings to a ArrayList and then
        we can add that entire list to a Set by using addAll

        retainAll is used to find common elements between two sets
           intersection.retainAll(cubes);
           So above we have intersection as one set and cubes as another and above command will create
           a new Set which will contain only the elements that were common between two sets
           and then the new Set can be referenced using variable intersection only and we can perform
           all set operations on it like intersection.size etc etc

        String sentence = "A day in the life of programmer";
        //Note below arrayWords is an Array of words created using the split method on string
        //And then we can use Arrays.asList(arrayWords) to convert Array of words to ArrayList
        and then we can add Arraylist to a Set using addAll method.
        So since we can't add elements to a Set all at once(i.e using a String literal) so we can
        do so by converting a String of Arrays to Arrays.asList
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        RemoveAll gives the asymmetric difference i.e creates a new Set that contains all
        elements in Set A but removes all elements from Set A that were also present in Set B
        And it is a destructive operation i.e it changes Set A so better to copy Set A to new Set
        as we have done in diff2 below
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Symmetric Set-There is no way in Java to get a Set of elements that were not common in two Sets.
        i.e if Set A contains A,b,c and Set B contains b,d,e then create a Set that only contains
        A,d,e i.e leave the common element b
        But instead there is a workaround. Create a union of two Sets using addAll.And then create a Set that
        only contains common elements and then remove common elements from the union.
          Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        printSet(unionTest);

        System.out.println("===========Intersection================");
        Set<String> intersectionTest  = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        printSet(intersectionTest);

        System.out.println("===========symmetric diff================");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        And then to check if one set is subset of another we use containsAll , but this method is
        non destructive i.e it just returns true or false but does not create a new Set
         if(nature.containsAll(intersectionTest)){
            System.out.println("intersectionTest is subset of nature");
        }
        We don't have a method of adding Set literals at the moment ,so what we can do for Strings
        is add literals to an array and then convert to arraylist and add to Set in own go.
         String[] natureWords = {"all","nature","is","but","art","unknown","to","thee"};
        nature.addAll(Arrays.asList(natureWords));


 */

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares  = new HashSet<Integer>();
        Set<Integer> cubes = new HashSet<Integer>();

        for(int i =0;i<100;i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }
        System.out.println("Squares size: "+squares.size());
        System.out.println("Cubes size: "+cubes.size());
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union size: "+union.size());
        Set<Integer> intersection  = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("intersection size : "+intersection.size());
        for(int i: intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "A day in the life of programmer";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for(String s : Arrays.asList(arrayWords)){
            System.out.println(s);
        }

        System.out.println("===================================================================");

        for(String s : words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all","nature","is","but","art","unknown","to","thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to","err","is","human","to","forgive","is","divine"};
        divine.addAll(Arrays.asList(divineWords));
        System.out.println("nature-divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine-nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        printSet(unionTest);

        System.out.println("===========Intersection================");
        Set<String> intersectionTest  = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        printSet(intersectionTest);

        System.out.println("===========symmetric diff================");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if(nature.containsAll(divine)){
            System.out.println("divine is subset of nature");
        }
        else
            System.out.println("divine is not subset of nature");

        if(nature.containsAll(intersectionTest)){
            System.out.println("intersectionTest is subset of nature");
        }

        if(divine.containsAll(intersectionTest)){
            System.out.println("intersectionTest is subset of divine");
        }


        System.out.println("==============retainAll example in simple terms==================");
        Set<Integer> evens  = new HashSet<Integer>();
        Set<Integer> evensAndodds = new HashSet<Integer>();
        evens.add(2);
        evens.add(20);
        evens.add(200);
        evens.add(2000);
        evens.add(20000);
        evensAndodds.add(2);
        evensAndodds.add(20);
        evensAndodds.add(25);
        evensAndodds.add(26);

        Set<Integer> newIntersection  = new HashSet<>(evens);
        newIntersection.retainAll(evensAndodds);
        System.out.println("intersection size : "+newIntersection.size());
        for(int i: newIntersection) {
            System.out.println("The intersecting no is "+i);
        }




    }

    public static void printSet(Set<String> set){
        for(String s :set){
            System.out.print(s+" ");
        }
        System.out.println();
    }


    }



