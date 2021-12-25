package com.mycollections;

public class Dog {
    private final String name;
    public Dog(String name){
        this.name  = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public final boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj instanceof Dog){
            System.out.println("In if of  dog");
            String objName = ((Dog)obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }
}
