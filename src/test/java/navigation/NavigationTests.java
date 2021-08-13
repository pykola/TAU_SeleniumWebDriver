package navigation;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

  @Test
  public void testNavigator() {
    homePage.clickDynamicLoading().clickExample1();
    getWindowManager().goBack();
    getWindowManager().refresh();
    getWindowManager().goForward();
    getWindowManager().goTo("https://google.com");
  }

  @Test
  public void testSwitch() {
    homePage.clickMultipleWindows().clickLink();
    getWindowManager().switchTheTab("New Window");
  }

  @Test
  public void testNavigation(){
    var dynamicPage =  homePage.clickDynamicLoading();
    var example2 = dynamicPage.rightClickExample2();
    getWindowManager().switchToSecondTab();

    String text = example2.getStartButtonText();

    assertEquals("Start", text);
  }
}
