import comments.Comment;
import comments.CommentsContainerFactory;

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

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
