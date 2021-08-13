package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {
  private WebDriver driver;
  private String linkXpath = ".//a[contains(text(), '%s')]";
  private By example1 = By.xpath(String.format(linkXpath, "Example 1"));
  private By example2 = By.xpath(String.format(linkXpath, "Example 2"));

  public DynamicLoadingPage(WebDriver driver) {
    this.driver = driver;
  }

  public DynamicLoadedExample1Page clickExample1() {
    driver.findElement(example1).click();
    return new DynamicLoadedExample1Page(driver);
  }

  public DynamicLoadedExample2Page clickExample2() {
    driver.findElement(example2).click();
    return new DynamicLoadedExample2Page(driver);
  }

  public DynamicLoadedExample2Page rightClickExample2() {
    Actions action = new Actions(driver);
    action.keyDown(Keys.CONTROL).click(driver.findElement(example2)).perform();
    return new DynamicLoadedExample2Page(driver);
  }
}
