package project2026.Models;

import java.util.ArrayList;

public class Restaurant {
    
    private Menu menu;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public Restaurant(Menu menu) {
        this.menu = menu;
    }
    
    public void addEmployee(Employee employee){
        this.employees.add(employee);
        System.out.println("Employee " + employee.getEmployeeName() + " added successfully.");
    }
    
    public void removeEmployee(Employee employee){
        this.employees.remove(employee);
        System.out.println("Employee " + employee.getEmployeeName() + " removed successfully.");
    }
    
    
}
