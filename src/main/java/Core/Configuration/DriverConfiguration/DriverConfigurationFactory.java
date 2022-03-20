package Core.Configuration.DriverConfiguration;

import Configuration.DriverConfiguration.Drivers.ChromeDriverConfiguration;
import Configuration.DriverConfiguration.Drivers.FirefoxDriverConfiguration;

public class DriverConfigurationFactory
{

    public DriverConfiguration getDriver(String driverType)
    {
        if(driverType == null)
        {
            return null;
        }

        if(driverType.equals("firefox"))
        {
            return new FirefoxDriverConfiguration();
        }
        else if(driverType.equals("chrome"))
        {
            return new ChromeDriverConfiguration();
        }

        return null;
    }
}
