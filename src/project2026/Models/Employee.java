package project2026.Models;

public abstract class Employee {
    
    private int employeeId;
    private String employeeName;
    private String employeeAge;   
    private String employeePhone;
    private String employeeAdd;
    private String employeExp;
    private double employeeSalary;

    public Employee(int id, String name, String age, String phone, String address, String exp , double salary) {
        this.employeeId = id;
        this.employeeName = name;
        this.employeeAge = age;
        this.employeePhone = phone;
        this.employeeAdd = address;
        this.employeExp = exp;
        this.employeeSalary = salary;
    }        

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAdd() {
        return employeeAdd;
    }

    public void setEmployeeAdd(String employeeAdd) {
        this.employeeAdd = employeeAdd;
    }

    public String getEmployeeExp() {
        return employeExp;
    }

    public void setEmployeExp(String employeExp) {
        this.employeExp = employeExp;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }   
            
    public abstract void work();
}
