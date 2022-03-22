package Pages;


import org.openqa.selenium.WebDriver;


public class LoginPage extends DefaultPage
{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		initElements(this);
	}
}