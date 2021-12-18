package company;

import company.department.Department;

public class Temporary extends Employee {
  private String startDate;
  private String endDate;

  public Temporary(String id, String name, double salary, int year, Department department, String startDate, String endDate) {
    super(id, name, salary, year, department);  // for Employee
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }
}