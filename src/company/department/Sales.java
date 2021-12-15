package company.department;

public class Sales extends Department {
  public Sales() {
    // Department("D002", "Sales"); // won't compile
    super("D002", "Sales");
  }
}