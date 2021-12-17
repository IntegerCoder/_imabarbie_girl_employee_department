package company;

import company.department.Department;

import java.util.HashMap;

public class Company {
  private HashMap<String, Department> departments = new HashMap<String, Department>();
  private String name;

  public Company(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addDepartment(Department d) {
    departments.put(d.getId(), d);
  }

  public Department getDepartment(String id) {
    return departments.get(id);
  }

  public HashMap<String, Department> getDepartments() {
    return departments;
  }

  public String toString() {
    String msg = "[" + getName() + "]";
    msg += "\n== Departments ==";
    for (Department d : departments.values()) {
      msg += "\n    - " + d;
    }
    return msg;
  }
}