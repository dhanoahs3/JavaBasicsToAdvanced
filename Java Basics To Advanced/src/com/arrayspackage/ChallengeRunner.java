package com.arrayspackage;

import java.util.Scanner;

public class ChallengeRunner {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("123 444 555");
    public static void main(String[] args){
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
         System.out.println("\nEnter actions:(6 to show list of available records)");
         int action = scanner.nextInt();
         scanner.nextLine();
         switch (action){
             case 0 :
                 System.out.println("\nShutting down");
                 quit = true;
                 break;
             case 1:
             mobilePhone.printContacts();
             break;
             case 2:
                 addnewContact();
                 break;
             case 3:
                 updateContact();
                 break;
             case 4:
                 removeContact();
                 break;
             case 5:
                 queryContact();
                 break;
             case 6:
                 printActions();
                 break;
         }
        }
    }

    public static void startPhone(){
        System.out.println("Starting the cell phone");
    }

    private static void addnewContact(){
        System.out.println("Add your contact name");
        String name = scanner.nextLine();
        System.out.println("Add your phone number");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added  name  ====>"+name +" and phone no ====> "+phoneNumber);
        }
        else {System.out.println("Cannot add as "+name + " already exists");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number");
        String newPhone = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhone);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Contact updated successfully");
        } else {
            System.out.println("Error updating contact");
        }
    }
        private static void removeContact() {
            System.out.println("Enter existing contact name");
            String name = scanner.nextLine();
            Contact existingContact = mobilePhone.queryContact(name);
            if (existingContact == null) {
                System.out.println("Contact not found");
                return;
            }
            if(mobilePhone.removeContact(existingContact)){
            System.out.println("Contact removed successfully");
            }
            else
            {
                System.out.println("Error removing contact");
            }

    }

    private static void queryContact() {
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("The name is "+existingContact.getName()+" and the phone number is "+existingContact.getPhoneNumber());
       mobilePhone.queryContact(name);
    }


    private static void printActions(){
        System.out.println("\n Available actions: \n press");
        System.out.println("0 - to shutdown\n"+
                          "1 - to print contacts\n"+
                          "2 - to add contacts\n"+
                          "3 - to update existing contact\n"+
                          "4 - to delete existing contact\n"+
                          "5  - query if a contact exists\n"+
                          "6 - to print list of available options");
        System.out.println("Choose your actions");

    }
}
