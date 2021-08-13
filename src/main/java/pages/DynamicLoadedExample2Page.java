package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadedExample2Page {
  private WebDriver driver;
  private By startButton = By.cssSelector("#start button");
  private By loadingBar = By.id("loading");
  private By loadedText = By.id("finish");

  public DynamicLoadedExample2Page(WebDriver driver) {
    this.driver = driver;
  }

  public void clickStartButton() {
    driver.findElement(startButton).click();
  }

  public String getStartButtonText() {
    return driver.findElement(startButton).getText();
  }

  public String getLoadedText() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.invisibilityOf(
        driver.findElement(loadingBar)));
    return driver.findElement(loadedText).getText();
  }


}
