package com.mycollections;

import com.sun.source.tree.Tree;

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer> list;
    private final Set<StockItem> itemSet  = new HashSet<>();


    public Basket(String name) {
        this.name = name;
        /*TreeMap adds items in alphabetical order. Only thing to note is there is a performance issue
        * when using tree map as its takes lots of time
        * So if alphabetical order is not necessary use Hashmap instead
        *Also note when we use TreeMap  and when we use command         sellItem(timsBasket,"juice",1);
            it has to add items to the map based on alphabetic order of Keys. But since Keys in an object of
            * Class StockItem ,so  when addToBasket  is called in sellItem then
         * compareTo method of StockItem is called and since  we have over riden that method so it
        * decides which order those items will appear based on that over riden method.
         */
        list = new TreeMap<>();

    }

    public int addToBasket(StockItem item ,int quantity){
        if((list!=null)&&(quantity>0)){
            int inBasket = list.getOrDefault(item,0);

          //  System.out.println("The items in basket are"+inBasket);
            itemSet.add(item);
            list.put(item,inBasket+quantity);
            return inBasket;
        }
        return 0;
    }
    public Map<StockItem,Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        //We have replaced the below line with the line down below
        //list.size() + :" items"
        //But this below line does is check if list size =1 .if it is print item else print items.
        //list.size() + ((list.size()==1) ? " item":" items")
        String s = "\nShopping basket "+name + " contains "+list.size() + ((list.size()==1) ? " item":" items")+ "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem,Integer>item:list.entrySet()){
            s = s+item.getKey()+". "+item.getValue()+" purchased\n";
            totalCost += item.getKey().getPrice()*item.getValue();
        }
        return s+" total Cost "+totalCost;
    }
}
