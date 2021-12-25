package com.collectionschallenge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;



public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {

        this.list = new LinkedHashMap<>();

    }

    public int addStock(StockItem item){
        if(item!=null){

            StockItem inStock = list.getOrDefault(item.getName(),item);
           // System.out.println(inStock);

           if(inStock!=item){
              /* System.out.println("Item is already there in list so thats why the item.getName object " +
                       "that is returned is not the same object as object passed in arguments i.e item" +
                       "And since item is already in stock so lets just adjust its items ");*/
               item.adjustQuantity(inStock.availableQuantity());
           }
           list.put(item.getName(),item);
          return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item ,int quantity){
        StockItem inStock = list.get(item);
        if((inStock!=null)&&(quantity>0)){
            return inStock.finaliseStock(quantity);
        }

        /*StockItem inStock = list.getOrDefault(item,null);
        if(inStock!=null &&(inStock.availableQuantity()>=quantity)&&(quantity>0)){
            inStock.adjustQuantity(-quantity);
            return quantity;
        }*/
        return 0;
    }

    public int reserveStock(String item,int quantity){
        StockItem inStock = list.get(item);
        if((inStock!=null)&&(quantity>0)){
         return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unReserveStock(String item,int quantity){
        StockItem inStock = list.get(item);
        if((inStock!=null)&&(quantity>0)){
            return inStock.unReserveStock(quantity);
        }
        return 0;
    }



    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String,Double> priceList() {

        //Define an empty map prices.LinkedHashMap means items appear in the order in which they were added
        Map<String,Double> prices  = new LinkedHashMap<>();
        //iterate over list map and for each item in list map get the key i.e item name as String
        //and from the value i.e StockItem object get the price and add both these as key values to
        //to prices map.
        for(Map.Entry<String, StockItem>item:list.entrySet()){
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        //Return the unmodifiable map i.e the one that can't be modified.
        return Collections.unmodifiableMap(prices);
    }

          //Below method returns the unmodifiable list which is read only
    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
     String s = "\nSTOCK LIST\n";
     double totalCost = 0.0;
     for(Map.Entry<String, StockItem> item:list.entrySet()){
         StockItem stockItem = item.getValue();
         double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
         s = s+stockItem+ " There are "+stockItem.availableQuantity()+ " in stock.Values of items: ";
         s = s+String.format("%.2f,",itemValue)+ "\n";
         totalCost +=itemValue;
        }
        return s+" Total stock value "+totalCost;
    }
}
