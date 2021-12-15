/*
* A drive program for Company domain
*/
import java.util.HashMap;
import java.util.StringJoiner;

import company.*;

import company.department.*;


public class TestProgram {
  public static void main(String[] args) {
    Company c = new Company("KOOT");
    // Create departments
    // Department hrDept = new Department("D001", "Human Resource");
    // Department salesDept = new Department("D002", "Sales");
    // Department seDept = new Department("D003", "Software Engineering");

    Sales salesDept = new Sales();
    HR hrDept = new HR();
    SE seDept = new SE();

    c.addDepartment(hrDept);
    c.addDepartment(salesDept);
    c.addDepartment(seDept);
    
    // Employee e1 = new Employee("19001","Jack",20000,1985,hrDept); // abstract
    Permanent e1 = new Permanent("19001","Jack",20000,1985,hrDept);
    Permanent e2 = new Permanent("20001","Jane",21000,1987,hrDept);
    Temporary e3 = new Temporary("18002","John",30000,1989,salesDept,"1/1/2000","31/12/2000");
    Temporary e4 = new Temporary("17001","Mike",35000,1980,salesDept,"1/1/2010","31/21/2010");
    
    
    System.out.println(c);
    Project p1 = new Project("P001","Build Food Delivery App", 1000000,seDept);
    Project p2 = new Project("P002","Prepare a Web Server", 200000,seDept);

    p1.addEmployee(e1);
    p1.addEmployee(e2);
    p2.addEmployee(e3);
    p2.addEmployee(e4);

    System.out.println("=== Projects of SE Department ===");
    HashMap<String,Project> seProjects = seDept.getProjects();
    for(Project p : seProjects.values()) {
      System.out.println(p);

      StringJoiner joiner = new StringJoiner(", ");
      for(Employee e : p.getEmployees().values()) {
        joiner.add(e.getName());
      }
      System.out.println("\tEmployees: "+joiner);
      System.out.println("\tMonthly Cost: "+p.getMonthlyCost());
    }
  }
}