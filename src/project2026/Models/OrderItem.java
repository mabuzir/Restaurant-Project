package project2026.Models;

public class OrderItem {
    
    private MenuItem item;
    private int itemQuantity;

    public OrderItem(MenuItem item, int itemQuantity) {
        this.item = item;
        this.itemQuantity = itemQuantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    public void setQuantity(int quantity) {
        this.itemQuantity = quantity;
    }
    
    
    
}
