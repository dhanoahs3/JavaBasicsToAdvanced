package com.collectionschallenge;

//The below command is used to clear a Map. that is instead of iterating over the Map and removing each
//key value pair one by one using remove . we simply clear the entire map in one gap

   //     this.list.clear();

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer> list;

    public Basket(String name) {
        this.name = name;
        list = new TreeMap<>();
    }

    public int addToBasket(StockItem item ,int quantity){
        if((item!=null)&&(quantity>0)){
            int inBasket = list.getOrDefault(item,0);
         //  System.out.println("The of of "+ item.getName() +" in basket "+ inBasket);
          //  System.out.println("The new quantity to put in "+quantity);
            list.put(item,inBasket+quantity);
           // System.out.println("The no of "+item.getName()+" now are "+list.get(item));
          //  System.out.println("The size of list is"+list.size());
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item ,int quantity){
        if((item!=null)&&(quantity>0)){
            int inBasket = list.getOrDefault(item,0);
          //  int newQuantity =  inBasket-quantity;
              int newQuantity =  inBasket - quantity;

            if(newQuantity>0){
                list.put(item,newQuantity);
                return quantity;
            }
           else if(newQuantity==0){
               /*If newQuantity =0 remove all items from the basket*/
                list.remove(item);
                return quantity;
            }

           else if(newQuantity<0){
               /*If newQuantity <0 i.e more items were passed thant the user has reserved then lets
               * remove all the items and empty the basket.*/
                list.remove(item);
                return inBasket;
           }
        }
        return 0;
    }

       public void clearBasket(){
        this.list.clear();
       }

        public Map<StockItem,Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket "+name + " contains "+list.size() + ((list.size()==1) ? " item":" items")+ "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem,Integer>item:list.entrySet()){
            s = s+item.getKey()+". "+item.getValue()+" purchased\n";
            totalCost += item.getKey().getPrice()*item.getValue();
        }
        return s+" total Cost "+totalCost;
    }
}
