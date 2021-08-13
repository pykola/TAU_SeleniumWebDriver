package utils;

import java.util.ArrayList;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;

public class WindowManager {
  private WebDriver driver;
  private WebDriver.Navigation navigate;

  public WindowManager(WebDriver driver) {
    this.driver = driver;
    navigate = driver.navigate();
  }

  public void goBack() {
    navigate.back();
  }

  public void goForward() {
    navigate.forward();
  }

  public void refresh() {
    navigate.refresh();
  }

  public void goTo(String url) {
    navigate.to(url);
  }

  public void switchTheTab(String tabTitle) {
    var windows = driver.getWindowHandles();

    System.out.println("Tabs: " + windows.size());

    System.out.println("Window handles:");
    windows.forEach(System.out::println);

    for (String window : windows) {
      System.out.println("Switching to window:" + window);
      driver.switchTo().window(window);

      System.out.println("Current window title: " + driver.getTitle());

      if (tabTitle.equals(driver.getTitle())) {
        break;
      }
    }
  }

  public void switchToSecondTab() {
    var windows = driver.getWindowHandles();
    driver.switchTo().window(new ArrayList<>(windows).get(1));
  }
}
