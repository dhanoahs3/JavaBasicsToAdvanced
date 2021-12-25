package com.polymorphism;

import java.util.Random;

class Movies{
    private String name;

    public Movies(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String plot(){
        return "no plot here";
    }
}
class Jaws extends Movies{
    public Jaws() {
        super("jaws");
    }

    public String plot(){
        return "Shark eats people";
    }
}

class IndependenceDay extends Movies{
    public IndependenceDay() {
        super("independence day");
    }

    public String plot(){
        return "Aliens try to take over planet earth";
    }
}

class ForgettableMovie extends Movies{
    public ForgettableMovie() {
        super("forgettable");
    }
    //we will not overide the plot method from parent class here as forgettable movie does not have its own plot
}

public class Runner {
    public static void main(String[] args) {
        for(int i =0; i<10; i++){
            Movies movie = randomMovie();
            System.out.println("Movie "+ i + ": "+movie.getName() + " plot is "+movie.plot());}
    }

    public static Movies randomMovie(){
        Random r = new Random();
        int randomNumber = r.nextInt(3)+1;
        System.out.println("The random number generated is :"+randomNumber);
        switch (randomNumber){
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new ForgettableMovie();
        }
        return null;
    }

}
