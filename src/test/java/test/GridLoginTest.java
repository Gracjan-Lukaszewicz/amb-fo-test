package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GridLoginTest {

    private static final Logger logger = LogManager.getLogger(GridLoginTest.class.getName());

    @Test
    public void loginTest() {


        WebDriver driver = null;

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        try {
            driver = new RemoteWebDriver(
                    new URL("http://127.0.0.1:4444/wd/hub"),firefoxOptions);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        assert driver != null;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.navigate().to("http://demo.testarena.pl/zaloguj");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("login")).click();



        logger.error("Halo jestem tutaj");
        Assert.assertEquals(driver.getTitle(), "Kokpit - TestArena Demo");

        driver.quit();

    }
}
