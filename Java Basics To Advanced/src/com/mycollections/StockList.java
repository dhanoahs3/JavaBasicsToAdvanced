package com.mycollections;

import java.util.*;

/*
    The below command returns a unmodifiable list,map or set which can't be modified so items
    can either be added or removed
    return Collections.unmodifiableMap(list);
 */

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
       // this.list = new HashMap<>(); //if we use hashmap items will not be added to the map in an order
        //for  ordering of items to the map lets use LinkedHashMop
        //If we use LinkedHashMap items are printed in the exact same order they were added.
        //Like item 1 will print first ,then item 2 etc.
    //  this.list = new LinkedHashMap();

       //If we instead use a TreeMap
        this.list = new TreeMap();
        //then items will be added to Map in alphabetic order of the keys that is first "door"  then "car"
        //etc and "vase" in the end.

    }

    public int addStock(StockItem item){
        if(item!=null){
            //check if already have quantities of this item in the list
            //if item is there in Map return that  object other wise return the object passed as parameter
            //i.e return item
            StockItem inStock = list.getOrDefault(item.getName(),item);




            // if item and inStock are separate i.e item was already there in the Map
            //that is set the quantity of item passed equal to the quantity of object already present
            //in the list

            //The traditional way of doing this would be
            //But then we have to compare inStock != null instead of item as we did below.
            //if item is already there in list then getOrDefault will return the object and not the object
            //item that means inStock is not equal to item
           if(inStock!=item){

               //then adjust stock for item object passed as argument
               //make stock = stock of inStock that i.e object already in map i.e what we got from
               //getOrDefault
               item.adjustStock(inStock.quantityInStock());
           }

           //Another way of doing the above two commands is
          /*  Stock inStock = list.get(item.getName());
           if(inStock!=null)
               item.adjustQuantity(inStock.getQuantity());*/
          list.put(item.getName(),item);
          return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item ,int quantity){
        StockItem inStock = list.getOrDefault(item,null);
        if((inStock!=null) &&(inStock.quantityInStock()>=quantity)&&(quantity>0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String,Double> priceList()
    {
        /*This method makes a map named prices of String and Double
        * Then it iterates over the list map that contains item name as key and
        * actual item object as value
        * then in the prices map inputs key i.e item name as key and item.getPrice
        * that is price of individual item as value.
        * and name and price of items are defined when we make objects of Stockitem
        * like
        *         StockItem temp = new StockItem("bread", 0.86, 100);
         */
        Map<String,Double> prices  = new LinkedHashMap<>();
        for(Map.Entry<String,StockItem>item:list.entrySet()){
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }


    public Map<String,StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        /*\n is used to go to new line*/
     String s = "\nSTOCK LIST\n";
     double totalCost = 0.0;
     /*using for loop to iterate over each item in the list
     * item will be each entry in the map . so item will have  a key and a value*/
     for(Map.Entry<String,StockItem> item:list.entrySet()){
         /*stockItem is the value of item ,i.e the actual object of clss StockItem*/
         StockItem stockItem = item.getValue();
         double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
         s = s+stockItem+ " There are "+stockItem.quantityInStock()+ " in stock.Values of items: ";
         //String.format("%.2f",itemValue) means two decimal points after the .
         s = s+String.format("%.2f,",itemValue)+ "\n";
         totalCost +=itemValue;
        }
        return s+" Total stock value "+totalCost;
    }
}
