package project2026.Models;

import java.util.ArrayList;

public class Menu {
    
    private ArrayList<MenuItem> menuList = new ArrayList<>();

    public void addItem(MenuItem item) {        
        this.menuList.add(item);
    }
    
    public void removeItem(MenuItem item) {
        this.menuList.remove(item);
    }
    
    public void displayMenu() {
        for (MenuItem item : menuList) {
            System.out.println(item.getItemName() + ": $" + item.getItemPrice());
        }
    }
    
    public MenuItem getItemById(int id) {        
        for (MenuItem item : menuList) {            
            if (item.getItemId() == id) {
                return item;
            }
        }
        return null; 
    }
}
