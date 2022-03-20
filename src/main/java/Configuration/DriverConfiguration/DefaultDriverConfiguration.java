package Configuration.DriverConfiguration;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DefaultDriverConfiguration
{	
	protected static WebDriver driver;

	public static WebDriver configureDefaultDriver(WebDriver d)
	{
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
		return d;
	}
}
