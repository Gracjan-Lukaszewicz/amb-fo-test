package Configuration.DriverConfiguration.Drivers;

import Configuration.DriverConfiguration.DefaultDriverConfiguration;
import Core.Configuration.BaseConfiguration.BaseConfiguration;
import Core.Configuration.DriverConfiguration.DriverConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverConfiguration extends DefaultDriverConfiguration implements DriverConfiguration
{
    public WebDriver getDefaultDriver(BaseConfiguration baseConfiguration)
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver = configureDefaultDriver(driver);
        return driver;
    }

}