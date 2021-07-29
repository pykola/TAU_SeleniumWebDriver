package alerts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import base.BaseTest;
import org.testng.annotations.Test;

public class EntryAdTests extends BaseTest {

  @Test
  public void testModalIsOpenedAfterOpeningPage() {
    var entryAdPage = homePage.clickEntryAd();

    assertTrue(entryAdPage.isModalDisplayed());
  }

  @Test
  public void testModalCanBeClosed() {
    var entryAdPage = homePage.clickEntryAd();
    entryAdPage.closeModal();

    assertFalse(entryAdPage.isModalDisplayed());
  }
}
