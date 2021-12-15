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
    this(id,name,salary,0,department);
  } 

  // Mutators (change/write)
  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  // Accessors (read)
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
    // return this.salary; // sane result as return salary
  }

  public int getYearOfBirth() {
    return yearOfBirth;
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
