package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestBasePage extends DefaultPage {

	public TestBasePage(WebDriver driver) {
		super(driver);
	}

	public void fillTestForm() {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[9]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/article/nav/ul/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/article/nav/ul/div/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Automatic test creation");
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("lorem ipsum");
		driver.findElement(By.xpath("//*[@id=\"result\"]")).sendKeys("lorem ipsum");
	}

	public void submitTestForm() {
		driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
	}

	public void AssertTestForm() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"activeProject_chosen\"]/a/span")).isDisplayed());
	}

}
