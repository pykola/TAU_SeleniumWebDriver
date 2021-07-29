package alerts;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class ContextMenuTests extends BaseTest {

  @Test
  public void testContextMenu() {
    var contextMenuPage = homePage.clickContextMenu();
    contextMenuPage.triggerAlert();
    String msg = contextMenuPage.alert_getText();
    contextMenuPage.alert_clickToAccept();

    assertEquals(msg, "You selected a context menu");
  }
}
