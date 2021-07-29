package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
  private WebDriver driver;
  private By frameTop = By.cssSelector("frame[name='frame-top']");  // better to use  String topFrame = "frame-top" and then switchTo().frame(topFrame)
  private By frameLeft = By.cssSelector("frame[name='frame-left']");
  private By frameBottom = By.cssSelector("frame[name='frame-bottom']");
  private By body = By.tagName("body");

  public NestedFramesPage(WebDriver driver) {
    this.driver = driver;
  }

  private void switchToFrame(Frames frame) {
    switch (frame) {
      case TOP:
        driver.switchTo().frame(driver.findElement(frameTop));
        break;
      case LEFT:
        driver.switchTo().frame(driver.findElement(frameLeft));
        break;
      case BOTTOM:
        driver.switchTo().frame(driver.findElement(frameBottom));
        break;
    }
  }

  private void switchToMainArea() {
    driver.switchTo().parentFrame();
  }

  public String getLeftFrameText() {
    switchToFrame(Frames.TOP);
    switchToFrame(Frames.LEFT);
    String text = driver.findElement(body).getText();
    switchToMainArea();  // To TOP frame
    switchToMainArea();  // To HTML
    return text;
  }

  public String getBottomFrameText() {
    switchToFrame(Frames.BOTTOM);
    String text = driver.findElement(body).getText();
    switchToMainArea();
    return text;
  }

  public enum Frames {
    TOP,
    LEFT,
    BOTTOM
  }
}
