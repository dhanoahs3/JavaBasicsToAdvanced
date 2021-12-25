package com.encapsulation;

public class Printer {
/*Encapsualtion- This technique is used to make class members non-accesible outside the class.like here we defined some
* members which are private and the only way to assign values to them is by making an object of the class printer.
* i.e we can only instantiate them using the constructors as these members are private members
* So only way of accessing these private members is by using getters and setters. We can never access them using
* objects of Printer class like ---------------> p1.tonerLevel as these members are private.
* So basically encapsulation is all about setting members private and only accessing them using proper getter
* methods in other classes.
*
* Benefits of encapsulation
* 1. Class variables can be made private and can be only accessed using setters and getters.
* 2.We can apply validations i.e set value of pagesPrinted = 2 only if pagesPrinted >0 etc
* 3.Since variables go through validations and can be only set if they pass certain validations so
* invalid values can't be assigned like pagesPrinted = -2 etc
 */
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplexPrinter;

    public Printer(int tonerLevel, boolean duplexPrinter) {
        if(tonerLevel >=1 && tonerLevel<=100){
            this.tonerLevel = tonerLevel;
        }
        else
        this.tonerLevel = -1;
        this.duplexPrinter = duplexPrinter;
    }

    public int addToner(int tonerAmount){
        if(tonerAmount>0 && tonerAmount <100) {
            if(this.tonerLevel +tonerAmount >100)
            return -1;
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        }
        else{
            return -1;
        }
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }


    public void setTonerLevel(int tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public int printPages(int pages){
        int pagesToPrint = pages;
        if(this.duplexPrinter){
            pagesToPrint = pages/2 +pages%2;
            System.out.println("Printing in duplex mode");
        }
        this.pagesPrinted +=pagesToPrint;
        return pagesToPrint;
    }






}
