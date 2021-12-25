package com.abstraction.interacechallenge;

public  abstract class ListItem {
    protected  ListItem rightLink = null;
    protected  ListItem leftLink = null; //here we are creating references of abstract class ListItem in the same class itself
    protected Object value; //here we are defining an variable named value of type object

    public ListItem(Object value){ //create a constructor for class ListItem which takes an argument of type object and
        //sets value which is an object = object passed as argument
        this.value = value;
    }

    abstract ListItem next(); //defining methods that return a reference of type abstract class itself i.e
    //object of any Class that extends ListItme
    abstract ListItem setNext(ListItem item); //pass reference to set next item in the list ans returns
    //type abstract class ListItem
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);//pass reference to set previous item in the list
    abstract int comapareTo(ListItem item);


    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }



}
