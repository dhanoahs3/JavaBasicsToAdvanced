package com.mycollections;

/*Since we implemented Comparable interface with type <StockItem> we can override compareTo method in
* StockItem class. Please also note that we don't have to implement any interfaces to override equals and
* hash code method.
* When we compare two objects we need to override Hashcode which is called first and then we override
* equals
* To sort objects (use binary search ,min ,max etc) based on something like let us say based on name
* we override compareTo and hence we need to use Comparable.
* */

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if(price>0.0)
        this.price = price;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock +quantity;
        if(newQuantity>=0)
        this.quantityStock = newQuantity;
    }

 /*   @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItems.equals");
        if (obj==this) return true;
        if(obj==null || obj.getClass()!=this.getClass()){
            return  false;
        }
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode()
    { return this.name.hashCode()+31; }*/

    @Override
    public int compareTo(StockItem o) {
     //   System.out.println("Entering StockItems.compareTo");

        if(this==o)
        return 0;
        if(o!=null)
            return this.name.compareTo(o.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " price: "+ this.price;
    }
}
