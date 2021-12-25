package com.collectionschallenge;
import java.util.Map;


/*The below creates  a new Map of that holds StockIem and Integer as key value pairs
by iterating through each item of basket.Items() map
This map is called item
Them we pass the key and value pair of this map to sellStock method.
Basically the method is used to iterate over each and every value of another map


 for (Map.Entry<StockItem,Integer> item:basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }*/

public class MainChallenge {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("bread", 0.86, 99);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 62, 10);
        stockList.addStock(temp);
        temp = new StockItem("cup", .50, 200);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);
        temp = new StockItem("towel", 2.50, 80);
        stockList.addStock(temp);
        temp = new StockItem("vase", 8.75, 40);
        stockList.addStock(temp);
       //    temp = new StockItem("pen", 1.12, 10);
      //  stockList.Items().put(temp.getName(),temp);
        // for(String s:stockList.Items().keySet()){
         //   System.out.println("just returning the key sets "+s);
       // }
        System.out.println(stockList);

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);
        sellItem(timsBasket,"car",1);

        if(sellItem(timsBasket,"car",1)!=1){
            System.out.println("There are no more cars left to sell");
        }
        sellItem(timsBasket,"spanner",2);
        System.out.println(timsBasket);


        sellItem(timsBasket,"juice",12);
        sellItem(timsBasket,"cup",25);
        sellItem(timsBasket,"bread",1);

        System.out.println(timsBasket);

        System.out.println("=====================New Customer Basket=========================================");

        Basket basket = new Basket("customer");
        sellItem(basket,"cup",100);
        sellItem(basket,"juice",5);
        sellItem(basket,"bread",1);
        System.out.println(basket);
        System.out.println(timsBasket);
        removeItem(basket,"cup",1);
        System.out.println(basket);
        System.out.println(timsBasket);

        System.out.println("===================??????????????????????????????????======================");

        removeItem(timsBasket,"car",1);
        removeItem(timsBasket,"cup",1);
        removeItem(timsBasket,"car",1);
        System.out.println("Cars removed "+removeItem(timsBasket,"car",1));
        System.out.println(timsBasket);

        removeItem(timsBasket,"bread",1);
        removeItem(timsBasket,"cup",18);
        removeItem(timsBasket,"juice",12);
        removeItem(timsBasket,"cup",6);
        System.out.println("=========================================================");
        System.out.println(timsBasket);
        System.out.println(basket);

        System.out.println("\n Display basket items before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkout(basket);
        System.out.println("After checkout from customer basket ");

        System.out.println(basket);
        System.out.println(stockList);


    /*    StockItem car  = stockList.Items().get("car");
        if(car!=null)
            car.adjustQuantity(3000);
        if(car!=null)
            stockList.Items().get("car").adjustQuantity(-1000);
        System.out.println(stockList);*/

        checkout(timsBasket);
        System.out.println(timsBasket);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the items from stock list
        StockItem stockitem  = stockList.get(item);
        if(stockitem==null){
            System.out.println("We don't sell the item: "+item);
            return 0;
        }
        int res = stockList.reserveStock(item, quantity);
        if(res!=0){
            return basket.addToBasket(stockitem,quantity);
        }
        return 0;
    }


    public static int removeItem(Basket basket, String item, int quantity){
        //retrieve the items from stock list
        StockItem stockitem  = stockList.get(item);
        if(stockitem==null){
            System.out.println("We don't sell the item: "+item+" so we can't remove it");
            return 0;
        }
        int basketsize = basket.removeFromBasket(stockitem, quantity);
        if(basketsize == quantity){
            return stockList.unReserveStock(item,quantity);
        }
        if(basketsize<=quantity){
            /*Total items passed to remove were more than the ones in the basket then" +
                    "remove euqal to the no of items in the basket");*/
            return stockList.unReserveStock(item,basketsize);
        }
        return 0;
    }

    public static void checkout(Basket basket){
        for (Map.Entry<StockItem,Integer> item:basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }

}
