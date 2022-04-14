package Pages.Player;

import Pages.DefaultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PlayerLandingPage extends DefaultPage {

	public PlayerLandingPage(WebDriver driver) {
		super(driver);
		initElements(this);
	}

	public String title = "pajeczyna";

	@FindBy(id = "onetrust-accept-btn-handler")
	public WebElement agreementPopup;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/div[4]/input")
	public WebElement searchField;

	@FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/div/div[1]/div/div/div[1]/a/img")
	public WebElement pajeczyna;

	public PlayerLandingPage search() {
		agreementPopup.click();
		searchField.sendKeys(title);

		return new PlayerLandingPage(driver);
	}

	public PlayerDetailPage selectProduct() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pajeczyna.click();

		return new PlayerDetailPage(driver);
	}

}
