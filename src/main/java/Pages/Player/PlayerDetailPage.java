package Pages.Player;

import Pages.DefaultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PlayerDetailPage extends DefaultPage {

	public PlayerDetailPage(WebDriver driver) {
		super(driver);
		initElements(this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/section/div[2]/div[1]/div[1]/div[4]/div[2]/span")
	public WebElement trailer;

	@FindBy(xpath = "//*[@id=\"controls\"]")
	public WebElement player;

	public PlayerDetailPage playTrailer() {
		waitForClickableElement(trailer);
		trailer.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(player.isDisplayed());

		return new PlayerDetailPage(driver);
	}



}
