package comments;

import java.util.List;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class CommentsContainer {

  private List<Comment> comments;

  public CommentsContainer(List<Comment> comments) {
    this.comments = comments;
  }

  public List<Comment> getComments() {
    return comments;
  }


  public void addComment(Comment comment) {
    comments.add(comment);
  }
}
