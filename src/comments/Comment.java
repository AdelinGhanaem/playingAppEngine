package comments;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Comment {


  private String comment;
  private String username;

  public Comment(String comment, String username) {
    this.comment = comment;
    this.username = username;
  }

  public String getComment() {
    return comment;
  }

  public String getUsername() {
    return username;
  }
}

