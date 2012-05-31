package Comments;

import java.util.ArrayList;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class CommentsContainerFactory {


  private static CommentsContainer commentsContainer;

  public static CommentsContainer getCommentsContainer() {
    if (commentsContainer == null) {
      commentsContainer = new CommentsContainer(new ArrayList<Comment>());
    }
    return commentsContainer;
  }
}
