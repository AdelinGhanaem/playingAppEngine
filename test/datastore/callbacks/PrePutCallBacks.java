package datastore.callbacks;

import com.google.appengine.api.datastore.PrePut;
import com.google.appengine.api.datastore.PutContext;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class PrePutCallBacks {

  static boolean isCalled = false;

  public PrePutCallBacks() {
  }

  @PrePut(kinds = {"Customer"})
  public void log(PutContext putContext) {
    System.out.println(putContext.getCurrentElement().getKey());
    System.out.println("Log method is called");
    System.out.println("Ahaaaaaaaaaaaaaaaaa !!");
    isCalled = true;
  }
}
