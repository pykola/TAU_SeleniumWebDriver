package frames;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class FramesTests extends BaseTest {

  @Test
  public void testEditor() {
    var editorPage = homePage.clickWYSIWYGEditor();

    editorPage.clearTextArea();

    String text1 = "hello ";
    String text2 = "world";

    editorPage.setTextArea(text1);
    editorPage.clickIncreaseIndentButton();
    editorPage.setTextArea(text2);

    assertEquals(editorPage.getTextFromEditor(), text1+text2, "Incorrect text");
  }

  @Test
  public void testNestedFrames() {
    var nestedFramesPage = homePage.clickFrames().clickOnNestedFramesLink();

    assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Incorrect text");
    assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Incorrect text");
  }
}
