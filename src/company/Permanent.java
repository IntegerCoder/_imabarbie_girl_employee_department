package company;

import company.department.*;

public class Permanent extends Employee {
  public Permanent(String id, String name, double salary, int year, Department department) {
    super(id,name,salary,year,department);
  }
}