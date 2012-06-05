package datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class DateStoreTest {


  private DatastoreService service;

  @Before
  public void setUp() {
    service = DatastoreServiceFactory.getDatastoreService();
  }

  @Test
  public void saveEntityIsRestoredCorrectly() throws Exception {
    Entity entity = new Entity("employee");
    entity.setProperty("name", "adelin");
    entity.setProperty("id", "123");
    service.put(entity);
    Entity returnedEntity = service.get(entity.getKey());

    assertThat(returnedEntity.getProperty("name").toString(), is(equalTo("adelin")));


  }


  class Employee {

    private String name;
    private String id;

    Employee(String name, String id) {
      this.name = name;
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public String getId() {
      return id;
    }


  }

}
