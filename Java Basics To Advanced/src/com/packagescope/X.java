package com.packagescope;

import java.util.Scanner;

public class X {
    private int x;

/*First approach */
  /*  public X(int x) {
        this.x = x;
    }*/
/*Second approach*/
    public X(Scanner x){
        System.out.println("Please enter a number");
        this.x = x.nextInt();
    }


    public void x(){
        for(int x=1;x<13;x++){
            System.out.println(x+" times "+this.x + " equals " + x*this.x);
        }
    }
}
