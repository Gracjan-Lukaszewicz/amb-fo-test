package test;

import Core.Tests.DefaultTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(Utils.ListenerTest.class)
public class BaseLoginTest extends DefaultTest {

    private static final Logger logger = LogManager.getLogger(BaseLoginTest.class.getName());

    //    @Test(retryAnalyzer = MyTestsRetry.class)
//    @Test(enabled = false)

//    @DataProvider(name = "providerName")
//    public Object[][] providerData() {
//        return new Object[][]
//                {{"administrator@testarena.pl","sumXQQ72$L"},{"data2-1","data2-2"}};
//    }


    @Test
//    @Parameters({"login", "pass"})
    public void loginTest() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get("http://demo.testarena.pl/zaloguj");

        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("login")).click();

        Assert.assertEquals(driver.getTitle(), "Kokpit - TestArena Demo");

        driver.quit();
    }
}
