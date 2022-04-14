package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends DefaultPage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
		initElements(this);
	}

	@Test
	public void login() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.get("http://demo.testarena.pl/zaloguj");
		driver.manage().window().maximize();

		//        Login
		driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
		driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
		driver.findElement(By.id("remember")).click();
		driver.findElement(By.id("login")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_logo\"]")).isDisplayed());

	}


}
