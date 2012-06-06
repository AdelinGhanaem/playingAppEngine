package datastore.callbacks;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class CallBacksTest {


  private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
  private boolean prePostIsCalled = false;

  @Before
  public void setUp() {
    helper.setUp();
  }


  @Test
  public void loggingMethodIsInvoked() {

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity customer = new Entity("Customer");

    datastoreService.put(customer);

    assertThat(PrePutCallBacks.isCalled, is(true));
  }




  @After
  public void tearDown() {
    helper.tearDown();
  }

}
