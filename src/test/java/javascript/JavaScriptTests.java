package javascript;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTest {

  @Test
  public void testScrollToElement() {
    var largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
    largeAndDeepDomPage.isOpened("/large");

    largeAndDeepDomPage.scrollToTable();
  }

  @Test
  public void testScroll() {
    var infiniteScrollPage = homePage.clickInfiniteScroll();
    infiniteScrollPage.scrollToParagraph(13);

    assertEquals(infiniteScrollPage.paragraphsDisplayed(), 13);
  }
}
