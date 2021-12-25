package com.interfaces;

public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("phone is Powered up");

    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn)
        System.out.println("Dialing the phone no on mobile phone "+phoneNumber);
        else
            System.out.println("Mobile phone is switched off");
    }

    @Override
    public boolean callNumber(int phoneNumber) {
        if(phoneNumber == myNumber && isOn){
            isRinging = true;
            System.out.println("Mobile phone  ring ");
        }
        else{
            System.out.println("Seems like mobile phone is turned off or number is different  ");
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
          System.out.println("The mobile is ringing");
      else
          System.out.println("The mobile phone is not ringing");
    }

}

