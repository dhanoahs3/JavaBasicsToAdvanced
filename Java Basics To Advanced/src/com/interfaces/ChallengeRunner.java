package com.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*We can pass class like this to a function that requires a interface if class implemnets that interface
*     public static void saveObject(ISaveable objectToSave){  //here this function requires an interface reference
*     Player tim  = new Player("Tim",10,15);  //but tim referes to class reference but since class  player extends interface
*     iSaveable we can pass it to above function like this
*         saveObject(tim);
*
* we can even use interface reference to make a object of child class
*     ISaveable werewolf = new Monster("werewolf",20,30);
* But then to access methods thats are only defined in child class we have to type cast that reference to child class
* like this  ((Monster) werewolf).getStrength());
* please note we can still access all the methods that are there in interface that the class extends directly
*  werewolf.write();

 */

public class ChallengeRunner {
    public static void main(String[] args) {
    Player tim  = new Player("Tim",10,15);
    System.out.println(tim.toString());
    saveObject(tim);
    tim.setHitPoints(0);
    System.out.println("Printing tim after setting hit points to 0");
    System.out.println(tim);
    saveObject(tim);
    System.out.println("Printing tim after setting weapon to Strombringer");
    tim.setWeapon("Stormbringer");
    System.out.println(tim);
    saveObject(tim);
    loadObject(tim);
    saveObject(tim);
     System.out.println("==========================================================================");
    ISaveable werewolf = new Monster("werewolf",20,30);
    System.out.println("Monster Strength is "+ ((Monster) werewolf).getStrength());
    System.out.println(werewolf);
    saveObject(werewolf);
  }

    public static void saveObject(ISaveable objectToSave){
        List<String>  savedList= objectToSave.write();
         for(int i = 0;i<savedList.size();i++){
            System.out.println("Saved "+ savedList.get(i)+" to the storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose \n" +
                "1 to enter a string \n"+
                "0 to quit");
        while(!quit){
            System.out.println("Choose option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter the String: ");
                    String stringOut  = scanner.nextLine();
                    values.add(index,stringOut);
                    index++;
                    break;
            }
        }
        return values;
    }
}
