package extras;

import static org.testng.Assert.assertFalse;
import base.BaseTest;
import org.testng.annotations.Test;

public class ExtrasTests extends BaseTest {

  @Test
  public void deleteCookieTest() {
    String cookieName = "optimizelyBuckets";
    deleteCookie(cookieName);

    assertFalse(isCookiePresent(cookieName));
  }
}
