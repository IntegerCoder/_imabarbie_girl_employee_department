import company.Company;
import company.Employee;
import company.Permanent;
import company.Temporary;
import company.department.Department;
import company.department.HR;
import company.department.SE;
import company.department.Sales;

public class Main {
  public static void main(String[] args) {
    int lineLength = 50;
    String line1 = "-".repeat(lineLength);
    String line2 = "=".repeat(lineLength);

    Company c = new Company("KOOT");

    Sales salesDept = new Sales();
    HR hrDept = new HR();
    SE seDept = new SE();

    c.addDepartment(hrDept);
    c.addDepartment(salesDept);
    c.addDepartment(seDept);

    Permanent e1 = new Permanent("19001", "Jack", 20000, 1985, hrDept);
    Permanent e2 = new Permanent("20001", "Jane", 21000, 1987, hrDept);
    Temporary e3 = new Temporary("18002", "John", 30000, 1989, salesDept, "1/1/2000", "31/12/2000");
    Temporary e4 = new Temporary("17001", "Mike", 35000, 1980, salesDept, "1/1/2010", "31/21/2010");
    Permanent e5 = new Permanent("25001", "Bill", 25000, 1991, seDept);
    Permanent e6 = new Permanent("25002", "Bell", 23000, 1995, seDept);

    System.out.println(line2);
    System.out.println("Show the list of employees in each department");
    System.out.println(line2);
    for (Department d : c.getDepartments().values()) {
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
