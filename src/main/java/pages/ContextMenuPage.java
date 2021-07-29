package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
  private WebDriver driver;
  private By hotSpotBox = By.id("hot-spot");
  private Actions actions;

  public ContextMenuPage(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
  }

  private WebElement getHotSpotBox() {
    return driver.findElement(hotSpotBox);
  }

  public void triggerAlert() {
    actions.contextClick(getHotSpotBox()).build().perform();
  }

  public String alert_getText() {
    return driver.switchTo().alert().getText();
  }

  public void alert_clickToAccept() {
    driver.switchTo().alert().accept();
  }
}
