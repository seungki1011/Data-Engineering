package de.java.accessmodifier.practice1;

public class ShoppingCart {
    // 1. 데이터(속성)는 전부 private
    private Item[] items = new Item[4];
    private int itemCount = 0;

    // 2. 유저가 사용하는 메서드는 public으로 노출
    public void addItem(Item item) {
        if(itemCount >= items.length){
            System.out.println("Shopping cart is full!");
            return;
        }
        items[itemCount] = item;
        itemCount++;
        System.out.println("item("+itemCount+") added");
    }
    public void displayItems(){
        System.out.println("Current Items in Shopping cart");
        for (int i = 0; i<itemCount; i++) {
            System.out.println("Name: "+items[i].getName()+", Price: "+items[i].getPrice()+", Quantity: "+items[i].getQuantity());
        }
        System.out.println("Total Price: "+getCartTotalPrice());
    }
    // 3. getCartTotalPrice는 내부에서만 사용하기 땨문에 private
    private int getCartTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < itemCount; i++){
            totalPrice += items[i].getItemTotalPrice();
        }
        return totalPrice;
    }
}
