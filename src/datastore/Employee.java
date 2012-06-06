package datastore;

import java.io.Serializable;

/**
* @author Adelin Ghanayem adelin.ghanaem@clouway.com
*/
public class Employee implements Serializable {

  private String name;
  private String address;

  public Employee(String name, String address) {
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
