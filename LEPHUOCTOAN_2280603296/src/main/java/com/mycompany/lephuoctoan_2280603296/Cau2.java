package com.mycompany.lephuoctoan_2280603296;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Cau2 {
    
    public static class Employee {
        String id;
        String name;
        double salary;
        
        public Employee(String id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }
    
    public static String saveEmployeesToCSV(List<Employee> employees, String fileName) {
        StringBuilder log = new StringBuilder();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("ID,HoTen,Luong");
            for (Employee emp : employees) {
                writer.printf("%s,%s,%.2f%n", emp.id, emp.name, emp.salary);
            }
            
            log.append("Da xuat du lieu ra file " + fileName + ".\n");
            log.append("Tong so nhan vien: " + employees.size() + "\n");
            log.append("Ban co the mo bang Excel.\n");
            
        } catch (Exception e) {
            log.append("Loi ghi file: " + e.getMessage() + "\n");
        }
        
        return log.toString();
    }
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("001", "Nguyen Van A", 5000000));
        employees.add(new Employee("002", "Tran Thi B", 6000000));
        
        String result = saveEmployeesToCSV(employees, "employee.csv");
        System.out.println(result);
    }
}