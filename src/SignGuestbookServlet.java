import Comments.Comment;
import Comments.CommentsContainerFactory;
import com.google.apphosting.api.ApiProxy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@WebServlet(name = "SignGuestbookServlet")
public class SignGuestbookServlet extends HttpServlet {


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String nickName = request.getParameter("useNickname");
    String comment = request.getParameter("content");
//    System.out.println(ApiProxy.getCurrentEnvironment().getRemainingMillis());
//    System.out.println(ApiProxy.getCurrentEnvironment().);
//
//    for (int i = 0; i < 70; i++) {
//      try {
//        System.out.println(i);
//        Thread.sleep(1000);
//
//      } catch (InterruptedException e) {
//        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      }
//    }
    try {
      Thread.sleep(70000);
    } catch (InterruptedException e) {
      e.printStackTrace();
      System.out.println(ApiProxy.getCurrentEnvironment().getRemainingMillis());

      if ("".equals(comment)) {
        comment = "No comment!";
      }
      if (nickName.equals("null")) {
        nickName = request.getRemoteAddr();
      }
      System.out.println(nickName);
      CommentsContainerFactory.getCommentsContainer().addComment(new Comment(nickName, comment));

      response.sendRedirect("/index.jsp");
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
