package keys;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class KeysTest extends BaseTest {

  @Test
  public void testBackSpace() {
    var keyPage = homePage.clickKeyPresses();
    keyPage.enterText("A" + Keys.BACK_SPACE);
    assertEquals(keyPage.getResult(), "You entered: BACK_SPACE",
        "Incorrect result message and/or key(s) pressed");
  }

  @Test
  public void TestCtrlShift() {
    var keyPage = homePage.clickKeyPresses();
    keyPage.enterCtrlShift();
    assertEquals(keyPage.getResult(), "You entered: SHIFT");
  }
}
