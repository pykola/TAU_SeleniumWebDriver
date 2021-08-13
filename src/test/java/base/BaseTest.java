package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.util.List;
import utils.WindowManager;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;  // protected because test classes that inherit from this will have access to this HomePage

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
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

        // provide a handle in our test layer for HomePage to our application
        homePage = new HomePage(driver);  // instantiating HomePage

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
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

//    public static void main(String[] args) {
//        BaseTest test = new BaseTest();
//        test.setUp();
//        test.tearDown();
//    }
}
