package company;

import company.department.Department;

abstract public class Employee {
  private String id;
  private String name;
  private double salary;
  private int yearOfBirth;
  private Department department;

  // Credentials
  private String username;
  private String password = "companyXpa$$0rd"; // default password


  // Constructors
  public Employee(String id, String name, double salary, int year, Department department) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.yearOfBirth = year;
    this.department = department;
    this.department.addEmployee(this);
  }

  public Employee(String id, String name, double salary, Department department) {
    this(id, name, salary, 0, department);
  }

  // Accessors (read)
  public String getId() {
    return id;
  }

  // Mutators (change/write)
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
    // return this.salary; // sane result as return salary
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  public Department getDepartment() {
    return department;
  }

  public int getAge() {
    if (yearOfBirth == 0) {
      return 0;
    } else {
      return 2021 - yearOfBirth;
    }
  }

  // All staff must retire at age 60.
  public int getServiceYearsLeft() {
    return 60 - getAge();
  }
}
