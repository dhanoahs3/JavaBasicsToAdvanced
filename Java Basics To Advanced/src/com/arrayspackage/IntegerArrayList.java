package com.arrayspackage;

import java.util.ArrayList;

public class IntegerArrayList {
/*Arraylist can't handle primitive data types like integers,floats ,doubles etc. It can only handle classes like String. And for primitive data types
* Instead we use wrapper classes for primitive data types likes Integer Double etc.
* Then we add retrieve values like this ---->            integerList.add(Integer.valueOf(i*20));                System.out.println(integerList.get(i).intValue());
* Or simply like this              integerList.add(i * 10);,              System.out.println(integerList.get(i));
* */

    public static void main(String[] args) {

        ArrayList<Integer> integerList = new ArrayList<Integer>();
        ArrayList<Double> doubleList = new ArrayList<Double>();

        for (int i = 1; i <=10; i++) {
            integerList.add(i * 10);
        }


        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }

        for (double d = 0.0; d <=10.0; d= d+0.5) {
            doubleList.add(d);
        }


        for (int d = 0; d < doubleList.size(); d++) {
            System.out.println(doubleList.get(d));
        }

    }
}
