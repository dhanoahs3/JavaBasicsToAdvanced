package com.interfaces;

public class InterfaceRunner {
    public static void main(String[] args) {

        ITelephone myphone;
        myphone = new DeskPhone(123456);
        myphone.powerOn();
        myphone.dial(123456);
        myphone.callNumber(123456);
        myphone.isRinging();
        myphone.answer();
        myphone.isRinging();
       System.out.println("----------------------Testing the mobile phone now----------------------------------------");
       myphone = new MobilePhone(45678910);
        myphone.powerOn();
        myphone.dial(45678910);
        myphone.callNumber(45678910);
        myphone.isRinging();
        myphone.answer();
        myphone.isRinging();

    }

}
