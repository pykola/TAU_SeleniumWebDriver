package alerts;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class FileUploadTests extends BaseTest {

  @Test
  public void testFileUpload() {
    var fileUploadPage = homePage.clickFileUpload();
    fileUploadPage.uploadFile("/home/mykolalagoda/IdeaProjects/TAU_SeleniumWebDriver/resources/chromedriver");

    assertEquals(fileUploadPage.getUploadedFileName(), "chromedriver");
  }
}
