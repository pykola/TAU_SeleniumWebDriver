package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
  private WebDriver driver;
//  private By slider = By.xpath(".//input[@type='range']");
//  private By slider = By.tagName("input");
  private By slider = By.cssSelector(".sliderContainer input");
  private By range = By.id("range");

  public HorizontalSliderPage(WebDriver driver) {
    this.driver = driver;
  }

  public void moveSliderNTimesWithArrowKey(int n) {
//    for (int i = 0; i < n; i++) {
//      driver.findElement(slider).sendKeys(Keys.chord(Keys.ARROW_RIGHT));
//    }
    while (n != 0) {
      driver.findElement(slider).sendKeys(Keys.chord(Keys.ARROW_RIGHT));
      n--;
    }
  }

  public void moveSliderToRange(String moveRange) {
    while (!getRangeValue().equals(moveRange)) {
      driver.findElement(slider).sendKeys(Keys.chord(Keys.ARROW_RIGHT));
    }
  }

  public String getRangeValue() {
    return driver.findElement(range).getText();
  }
}
