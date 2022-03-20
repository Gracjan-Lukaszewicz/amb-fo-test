package Core.Tests;

import Core.Configuration.BaseConfiguration.BaseConfiguration;
import Core.Configuration.BaseConfiguration.BaseConfigurationFactory;
import Core.Configuration.DriverConfiguration.DriverConfiguration;
import Core.Configuration.DriverConfiguration.DriverConfigurationFactory;
import Core.Utils.DefaultScreenshot;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.TestBasePage;
import Utils.Assert.CustomAssertion;
import Utils.Screenshot.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;

public abstract class DefaultTest
{
    private BaseConfigurationFactory baseConfigurationFactory = new BaseConfigurationFactory();
    private DriverConfigurationFactory driverConfigurationFactory = new DriverConfigurationFactory();

    private BaseConfiguration baseConfiguration;
    private DriverConfiguration driverConfiguration;

    protected static WebDriver driver;
    protected Screenshot screenshot;

    public CustomAssertion customAssertion;
    public LoginPage loginPage;
    public MainPage mainPage;
    public TestBasePage testBasePage;

    @BeforeClass
    public void setUpClass() {

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        testBasePage = new TestBasePage(driver);
    }


    @Parameters({"configuration", "environment", "browser", "logs", "screenshots"})
    @BeforeTest
    public void setUpTest(String configuration, String environment, String browser, String logs, String screenshots) // Select environment and driver
    {
        baseConfiguration = baseConfigurationFactory.getConfiguration(configuration);
        driverConfiguration = driverConfigurationFactory.getDriver(browser);

        driver = driverConfiguration.getDefaultDriver(baseConfiguration);
        customAssertion = new CustomAssertion(driver);
        screenshot = new Screenshot(driver, baseConfiguration);

        driver.get(baseConfiguration.getBaseProtocol() + baseConfiguration.getBaseAuthorizationUsername() + ":"
                + baseConfiguration.getBaseAuthorizationPassword() + "@" + baseConfiguration.getBaseURL());


    }

    @AfterTest
    public void tearDownTest()
    {
        driver.quit();
    }

    @Parameters({"logs", "screenshots"})
    @BeforeMethod
    public void setUpMethod(String logs, String screenshots)
    {
        if (screenshots.equals(DefaultScreenshot.before_after_method )|| screenshots.equals(DefaultScreenshot.before_afterFail_method ))
        {
            screenshot.makeScreenshot();
        }
    }

    @Parameters({"logs", "screenshots"})
    @AfterMethod
    public void tearDownMethod(ITestResult testResult, String logs, String screenshots) throws IOException, InterruptedException
    {
        if (screenshots.equals(DefaultScreenshot.after_method) || screenshots.equals(DefaultScreenshot.before_after_method))
        {
            screenshot.makeScreenshot();
        }
        else if (screenshots.equals(DefaultScreenshot.afterFail_method) || screenshots.equals(DefaultScreenshot.before_afterFail_method))
        {
        if (testResult.getStatus() == ITestResult.FAILURE)
        {
                screenshot.makeScreenshot();
        }
        }
    }

    @BeforeSuite
    public void setUpSuite()
    {

    }

    @AfterSuite
    public void tearDownSuite()
    {

    }
}
