package taskqueue;

import Comments.LuckyEmails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@SuppressWarnings("serial")
@WebServlet(name = "LuckEmailTask")
public class LuckEmailTask extends HttpServlet {


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("This email is logged in response to an execution of a TASK  [ " + request.getParameter("email") + " ]");
    List<String> emails = LuckyEmails.getEmails();
    emails.add(request.getParameter("email"));
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("This email is logged in response to an execution of a TASK  [ " + request.getParameter("email") + " ]");
    List<String> emails = LuckyEmails.getEmails();
    emails.add(request.getParameter("email"));

  }


}
