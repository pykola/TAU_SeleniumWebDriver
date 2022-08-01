package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

public class BaseTest {

    public EventFiringWebDriver driver;
    protected HomePage homePage;  // protected because test classes that inherit from this will have access to this HomePage

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));

        driver.register(new EventReporter());
        //driver.get("https://the-internet.herokuapp.com/");
/*
        IMPLICIT WAIT
        anytime driver needs to interact within the elements then it should pull the website for up to 30 sec
        until it finds that element. If it finds the element before 30 sec then it will interact with it. If not
        then it will wait and continue to pull until it finds the element or until 30 sec is up. If 30 passed it
        will throw no such element exception*/
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // set on project level. it will wait for all interactions!

/*
        EXPLICIT WAITS
        we can use only when we need to. So if we know of examples where our application needs to wait,
        we can plug them in right there. See DynamicLoadedExample1Page.class
*/
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        goHome();

        setCookie();

        // provide a handle in our test layer for HomePage to our application

//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
//        driver.manage().window().setSize(new Dimension(375, 812));

//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//
//        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
//        inputsLink.click();

//        driver.findElement(By.linkText("Shifting Content")).click();
//        driver.findElement(By.linkText("Example 1: Menu Element")).click();
//        System.out.println(driver.findElements(By.cssSelector("li>a")).size());
//        List<WebElement> menuItems = driver.findElements(By.tagName("li"));
//        System.out.println("Number of menu items: " + menuItems.size());
//
//        System.out.println(driver.getTitle());
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);  // instantiating HomePage
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
            Files.move(screenshot,
                new File("resources/screenshots/" + result.getTestName() + LocalDateTime.now() + ".png"));}
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
//        options.setHeadless(true);

        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
            .domain("the-internet.herokuapp.com")
            .build();
        driver.manage().addCookie(cookie);
    }

    public void setCookie(String name, String value) {
        Cookie cookie = new Cookie.Builder(name, value)
            .domain("the-internet.herokuapp.com")
            .build();
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    public boolean isCookiePresent(String name) {
        return driver.manage().getCookies().stream().anyMatch(cookie -> cookie.getName().equals(name));
        // return driver.manage().getCookieNamed(cookie.getName()) != null;  // takes Cookie cookie as parameter
    }


//    public static void main(String[] args) {
//        BaseTest test = new BaseTest();
//        test.setUp();
//        test.tearDown();
//    }


}
