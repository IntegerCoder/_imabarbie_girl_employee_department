import company.*;
import company.department.Department;
import company.department.HR;
import company.department.SE;
import company.department.Sales;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
  private static final int lineLength = 114;
  private static final String line1 = "-".repeat(lineLength);
  private static final String line2 = "=".repeat(lineLength);

  public static void main(String[] args) {
    Company company = new Company("KOOT");

    Sales salesDept = new Sales();
    HR hrDept = new HR();
    SE seDept = new SE();

    company.addDepartment(hrDept);
    company.addDepartment(salesDept);
    company.addDepartment(seDept);

    Permanent e1 = new Permanent("19001", "Jack", 20000, 1985, hrDept);
    Permanent e2 = new Permanent("20001", "Jane", 21000, 1987, hrDept);
    Temporary e3 = new Temporary("18002", "John", 30000, 1989, salesDept, "1/1/2000", "31/12/2000");
    Temporary e4 = new Temporary("17001", "Mike", 35000, 1980, salesDept, "1/1/2010", "31/21/2010");
    Permanent e5 = new Permanent("25001", "Bill", 25000, 1991, seDept);
    Permanent e6 = new Permanent("25002", "Bell", 23000, 1995, seDept);

    ArrayList<Employee> employees = new ArrayList<Employee>();
    employees.add(e1);
    employees.add(e2);
    employees.add(e3);
    employees.add(e4);
    employees.add(e5);
    employees.add(e6);

    Project p1 = new Project("P001", "Build Food Delivery App", 1000000, seDept);
    Project p2 = new Project("P002", "Prepare a Web Server", 200000, seDept);
    Project p3 = new Project("P003", "Communication Skills Training", 150000, salesDept);
    Project p4 = new Project("P004", "Sales Office Renovation", 500000, salesDept);

    ArrayList<Project> projects = new ArrayList<Project>();
    projects.add(p1);
    projects.add(p2);
    projects.add(p3);
    projects.add(p4);

    p1.addEmployee(e1);
    p1.addEmployee(e2);
    p2.addEmployee(e3);
    p2.addEmployee(e4);
    p3.addEmployee(e2);
    p3.addEmployee(e3);
    p3.addEmployee(e4);
    p4.addEmployee(e4);
    p4.addEmployee(e5);
    p4.addEmployee(e6);

    showEmployeesByTypesOfEmployment(employees);
    System.out.println();
    System.out.println();
    showDepartmentsAndEmployees(company);
    System.out.println();
    System.out.println();
    showDepartmentsAndProjects(company);
    System.out.println();
    System.out.println();
    showProjectsAndEmployees(projects);
  }

  private static void showEmployeesByTypesOfEmployment(ArrayList<Employee> employees) {
    String template = "          %-5s   %-10s%10s   %-20s%15s%8s";
    System.out.println(line2);
    System.out.println("1. Show the list of employees by type of employment.");
    System.out.println(line2);
    {
      System.out.println("   Permanent Employees");
      String permTemplate = template + "%15s\n";
      System.out.println(line1);
      System.out.printf(permTemplate,
        "ID", "Name", "Salary", "Department", "Year Of Birth", "Age", "Years Left");
      System.out.println(line1);
      for (Employee employee : employees) {
        if (employee instanceof Permanent) {
          System.out.printf(
            permTemplate,
            employee.getId(),
            employee.getName(),
            employee.getSalary(),
            employee.getDepartment().getName(),
            employee.getYearOfBirth(),
            employee.getAge(),
            employee.getServiceYearsLeft()
          );
        }
      }
    }
    System.out.println(line2);
    {
      System.out.println("   Temporary Employees");
      String tempTemplate = template + "%15s%15s\n";
      System.out.println(line1);
      System.out.printf(tempTemplate,
        "ID", "Name", "Salary", "Department", "Year Of Birth", "Age", "Start Date", "End Date");
      System.out.println(line1);
      for (Employee employee : employees) {
        if (employee instanceof Temporary) {
          Temporary temp = (Temporary) employee;
          System.out.printf(
            tempTemplate,
            temp.getId(),
            temp.getName(),
            temp.getSalary(),
            temp.getDepartment().getName(),
            temp.getYearOfBirth(),
            temp.getAge(),
            temp.getStartDate(),
            temp.getEndDate()
          );
        }
      }
    }
    System.out.println(line2);
  }

  private static void showDepartmentsAndEmployees(Company company) {
    System.out.println(line2);
    System.out.println("2. Show the list of employees in each department.");
    System.out.println(line2);
    for (Department d : company.getDepartments().values()) {
      System.out.printf("   Employees In %s Department\n", d.getName());
      System.out.println(line1);
      String template = "          %-5s   %-10s%10s%20s%15s\n";
      System.out.printf(template, "ID", "Name", "Salary", "Year Of Birth", "Age");
      System.out.println(line1);
      double totalSalary = 0;
      for (Employee e : d.getEmployees().values()) {
        totalSalary += e.getSalary();
        System.out.printf(
          template,
          e.getId(),
          e.getName(),
          e.getSalary(),
          e.getYearOfBirth(),
          e.getAge()
        );
      }
      System.out.println(line1);
      System.out.printf(template, "", "", "", "Total Salary", totalSalary);
      System.out.println(line2);
    }
  }

  private static void showDepartmentsAndProjects(Company c) {
    System.out.println(line2);
    System.out.println("3. Show the list of projects in each department.");
    System.out.println(line2);
    for (Department d : c.getDepartments().values()) {
      HashMap<String, Project> projects = d.getProjects();
      if (projects.size() > 0) {
        System.out.printf("   Projects In %s Department\n", d.getName());
        System.out.println(line1);
        System.out.println("          Projects");
        System.out.println(line1);
        String projectTemplate = "          %-10s%-30s%15s%25s\n";
        System.out.printf(projectTemplate, "ID", "Name", "Budget", "Number of Employees");
        System.out.println(line1);
        double totalBudget = 0;
        int totalEmployees = 0;
        for (Project project : projects.values()) {
          int numEmps = project.getEmployees().size();
          System.out.printf(projectTemplate, project.getId(), project.getName(), project.getBudget(), numEmps);
          totalBudget += project.getBudget();
          totalEmployees += project.getEmployees().size();
        }
        System.out.println(line1);
        String summaryTemplate = "%65s%25s\n";
        System.out.printf(summaryTemplate, "Total Budget:", totalBudget);
        System.out.printf(summaryTemplate, "Total Employees:", totalEmployees);
        System.out.println(line2);
      }
    }
  }

  private static void showProjectsAndEmployees(ArrayList<Project> projects) {
    System.out.println(line2);
    System.out.println("4. Show the list of projects and the associated employees.");
    System.out.println(line2);
    for (Project project : projects) {
      HashMap<String, Employee> employees = project.getEmployees();
      String projectTemplate = "          %19s: %s\n";
      System.out.printf("   Project %s\n", project.getName());
      System.out.println(line1);
      System.out.printf(projectTemplate, "ID", project.getId());
      System.out.printf(projectTemplate, "Name", project.getName());
      System.out.printf(projectTemplate, "Budget", project.getBudget());
      System.out.printf(projectTemplate, "Department", project.getDepartment().getName());
      System.out.printf(projectTemplate, "Number Of Employees", employees.size());
      System.out.println(line1);
      System.out.printf("   Employees In Project %s\n", project.getName());
      System.out.println(line1);
      String employeeTemplate = "          %-5s   %-10s%10s%15s   %-20s%8s\n";
      System.out.printf(employeeTemplate, "ID", "Name", "Salary", "Year Of Birth", "Department", "Age", "Years Left");
      System.out.println(line1);
      for (Employee employee : employees.values()) {
        if (employee instanceof Permanent) {
          System.out.printf(
            employeeTemplate,
            employee.getId(),
            employee.getName(),
            employee.getSalary(),
            employee.getYearOfBirth(),
            employee.getDepartment().getName(),
            employee.getAge(),
            employee.getServiceYearsLeft()
          );
        }
      }
      System.out.println(line2);
    }
  }
}
