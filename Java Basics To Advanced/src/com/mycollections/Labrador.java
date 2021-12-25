package com.mycollections;

public class Labrador extends Dog {

    public Labrador(String name){
        super(name);
    }

  /*  @Override
    public  boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj instanceof Labrador){
            System.out.println("In if of labrador");

            String objName = ((Labrador)obj).getName();
            return this.getName().equals(objName);
        }
        return false;
    }*/
}
