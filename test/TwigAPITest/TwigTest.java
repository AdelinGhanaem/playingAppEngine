package TwigAPITest;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.vercer.engine.persist.ObjectDatastore;
import com.vercer.engine.persist.annotation.AnnotationObjectDatastore;
import datastore.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class TwigTest extends LocalDatastoreTestCase {


  private LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
  private ObjectDatastore datastore;

  @Before
  public void setUp() {
    helper.setUp();
    datastore = new AnnotationObjectDatastore();
  }

  @After
  public void tearDown() {
    helper.setUp();
  }

  @Test
  public void persistObjects() {
    Employee employee = new Employee("Adelin", "BG25");
    Key key = datastore.store(employee);
    Employee returnedEmployee = datastore.find().type(Employee.class).addFilter("name", Query.FilterOperator.EQUAL, "Adelin").returnResultsNow().next();
    assertThat(returnedEmployee.getName(), is(equalTo("Adelin")));
  }


  @Test
  public void persistAListOfObjects() {
    List<Employee> employeeList = new ArrayList<Employee>();
    Employee employee = new Employee("Adelin", "BG25");
    employeeList.add(employee);
    employeeList.add(new Employee("Ivan", "Pi6mana"));
    employeeList.add(new Employee("Georgi", "MaikBalgariq "));
    employeeList.add(new Employee("Grisha", "Ne Znam !"));
    Map<Employee, Key> employeeKeyMap = datastore.storeAll(employeeList);
    Employee returnedEmployee = datastore.load(employeeKeyMap.get(employee));
    assertThat(returnedEmployee.getName(), is("Adelin"));
  }





}
