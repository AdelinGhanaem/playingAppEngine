package Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class LuckyEmails {

  private static List<String> luckyEmails;

  public static List<String> getEmails() {
    if (luckyEmails == null) {
      luckyEmails = new ArrayList<String>();
    }
    return luckyEmails;
  }
}
