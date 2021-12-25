package com;

import com.example.game.ISaveable;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;
/*Importing and using packages. What we did is we created a new project and in that project we created a new package
* com.example.game and in that package we copied three files ISaveable,Monster and Player from another project
* then our project only contains these three files.
* then what we did was we went to
* File - Project Structure -Artifacts --> + -->from modules with dependencies then press ok and then again ok
* So basically we have created a jar file of our project which we can find here
* C:\web-tests\packageexampleproject\out\artifacts\packageexampleproject_jar
* Then we can create a new project and again go to File - Project Structure
* But this time we go to libraries - java and then go to the above location and choose above jar file
* And then we can just use the files int he jar like we are doing in this class. we just have to import them
* in this class from our external jars and those jars are present in External Libraries in this project */
public class ChallengeRunner {
    public static void main(String[] args) {
    Player tim  = new Player("Tim",10,15);
    System.out.println(tim.toString());
    saveObject(tim);
    tim.setHitPoints(0);
    System.out.println("Printing tim after setting hit points to 0");
    System.out.println(tim);
    tim.setWeapon("Stormbringer");
    saveObject(tim);
    loadObject(tim);
    System.out.println(tim);

    ISaveable werewolf = new Monster("werewolf",20,30);
    System.out.println("Monster Strength is "+ ((Monster) werewolf).getStrength());
    System.out.println(werewolf);
    saveObject(werewolf);
  }

    public static void saveObject(ISaveable objectToSave){
        for(int i = 0;i<objectToSave.write().size();i++){
            System.out.println("Saving "+objectToSave.write().get(i)+" to the storage device");
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
