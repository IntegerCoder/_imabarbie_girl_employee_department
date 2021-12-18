package company.department;

import company.Employee;
import company.Project;

import java.util.LinkedHashMap;
import java.util.Map;

public class Department {
  private String id;
  private String name;

  private Map<String, Employee> employees = new LinkedHashMap<String, Employee>();
  private Map<String, Project> projects = new LinkedHashMap<String, Project>();

  public Department(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void addEmployee(Employee e) {
    employees.put(e.getId(), e);
  }

  public Employee getEmployee(String id) {
    return employees.get(id);
  }

  public Map<String, Employee> getEmployees() {
    return employees;
  }

  public String toString() {
    String msg = "::" + getName() + "::";
    msg += "\n\t== Employees ==";
    for (Employee e : employees.values()) {
      msg += "\n\t\t  - " + e.getId() + ": " + e.getName();
    }
    return msg;
  }

  public void addProject(Project project) {
    projects.put(project.getId(), project);
  }

  public Map<String, Project> getProjects() {
    return projects;
  }
} 
