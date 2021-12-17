import company.*;
import company.department.Department;
import company.department.HR;
import company.department.SE;
import company.department.Sales;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
  private static int lineLength = 100;
  private static String line1 = "-".repeat(lineLength);
  private static String line2 = "=".repeat(lineLength);

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

    Project p1 = new Project("P001", "Build Food Delivery App", 1000000, seDept);
    Project p2 = new Project("P002", "Prepare a Web Server", 200000, seDept);
    Project p3 = new Project("P003", "Communication Skills Training", 150000, salesDept);
    Project p4 = new Project("P004", "Sales Office Renovation", 500000, salesDept);

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

    showDepartmentsAndEmployees(company);
    System.out.println();
    showDepartmentsAndProjects(company);
  }

  private static void showDepartmentsAndProjects(Company c) {
    System.out.println(line2);
    System.out.println("Show the list of projects in each department.");
    System.out.println(line2);
    for (Department d : c.getDepartments().values()) {
      HashMap<String, Project> projects = d.getProjects();
      if (projects.size() > 0) {
        System.out.println("Department: " + d.getName());
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

  private static void showDepartmentsAndEmployees(Company company) {
    System.out.println(line2);
    System.out.println("Show the list of employees in each department.");
    System.out.println(line2);
    for (Department d : company.getDepartments().values()) {
      System.out.printf("Department: %s\n", d.getName());
      System.out.println(line1);
      String template = "%10s%20s%15s\n";
      System.out.printf(template, "Name", "Year Of Birth", "Salary");
      System.out.println(line1);
      double totalSalary = 0;
      for (Employee e : d.getEmployees().values()) {
        totalSalary += e.getSalary();
        System.out.printf(template, e.getName(), e.getYearOfBirth(), e.getSalary());
      }
      System.out.println(line1);
      System.out.printf(template, "", "Total Salary", totalSalary);
      System.out.println(line2);
    }
  }
}
