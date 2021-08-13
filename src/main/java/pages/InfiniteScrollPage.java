package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage extends BasePage {
  private By paragraphs = By.cssSelector(".jscroll-added");

  public InfiniteScrollPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Scrolls until paragraph with index specified is in view
   * @param index 1-based
   */
  public void scrollToParagraph(int index) {
    String script = "window.scrollTo(0, document.body.scrollHeight);";  // X - horizontal, Y - vertical scroll
    var jsExecutor = (JavascriptExecutor) getDriver();

    while (paragraphsDisplayed() < index) {
//    ((JavascriptExecutor) getDriver()).executeScript(script);
      jsExecutor.executeScript(script);
    }
  }

  public int paragraphsDisplayed() {
    return getDriver().findElements(paragraphs).size();
  }
}
