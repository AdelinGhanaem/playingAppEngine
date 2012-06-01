package crons;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@WebServlet(name = "crons.CronJobServlet")
public class CronJobServlet extends HttpServlet {
  private Logger logger = Logger.getLogger(this.getClass().toString());

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    logger.info("Google app engine successfully called this servlet and a cron job i executed !");
    System.out.println("Google app engine successfully called this servlet and a cron job i executed !");

  }
}
