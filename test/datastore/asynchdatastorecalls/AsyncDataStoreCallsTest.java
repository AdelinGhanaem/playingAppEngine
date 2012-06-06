package datastore.asynchdatastorecalls;

import com.google.appengine.api.datastore.AsyncDatastoreService;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AsyncDataStoreCallsTest {


  private AsyncDatastoreService service;

  //setting up app-engine testing environment;

  private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());



  @Before
  public void setUp() {
    helper.setUp();
    service = DatastoreServiceFactory.getAsyncDatastoreService();
  }

  @Test
  public void theFrameWorkIsWorking() {
    assertThat(10, is(equalTo(5 + 5)));
  }


  @Test
  public void testAsyncDatastoreCalls() throws Exception {
    Entity address = new Entity("Employee");
    address.setProperty("name", "Adelin");
    service.put(address);
    Key key = address.getKey();
    Future<Entity> future = service.get(key);
    Entity entity = future.get();
    assertThat((String) entity.getProperty("street"), is(equalTo("BG25")));
  }


  @Test
  public void testAsyncDatastoreCallsInTransaction() throws ExecutionException, InterruptedException {

    Future<Transaction> transaction = service.beginTransaction();
    Key key = KeyFactory.createKey("Employee", "101");


    Entity employee = new Entity("Employee", key);

    employee.setProperty("name", "Ivan");

    service.put(employee);


    Future<Entity> entity = service.get(key);


    entity.get().setProperty("name", "Petar");

    service.put(entity.get());

    Future<Entity> editedEntity = service.get(entity.get().getKey());

    transaction.get().commit();

    assertThat((String) editedEntity.get().getProperty("name"), is(equalTo("Petar")));

  }

  @After
  public void tearDown() {
    helper.tearDown();
  }


  @Test
  public void saveEntityIsRestoredCorrectly() throws Exception {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
    Entity entity = new Entity("employee");
    entity.setProperty("name", "adelin");
    entity.setProperty("id", "123");
    datastoreService.put(entity);
    Entity returnedEntity = datastoreService.get(entity.getKey());
    assertThat(returnedEntity.getProperty("name").toString(), is(equalTo("adelin")));
  }


}
