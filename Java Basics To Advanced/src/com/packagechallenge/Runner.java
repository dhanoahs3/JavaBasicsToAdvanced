package com.packagechallenge;

import com.packagechallenge.mylibrary.Series.Series;

public class Runner {
    public static void main(String[] args)  {
        for(int i =0;i<=10;i++){
            System.out.println(Series.nSum(i));
        }

        for(int i =0;i<=10;i++){
            System.out.println(Series.factorial(i));
        }

        for(int i =0 ; i<=10; i++){
            System.out.println(Series.fibonacci(i));
        }
    }
}
