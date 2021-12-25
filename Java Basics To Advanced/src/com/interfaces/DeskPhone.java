package com.interfaces;

public class DeskPhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action taken as desk phone has no power on button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Dialing the phone no on Deskphone "+phoneNumber);
    }

    @Override
    public boolean callNumber(int phoneNumber) {
        if(phoneNumber == myNumber){
            isRinging = true;
            System.out.println("ring ring ");
        }
        else{
            isRinging = false;
        }
       return isRinging;
    }

    @Override
    public void answer() {
    if(isRinging) {
         System.out.println("Answering the phone");
        isRinging = false;
    }
  }

    @Override
    public void isRinging() {
        if(isRinging)
      System.out.println("The phone is ringing");
        else
            System.out.println("The phone is not  ringing");


    }

}
