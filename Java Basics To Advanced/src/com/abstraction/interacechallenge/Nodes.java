package com.abstraction.interacechallenge;

public class Nodes extends ListItem {
    /*In this class next and previous are just getters and setters that return reference to ListItem
    * and setNext and setPrevious are just setters that set rigtLink and leftLink equal to the object we pass
    * as arguments*/

    public Nodes(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return  this.leftLink;
    }

    @Override
    int comapareTo(ListItem item) {
    if(item!=null){
        /*Here we are using the compareTo method from String class to compare our ListItem objects
        * compareTo from String will return 0,-1 or +1 depending upon the comparision*/
        return ((String) super.getValue()).compareTo((String)item.getValue());
    }
    else{
        return -1;
    }
    }
}
