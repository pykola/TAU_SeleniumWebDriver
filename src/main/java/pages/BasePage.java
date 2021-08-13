package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  private WebDriver driver;
  private WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
  }

  public void isOpened(String expectedUrl) {
    wait.until(ExpectedConditions.urlContains(expectedUrl));
  }

  public WebDriver getDriver() {
    return driver;
  }
}
