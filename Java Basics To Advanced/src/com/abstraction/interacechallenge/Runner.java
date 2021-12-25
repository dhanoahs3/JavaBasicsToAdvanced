package com.abstraction.interacechallenge;

public class Runner {

    public static void main(String[] args) {
     MyLinkList list  = new MyLinkList(null);

     list.traverse(list.getRoot());
   //  String stringData  = "Montreal Toronto Ottawa Vancouver Calgary Edmonton Winnipeg Ottawa";

     String stringData = "5 7 6 9 8 1 4 2 3 5";

     String[] data  =stringData.split(" ");
     for(String s : data){
         list.addItem(new Nodes(s));
     }
        list.traverse(list.getRoot());
        System.out.println("=====================================================");

      /*  list.addItem(new Nodes("5"));
        list.removeItem(new Nodes("3"));
        System.out.println("=====================================================");*/

     list.removeItem(new Nodes("1"));
     list.removeItem(new Nodes("2"));
     list.removeItem(new Nodes("3"));
     list.removeItem(new Nodes("4"));
     list.removeItem(new Nodes("4"));
     list.traverse(list.getRoot());

     list.removeItem(new Nodes("5"));
     list.removeItem(new Nodes("6"));
     list.removeItem(new Nodes("7"));
     list.removeItem(new Nodes("8"));

     /*Delete the root itself . in or case it will be 9 as that is the only item left in the list*/
        list.removeItem(list.getRoot());
        list.traverse(list.getRoot());

        System.out.println("About to do the same with Search Tree");
        System.out.println("=====================================================================");
        SearchTree searchTree  = new SearchTree(null);
        searchTree.traverse(searchTree.getRoot());
        String treeData1 = "1 2 3 4 5 6 7 8 9";
      //  String treeData1  = "Montreal Toronto Ottawa Vancouver Calgary Edmonton Winnipeg Ottawa";

        String[] data1  =treeData1.split(" ");
        for(String s : data1){
            searchTree.addItem(new Nodes(s));
        }
        searchTree.traverse(searchTree.getRoot());
        System.out.println("=====================================================");
        searchTree.addItem(new Nodes("5"));

       System.out.println("================== removing some items =================================");


        searchTree.removeItem(new Nodes("1"));
        searchTree.removeItem(new Nodes("2"));
        searchTree.removeItem(new Nodes("3"));
        searchTree.removeItem(new Nodes("4"));
        searchTree.removeItem(new Nodes("5"));
        searchTree.removeItem(new Nodes("6"));
        searchTree.removeItem(new Nodes("7"));


        searchTree.traverse(searchTree.getRoot());


        System.out.println("================Trying removing the root now =========================== ");

        searchTree.removeItem(searchTree.getRoot());

        searchTree.traverse(searchTree.getRoot());

        searchTree.removeItem(searchTree.getRoot());

        searchTree.traverse(searchTree.getRoot());



    }
}