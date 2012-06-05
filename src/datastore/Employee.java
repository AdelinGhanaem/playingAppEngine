package datastore;

/**
* @author Adelin Ghanayem adelin.ghanaem@clouway.com
*/
public class Employee {

  private String name;
  private String address;

  Employee(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }
}
