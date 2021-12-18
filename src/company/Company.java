package company;

import company.department.Department;

import java.util.LinkedHashMap;
import java.util.Map;

public class Company {
  private Map<String, Department> departments = new LinkedHashMap<String, Department>();
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

  public Map<String, Department> getDepartments() {
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