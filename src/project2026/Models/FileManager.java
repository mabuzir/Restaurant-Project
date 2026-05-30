package project2026.Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import project2026.Models.Barista;
import project2026.Models.Chef;
import project2026.Models.Customer;
import project2026.Models.Employee;
import project2026.Models.ItemType;
import project2026.Models.Menu;
import project2026.Models.MenuItem;
import project2026.Models.Order;
import project2026.Models.OrderItem;
import project2026.Models.Restaurant;
import project2026.Models.Status;
import project2026.Models.Waiter;

public class FileManager {
    
    public static String check_Credentials(String username, String password){
        try{
            FileReader accounts_reader = new FileReader("src/project2026/Textfiles/accounts.txt");
            BufferedReader reader = new BufferedReader(accounts_reader);
            String line;
            
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                
                if (parts[0].equals(username) && parts[1].equals(password)){
                    Session.setRole(parts[2].trim());
                    Session.setName(parts[3].trim());
                    reader.close();
                    return parts[2];
                }                
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null;
    }
    
    public static ArrayList<Employee> load_Employees(){
        ArrayList<Employee> list = new ArrayList<>();
        try{            
            FileReader employees_reader = new FileReader("src/project2026/TextFiles/employees.txt");
            BufferedReader reader = new BufferedReader(employees_reader);            
            String line = reader.readLine();
            
            while(line != null){
                String[] parts = line.split(",");
                
                if (parts.length == 8){
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String age = parts[2].trim();
                    String phone = parts[3].trim();
                    String address = parts[4].trim();
                    String exp = parts[5].trim();
                    double salary = Double.parseDouble(parts[6].trim());
                    String role = parts[7].trim();
                    switch(role){
                        case "Chef" -> list.add(new Chef(id, name, age, phone, address, exp, salary));
                        case "Barista" -> list.add(new Barista(id, name, age, phone, address, exp, salary));
                        case "Waiter" -> list.add(new Waiter(id, name, age, phone, address,  exp, salary));
                    }
                    
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch(IOException e){            
            System.out.println("Error reading file: " + e.getMessage());            
        }
        return list;
    }
    
    public static void save_Employees(ArrayList<Employee> list){
        try{
            FileWriter employees_writer = new FileWriter("src/project2026/Textfiles/employees.txt", false);
            BufferedWriter writer = new BufferedWriter(employees_writer);
            for (Employee emp : list){
                String role = emp.getClass().getSimpleName();            
                writer.write(emp.getEmployeeId() + "," + emp.getEmployeeName() + "," + emp.getEmployeeAge() + "," +
                             emp.getEmployeePhone() + "," + emp.getEmployeeAdd() + "," + emp.getEmployeeExp() + "," +
                             emp.getEmployeeSalary() + "," + role);
                writer.newLine();
            }            
            writer.close();
        }
        catch(IOException e){
            System.out.println("Error Saving Employees: " + e.getMessage());
        }
    }
    
    
   
}
    

