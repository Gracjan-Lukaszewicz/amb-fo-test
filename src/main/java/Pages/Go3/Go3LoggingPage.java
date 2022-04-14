package Pages.Go3;

import Core.Configuration.Go3Authorization;
import Pages.DefaultPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Go3LoggingPage extends DefaultPage {

	public Go3LoggingPage(WebDriver driver) {
		super(driver);
		initElements(this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/nav[1]/div/div[2]/i[2]")
	public WebElement userIcon;

	@FindBy(xpath = "//*[@id=\"app\"]/nav[1]/div/div[2]/i[1]")
	public WebElement adultButton;

	@FindBy(xpath = "//*[@id=\"app\"]/nav[1]/div/div[2]/i[1]")
	public WebElement kidsButton;

	@FindBy(xpath = "//*[@id=\"app\"]/nav[1]/div/div[2]/a")
	public WebElement subscribeButton;

	@FindBy(id = "input-login")
	public WebElement loginField;

	@FindBy(id = "input-password")
	public WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"app\"]/div[2]/section/div/div[2]/form/div[3]/div[1]/button")
	public WebElement loginButton;

	public Go3LoggingPage clickLoginButton() {
		userIcon.click();

		return new Go3LoggingPage(driver);
	}

	public Go3LoggingPage loginToGo3Page() {

		Go3Authorization go3Authorization = new Go3Authorization();

		loginField.sendKeys(go3Authorization.getUSERNAME());
		passwordField.sendKeys(go3Authorization.getPASSWORD());
		loginButton.click();

		return new Go3LoggingPage(driver);
	}

	public Go3LoggingPage clickKids() {
		kidsButton.click();

		return new Go3LoggingPage(driver);
	}

	public Go3LoggingPage clickAdult() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		adultButton.click();

		return new Go3LoggingPage(driver);
	}

	public void assertSubscribeButton() {
		Assert.assertTrue(subscribeButton.isDisplayed());
	}

	@Test
	public Go3LoggingPage login() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.get("https://go3.lv/");
		driver.manage().window().maximize();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/nav[1]/div/div[2]/div[1]/div[1]/div")).isDisplayed());

		return new Go3LoggingPage(driver);
	}

}
