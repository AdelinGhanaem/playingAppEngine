import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class EchoServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter writer = response.getWriter();
//    UserService service = UserServiceFactory.getUserService();
//    User user = service.getCurrentUser();
//    if (user != null) {
    writer.println("Hello , this is my first Google App engine application. I hope you like it !");
    writer.println("you ip address is: " + request.getRemoteAddr());
//    } else {
    writer.println("not signed in !!!!");
//      response.sendRedirect(service.createLoginURL(request.getRequestURI()));
  }
}
