package company.department;

import java.util.HashMap;

import company.Employee;
import company.Project;

public class Department { 
  private String id;
  private String name;
  
  private HashMap<String, Employee> employees = new HashMap<String, Employee>();
  private HashMap<String, Project> projects = new HashMap<String, Project>();

  public Department(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() { return id; }
  public String getName() { return name; }

	public void addEmployee(Employee e) {
    employees.put(e.getId(), e);
  }

  public Employee getEmployee(String id) {
    return employees.get(id);
  }

  public String toString() {
    String msg = "::"+getName()+"::";
    msg += "\n\t== Employees ==";
    for (Employee e : employees.values()) {
      msg += "\n\t\t  - "+e.getId()+": "+e.getName();
    }
    return msg;
  }

  public void addProject(Project project) {
    projects.put(project.getId(), project);
  }

  public HashMap<String, Project> getProjects() {
    return projects;
  }
} 
  