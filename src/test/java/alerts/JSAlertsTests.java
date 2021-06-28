package alerts;

import static org.testng.Assert.assertEquals;
import base.BaseTest;
import org.testng.annotations.Test;

public class JSAlertsTests extends BaseTest {

  @Test
  public void testAcceptAlert() {
    var alertsPage = homePage.clickJavaScriptAlerts();
    alertsPage.triggerAlert();
    alertsPage.alert_clickToAccept();

    assertEquals(alertsPage.getResultMessage(), "You successfully clicked an alert");
  }

  @Test
  public void testConfirmAlert() {
    var alertsPage = homePage.clickJavaScriptAlerts();
    alertsPage.triggerConfirm();
    String text = alertsPage.alert_getText();
    alertsPage.alert_clickToDismiss();

    assertEquals(text, "I am a JS Confirm");
    assertEquals(alertsPage.getResultMessage(), "You clicked: Cancel");
  }

  @Test
  public void testPromptAlert() {
    var alertsPage = homePage.clickJavaScriptAlerts();
    alertsPage.triggerPrompt();
    String text = "TAU rocks!";
    alertsPage.alert_inputText(text);
    alertsPage.alert_clickToAccept();

    assertEquals(alertsPage.getResultMessage(), "You entered: " + text);
  }
}
