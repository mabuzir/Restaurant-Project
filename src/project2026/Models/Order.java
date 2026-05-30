package project2026.Models;

import java.util.ArrayList;

public class Order {
    
    private int orderId;   
    private Status orderStatus;
    private ArrayList<OrderItem> orderItems = new ArrayList<>();    
    
    public Order(int orderId, Status orderStatus) {
        this.orderId = orderId;       
        this.orderStatus = orderStatus;
    }
   
    public int getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }       

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public Status getStatus() {
        return this.orderStatus;
    }
    
    public void addItem(OrderItem item){
        this.orderItems.add(item);
    }
    
    public void removeItem(OrderItem item){
        this.orderItems.remove(item);
    }
    
    public double calculateTotal(){
        double total = 0;
        for (OrderItem item : orderItems){
            total += item.getItem().getItemPrice() * item.getQuantity();
        }
        return total;
    }        
    
    public void displayOrderItems(){
        for (OrderItem item : orderItems){
            System.out.println("Item: " + item.getItem().getItemName()+ " Quantity: " + item.getQuantity());
        }
    }
    
}
