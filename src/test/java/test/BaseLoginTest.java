package test;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(Utils.ListenerTest.class)
public class BaseLoginTest {

    private static final Logger logger = LogManager.getLogger(BaseLoginTest.class.getName());
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test

    public void loginTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get("https://player.pl/");

        driver.switchTo().frame(driver.findElement(By.className("__ipPerunElement")));
        driver.findElement(By.xpath("//p[@class='__ipPopupWebPushAsk']")).click();
        driver.switchTo().parentFrame();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Assert.assertEquals(driver.getTitle(), "Seriale, Filmy, Programy, kanały TV Online - wejdź i oglądaj na Player.pl");

        driver.quit();
    }
}
