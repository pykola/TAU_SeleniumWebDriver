package wait;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class WaitTest extends BaseTest {

  @Test
  public void waitUntilHidden() {
    var loadingPage = homePage.clickDynamicLoading().clickExample1();
    loadingPage.clickStartButton();
    assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
  }

  @Test
  public void waitUntilDisplayed() {
    var loadingPage = homePage.clickDynamicLoading().clickExample2();
    loadingPage.clickStartButton();
    assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
  }
}
