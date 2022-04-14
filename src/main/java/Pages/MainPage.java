package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends DefaultPage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void clickTestBaseMenuOption() {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[9]/a")).click();
	}

	public void clickEnvironmentMenuOption() {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[4]/a")).click();
	}

}
