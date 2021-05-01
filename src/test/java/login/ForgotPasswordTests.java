package login;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTest {

    @Test
    public void testForgotPassword() throws InterruptedException {
        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmailField("tauml@example.com");
        var emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();
        assertEquals(emailSentPage.getMessage(),
                "Your e-mail's been sent!",
                "Expected message is incorrect");
    }
}
