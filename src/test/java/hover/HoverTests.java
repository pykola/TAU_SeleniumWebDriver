package hover;

import base.BaseTest;
import java.util.Optional;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTest {

    @Test
    public void testHoverUser1() {
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption did not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption title is incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text is incorrect");
//        assertEquals(caption.getLink(),
//                "https://the-internet.herokuapp.com/users/1",
//                "Caption link is incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Caption link is incorrect");
    }

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }
}
