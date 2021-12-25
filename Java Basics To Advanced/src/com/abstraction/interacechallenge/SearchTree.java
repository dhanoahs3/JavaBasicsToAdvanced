package com.abstraction.interacechallenge;

/*SearchTree is different than LinkedList
* Traversing a Linked list means  go from one node to another until we get a null reference.
* Search Tree is means we keep going left from parent to child . and once there is not child we go to
* the parent of child and then go to next parent and so on
* So basically it means keep going left -left left till the last child and then go right from one parent to
* another and reach the top and then go right to one child after another till we find the last child
* and then again go left to find its parent etc  */

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
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
                    currentItem = currentItem.next(); //move current item to next position
                } else {
                    //there is no next so set at end of tree
                    currentItem.setNext(newItem);
                    return true;
                }
            }
            else if(comparison > 0){
                //new item is less so set before
                if(currentItem.previous()!=null){
                    currentItem = currentItem.previous();
                }
                //the node with a previous is the root
                else{
                     currentItem.setPrevious(newItem);
                     return  true;
                }
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

        /*check if item to be removed  has no children then link to it can be set to null.

        * if item to be removed has one child pointing to left or right then removal is setting that
        parent to point to child back again
        *
        * Big scenario is if node has children to both the left  and right side
        * every node to the left and right is greater than its parent */
        if(item!=null){
            System.out.println("Deleting the item "+item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        /*Item to be deleted is moved to right subtree and then we keep traversing left till we reach the
        * node with no left child and then we set the node to be deleted equal to this smallest node
        * and then we remove this node*/
        while (currentItem!=null){
            int comparision = (currentItem.comapareTo(item));
            if(comparision<0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            }
               else if(comparision > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
               }
               else{
                   //The above method was only used to move to left or right and the actual code to
                //remove the node is in performRemoval method.
                   performRemoval(currentItem,parentItem);
                   return true;
               }
             }
        return false;
    }

    private void performRemoval(ListItem item,ListItem parent){
      if(item.next() ==null){
          // no right tree so make the parent point to the left tree(which may be null)
          if(parent.next()==item){
              //item is right child of its parent
              parent.setNext(item.previous());
          }
          else if(parent.previous()==item){
              //item is left child of its parent
              parent.setPrevious(item.previous());
          }
          else{
              //parent must be item which means we are looking at the root of the tree.
              this.root = item.previous();
          }
      }
      else if(item.previous()==null) {
          // no left tree so make parent point to the right tree (which may be null)
          if (parent.next() == item) {
              //item is right child of its parent
              parent.setNext(item.next());
          } else if (parent.previous() == item) {
              //item is left child of its parent
              parent.setPrevious(item.next());
          } else {
              //else delete the root itself
              this.root = item.next();
          }
      }
          else {
              //neither left nor the right were null .deletion is trickier now
          //From the left sub-tree ,find the smallest value(i.e the left most)
          ListItem current = item.next();
          ListItem leftmostParent = item;
          while(current.previous()!=null){
              leftmostParent = current;
              current = current.previous();
          }
          //Now put the smallest value into our node to be deleted
          item.setValue(current.getValue());
          //and delete the smallest
          if(leftmostParent==item){
              //there was no 'leftmost' node so current points to the smallest
              //node(the onse that now must be deleted)
              item.setNext(current.next());
          }
          //set the smallest node's parent to point to
          //the smallest node's right child(which may be null)
          else{
              leftmostParent.setPrevious(current.next());
          }
      }

    }


    @Override

    /*so the traverse method for Search tree will be a recursive function */
    public void traverse(ListItem root) {

     if(root!=null){
         /*So look like it will keep calling traverse method with the previous value
          * till we reach the end
         * that is till we reach the end of left  and then keep going right i.e keep calling
         * traverse with root.next till we reach the end of right .*/
         traverse(root.previous());
         System.out.println(root.getValue());
         traverse(root.next());
     }
    }
}
