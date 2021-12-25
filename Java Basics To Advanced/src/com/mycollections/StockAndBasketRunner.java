package com.mycollections;

import java.util.Map;

public class StockAndBasketRunner {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {


        StockItem temp = new StockItem("bread", 0.86, 100);

        stockList.addStock(temp);

        temp = new StockItem("bread", 0.86, 100);

        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

       /* temp = new StockItem("car", .86, 10);
        stockList.addStock(temp);*/


        temp = new StockItem("chair", 62, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", .50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", .45, 10);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.75, 40);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.50, 80);
        stockList.addStock(temp);

       /*temp = new StockItem("cloth", .10, 50);
       stockList.addStock(temp);*/

       /* Please note the below is not possible .that is we can't add items to the stock
        list as stocklist.Items returns a unmodifiable map*/
       /*  temp = new StockItem("pen", 5, 20);
        stockList.Items().put(temp.getName(),temp);*/
       /* for(String s:stockList.Items().keySet()){
            System.out.println(s);
        }
        So we can't change the list ,however we can change the actual items in the list itself
        like get the item car and change its stock
         Please also note that there are two ways we can access the items in a stock list
         the first method returns an unmodifiable map ,although we can change the stocks of actual items
         in the list
         second way is just returns an value based on key "car" and we can adjust stock for that key
                 from there if we want*/
       /*  stockList.Items().get("car").adjustStock(3000);
         stockList.get("car").adjustStock(-1000);*/

        System.out.println(stockList);


        System.out.println("===============printing the price list=======================");
        for(Map.Entry<String,Double>prices: stockList.priceList().entrySet()){
            System.out.println(prices.getKey() + " costs: "+prices.getValue());
        }

        System.out.println("--------------**********************************----------------------------------");


        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);

        sellItem(timsBasket,"car",1);
         System.out.println(timsBasket);

         if(sellItem(timsBasket,"car",1)!=1){
            System.out.println("There are no more cars to sell");
        }

        sellItem(timsBasket,"spanner",5);

        System.out.println(timsBasket);


        sellItem(timsBasket,"juice",1);

        sellItem(timsBasket,"cup",1);

        sellItem(timsBasket,"bread",1);

        sellItem(timsBasket,"chair",5);

        sellItem(timsBasket,"door",1);

        sellItem(timsBasket,"phone",1);

        System.out.println(timsBasket);

       System.out.println("==========After adding items to basket==================");
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket,String item,int quantity){
     //retrieve the items from stock list
        StockItem stockitem  = stockList.get(item);
        /*If stockItem == null i.e Stockitem was not added to StockList above*/
        if(stockitem==null){
            System.out.println("We don't sell the item: "+item);
        }
        /*If item is not null that is ,it is there in the stockList map
        * then we call sellStock and all sellStock does is check it quantity is greater than
        * 0 and item.quantityInStock >quantity and if yes it will simply adjust the quantity
        * for that particular item and return the adjusted quantity , otherwise
        * if above conditions not match i.e either quantity < 0 or
        * item.quantityInStock < quantity it will just return 0
        * if its not equal to 0 add the quantity and the actual StockItem object to addBasket*/
        if(stockList.sellStock(item, quantity)!=0){
            basket.addToBasket(stockitem,quantity);
            return quantity;
        }
        return 0;
    }



}