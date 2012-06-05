package datastore.entites;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Book {

  private String id;

  private String name;

  public Book(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String geName() {

    return name;
  }

  public String getId() {
    return id;
  }

}
