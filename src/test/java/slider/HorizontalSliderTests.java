package slider;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends BaseTest {

  @Test
  public void testMoveSliderInt() {
    var horizontalScrollPage = homePage.clickHorizontalSlider();
    horizontalScrollPage.moveSliderNTimesWithArrowKey(8);

    assertEquals(horizontalScrollPage.getRangeValue(), "4");
  }

  @Test
  public void testMoveSliderString() {
    var horizontalScrollPage = homePage.clickHorizontalSlider();
    horizontalScrollPage.moveSliderToRange("4");

    assertEquals(horizontalScrollPage.getRangeValue(), "4");
  }
}
