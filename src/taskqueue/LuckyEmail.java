package taskqueue;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@WebServlet(name = "LuckyEmail")
public class LuckyEmail extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("I am GET");

    String email = request.getParameter("email").trim();

    Queue queue = QueueFactory.getQueue("LuckQueue");

    queue.add(TaskOptions.Builder.withUrl("/luckemailtask").param("email", email));

    response.getWriter().println("Every thing i OK ! go and see whose emails are luck ");

    response.getWriter().println("<p><a href=\"/luckyemails.jsp\">Lucky emails !</a><p>");
  }
}
