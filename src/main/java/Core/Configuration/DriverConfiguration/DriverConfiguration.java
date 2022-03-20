package Core.Configuration.DriverConfiguration;

import Core.Configuration.BaseConfiguration.BaseConfiguration;
import org.openqa.selenium.WebDriver;

public interface DriverConfiguration
{
    WebDriver getDefaultDriver(BaseConfiguration baseConfiguration);
}
