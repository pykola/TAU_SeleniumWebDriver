package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAdPage {
  private WebDriver driver;
  private WebDriverWait wait;
  private By modalWindow = By.id("modal");
  private By closeModalLink = By.cssSelector(".modal-footer p");

  public EntryAdPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.elementToBeClickable(closeModalLink));
  }

  public void closeModal() {
    driver.findElement(closeModalLink).click();
  }

  public String getModalStyle() {
    return driver.findElement(modalWindow).getAttribute("style");
  }

  public boolean isModalDisplayed() {
    System.out.println(getModalStyle());
    System.out.println(getModalStyle().equals("display: block;"));
    return getModalStyle().equals("display: block;");
  }
}
