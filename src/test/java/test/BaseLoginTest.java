package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

//@Listeners(Utils.ListenerTest.class)
public class BaseLoginTest {

    private static final Logger logger = LogManager.getLogger(BaseLoginTest.class.getName());
    WebDriver driver;

    //    @Test(retryAnalyzer = MyTestsRetry.class)
//    @Test(enabled = false)
//    @Test(groups = { "functest" })

    @BeforeTest
    public void setUpTest() // Select environment and driver
    {

        System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }


    @DataProvider(name = "providerName")
    public Object[][] providerData() {
        return new Object[][]
                {{"administrator@testarena.pl","sumXQQ72$L"},{"data2-1","data2-2"}};
    }


    @Test
    @Parameters({"login", "pass"})
    public void loginTest(String login, String pass) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get("http://demo.testarena.pl/zaloguj");

        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login")).click();

        logger.error("Halo jestem tutaj");

        Assert.assertEquals(driver.getTitle(), "Kokpit - TestArena Demo");

        driver.quit();
    }

    @Test(dataProvider = "providerName")
    public void logoutTest(String data1, String data2) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get("http://demo.testarena.pl/zaloguj");

        driver.findElement(By.id("email")).sendKeys(data1);
        driver.findElement(By.id("password")).sendKeys(data2);
        driver.findElement(By.id("login")).click();

        driver.findElement(By.className("header_logout")).click();
        logger.error("Halo jestem tutaj");

        Assert.assertEquals(driver.getTitle(), "TestArena Demo");

        driver.quit();
    }
}
