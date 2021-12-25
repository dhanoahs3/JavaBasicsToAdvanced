package com.abstraction.interacechallenge;

import com.generictypes.SoccerPlayer;

public class MyLinkList implements NodeList {
    private ListItem root = null;

    public MyLinkList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            //the list was empty so this item that is passed as an argument becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;  //set a new variable currentItem equal to the root for comparision
        while (currentItem != null) {
            int comparison = (currentItem.comapareTo(newItem)); //compare root item to new item passed into the list
            if (comparison < 0) {
                //newitem is greater so move to right
                if (currentItem.next() != null) {
                    //If there is an item next to the currentItem which initially is a root
                    //then simply set the currentItem reference to that next item i.e next to the root
                    //in the first case and then it will be next to other second item etc.
                    currentItem = currentItem.next(); //move current item to next position
                } else {
                    //there is no next so set at end of list
                    //if there is no next item then simply put the newItem we were comparing as nextItem to the
                    //root
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    //And more thing we know that setNext method sets the newItem and returns the newItem
                    //so we can basically shortcut the above two lines of code to
                 //   currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }
            else if(comparison > 0){
                //new item is less so set before
                if(currentItem.previous()!=null){
                    //If currentItem which is root in first case and can be some other item in other cases
                    //get its previous item , that is one item to left of previous and setNext to newItem
                    //basically go to previous and setNext ,so basically set new item to one position
                    // right of previous item , that is set in between current Item and its
                    // previous item as per my understanding.
                currentItem.previous().setNext(newItem);
                //then set the previous of currentItem as  to the left of newItem ,so basically same step as above
                newItem.setPrevious(currentItem.previous());

                /*As we know setNext returns the right item itself so we can shorten the above two lines of code
                * to the below */
             //   currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());

                //move current Item to right on newItem
                newItem.setNext(currentItem);
                //same as above step ,move currentItem to right of new item
                currentItem.setPrevious(newItem);
                /*Same way we can shorten the above two lines of code */
                   // newItem.setNext(currentItem).setPrevious(newItem);
            }
            //the node with a previous is the root
            else{
                //current item is the first in the list with no previous item so we have to set new item as the root
                    //So set root as next to newItem.
                newItem.setNext(this.root);
                //set newItem as previous to root.
                this.root.setPrevious(newItem);

                /*And we can shorten the above line of code as well*/
                  //  newItem.setNext(this.root).setPrevious(newItem);

                //and after we set the locations as we did in last two steps simply set the newItem as root.
                this.root = newItem;
            }
            return true;
            }
            else{
                System.out.println(newItem.getValue()+ " is already present ,so it is not added");
                return false;
            }
        }
            return false;
        }

    @Override
    public boolean removeItem(ListItem item) {
        if(item!=null){
            System.out.println("Deleting the item "+item.getValue());
        }
        /*Start from the top so set currentItem equal to root*/
        ListItem currentItem = this.root;
        while (currentItem!=null){
            int comparision = currentItem.comapareTo(item);
            if(comparision==0){
                //If comparision == 0 that is we find the item to delete

                //then first of all check if currentItem is the root itself i.e the one we set above
                if(currentItem==this.root){
                    //if yes then set the next item to the be the root.
                    this.root = currentItem.next();
                }
                else{
                    //otherwise get the previous item for currentItem and set the previous items Next equal to
                    //current Items nexts  i.e is current item is out of the way.
                    //For example previous for B is A .so get A and then set next of A equal to next of B
                    //that is C ,so B is out of way now
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next()!=null){
                        //if the next we set above is not null that is there is item C in the list
                        //then set its previous to current items previous which is A now
                        //so basically repeat the above step
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if (comparision<0){
                currentItem = currentItem.next();
            }
            else{
                return false;
            }
        }
        //We have reached the end of list without finding the item to delete.
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
