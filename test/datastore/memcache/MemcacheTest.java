package datastore.memcache;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import datastore.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MemcacheTest {


  private LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalMemcacheServiceTestConfig());

  @Before
  public void setUp() {
    helper.setUp();
  }

  @Test
  public void simpleMemcacheTest() {
    MemcacheService service = MemcacheServiceFactory.getMemcacheService();
    Employee employee = new Employee("Adelin", "Bulgaria");
    service.put("Customer", employee);
    Employee returnedEmployee = (Employee) service.get("Customer");
    assertThat(returnedEmployee, is(notNullValue()));
    assertThat(returnedEmployee.getName(), is(equalTo("Adelin")));
    assertThat(returnedEmployee.getAddress(), is(equalTo("Bulgaria")));
  }


  @After
  public void tearDown() {
    helper.setUp();
  }


}
