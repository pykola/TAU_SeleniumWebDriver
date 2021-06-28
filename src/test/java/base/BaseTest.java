package base;

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

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;  // protected because test classes that inherit from this will have access to this HomePage

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://the-internet.herokuapp.com/");
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

//    public static void main(String[] args) {
//        BaseTest test = new BaseTest();
//        test.setUp();
//        test.tearDown();
//    }
}
