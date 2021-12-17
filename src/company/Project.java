package company;

import company.department.Department;

import java.util.HashMap;

public class Project {
  // Mandatory attributes
  private String id;
  private String name;
  private double budget;
  private Department department;

  // Aggregate attributes
  private HashMap<String, Employee> employees = new HashMap<String, Employee>();

  // Constructor
  public Project(String id, String name, double budget, Department department) {
    // Guard condition
    if (budget < 0) {
      throw new IllegalArgumentException("Budget cannot be negative. " + budget);
    }

    this.id = id;
    this.name = name;
    this.budget = budget;
    this.department = department;
    this.department.addProject(this);
  }

  public String toString() {
    return id + "\t" + name + "\t" + budget + "\t" + department.getName();
  }

  public Department getDepartment() {
    return department;
  }

  // public void setDepartment(Department department) {
  //   this.department = department;
  // }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBudget() {
    return budget;
  }

  public void setBudget(double budget) {
    this.budget = budget;
  }

  public HashMap<String, Employee> getEmployees() {
    return employees;
  }

  public void addEmployee(Employee employee) {
    employees.put(employee.getId(), employee);
  }

  public void removeEmployee(Employee employee) {
    employees.remove(employee.getId());
  }

  public double getMonthlyCost() {
    double totalCost = 0;
    for (Employee employee : employees.values()) {
      totalCost += employee.getSalary();
    }
    return totalCost;
  }
}
