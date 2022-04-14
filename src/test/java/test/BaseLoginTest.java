package test;

import Core.Tests.DefaultTest;
import Pages.EnvironmentPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.TestBasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Utils.ListenerTest.class)
public class BaseLoginTest extends DefaultTest {

    private static final Logger logger = LogManager.getLogger(BaseLoginTest.class.getName());

    WebDriver driver;

    LoginPage loginPage;

    MainPage mainPage;

    TestBasePage testBasePage;

    EnvironmentPage environmentPage;

    @BeforeMethod
    public void setUpMethod() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }



    @DataProvider(name = "dp")
    public Object[][] dataProviderMethod() {
        return new Object[][] {{"DUPA"}, {"DUPSKO"}};
    }

    @Test(dataProvider = "dp")
    public void printParam(String param) {
        System.out.println(param);
    }

    @Test
    public void createEnvironment() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        environmentPage = new EnvironmentPage(driver);

        loginPage.login();
        mainPage.clickEnvironmentMenuOption();
        environmentPage.clickNewEnvironment();
        environmentPage.fillEnvironmentForm();
        environmentPage.clickSubmitNewEnvironment();
        environmentPage.assertNewEnvironment();

        driver.quit();
    }

    @Test
    public void demoTest() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        testBasePage = new TestBasePage(driver);

        loginPage.login();
        mainPage.clickTestBaseMenuOption();
        testBasePage.fillTestForm();
        testBasePage.submitTestForm();
        testBasePage.AssertTestForm();

        driver.quit();

    }

    @Test
    public void nieZgadniesz() {

        char[] wiedzaTajemna = new char[4];
        wiedzaTajemna[0] = (char) 68;
        wiedzaTajemna[1] = (char) 85;
        wiedzaTajemna[2] = (char) 80;
        wiedzaTajemna[3] = (char) 65;

        StringBuilder zgadnij = new StringBuilder();

        for (char tajemnica : wiedzaTajemna) {
            zgadnij.append(tajemnica);
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://www.google.pl/");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(zgadnij);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a")).click();
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
