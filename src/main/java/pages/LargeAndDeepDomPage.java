package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage extends BasePage {
  private By largeTable = By.id("large-table");

  public LargeAndDeepDomPage(WebDriver driver) {
    super(driver);
  }

  public void scrollToTable() {
    WebElement tableElement = getDriver().findElement(largeTable);
    String script = "arguments[0].scrollIntoView();";
    ((JavascriptExecutor) getDriver()).executeScript(script, tableElement);
  }
}
