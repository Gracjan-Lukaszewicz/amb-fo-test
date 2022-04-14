package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EnvironmentPage extends DefaultPage {

	public EnvironmentPage(WebDriver driver) {
		super(driver);
	}

	public void clickNewEnvironment() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/article/nav/ul/li/a")).click();
	}

	public void fillEnvironmentForm() {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Automated environment creation 3");
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("lorem ipsum");
	}

	public void clickSubmitNewEnvironment() {
		driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
	}

	public void assertNewEnvironment() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"j_info_box\"]")).isDisplayed());
	}

}
