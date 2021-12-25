package com.encapsulation;

public class Runner {
    public static void main(String[] args) {
        Printer p1 = new Printer(25,true);
       // p1.tonerLevel
        System.out.println("The current toner level is "+p1.getTonerLevel());
        p1.setTonerLevel(50);
        System.out.println("The current toner level is "+p1.getTonerLevel());
        System.out.println("Initial page print count is "+p1.getPagesPrinted());
        int pagesPrinted = p1.printPages(4);
        System.out.println("Pages printed was "+pagesPrinted +" new page print count is "+p1.getPagesPrinted());

        pagesPrinted = p1.printPages(23);
        System.out.println("Pages printed was "+pagesPrinted +" new page print count is "+p1.getPagesPrinted());

    }
    }
