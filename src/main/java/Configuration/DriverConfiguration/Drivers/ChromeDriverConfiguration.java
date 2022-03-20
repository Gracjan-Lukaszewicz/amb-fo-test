package Configuration.DriverConfiguration.Drivers;

import Configuration.DriverConfiguration.DefaultDriverConfiguration;
import Core.Configuration.BaseConfiguration.BaseConfiguration;
import Core.Configuration.DriverConfiguration.DriverConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverConfiguration extends DefaultDriverConfiguration implements DriverConfiguration
{
	public WebDriver getDefaultDriver(BaseConfiguration baseConfiguration)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver = configureDefaultDriver(driver);
		return driver;
	}
}
