package project2026.Models;

import java.util.ArrayList;
import project2026.Models.Order;

public class Customer {
    
    private int customerId;
    private String customerName;
    private String phone;
    private ArrayList<Order> customerOrders = new ArrayList<>();
    
    public Customer(int customerId, String customerName, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
    }

    public int getCustomerId(){
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Order> getOrders() {
        return this.customerOrders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.customerOrders = orders;
    }
}

