package datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@WebServlet(name = "EmploiesStoreServlet")
public class EmploiesStoreServlet extends HttpServlet {

  class Address {

    private final String address = "BG25";

    private Address() {

    }

    public String getAddress() {
      return address;
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity employee = new Entity("Employee");

    String firstName = request.getParameter("firstname");

    Date date = new Date();

    employee.setProperty("firstName", firstName);

    employee.setProperty("dateOfBirth", date);

    employee.setProperty("isIll", false);

    datastoreService.put(employee);

    Query query = new Query("Employee");

//    query.addFilter("firstName", Query.FilterOperator.EQUAL, firstName);

    PreparedQuery preparedQuery = datastoreService.prepare(query);

    List<Employee> employees = new ArrayList<Employee>();

    String address = "BG25";

    for (Entity entity : preparedQuery.asIterable()) {
      employees.add(new Employee((String) entity.getProperty("firstName"), address));
    }
    System.out.println(employees.size());
    request.setAttribute("emplployees", employees);
    request.getRequestDispatcher("employeeform.jsp").forward(request, response);
  }

}
