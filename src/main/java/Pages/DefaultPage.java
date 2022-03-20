package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class DefaultPage 
{	
	protected WebDriver driver;
	
	public DefaultPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void initElements(Object pageObject)
	{
		PageFactory.initElements(this.driver, pageObject);
	}

	// Open specified url
	public void open(String url)
	{
		driver.get(url);
	}
		
	// Click specified element on page
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
	// Wait and click specified element on page
	public void waitAndclickElement(WebElement element)
	{	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	// Wait for Webelement to be clickable
	public void waitForClickableElement(WebElement element)
	{	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// Clear text field and sends key phrase
	public void fillInputElement(WebElement element, String phrase)
	{	
		element.clear();
		element.sendKeys(phrase);
	}
	
	// Wait for element "by" until you may click it
	public WebElement waitForClickableElement(By by)
	{
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	// Wait for web element until you may click it and add extra time
	public WebElement waitForClickableElement(By by, int time)
	{
		return (new WebDriverWait(driver, time)).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	// Wait for presence Of Element
	public WebElement waitForpresenceOfElement(By by)
	{
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	// Wait for presence Of Element and add extra time
	public WebElement waitForpresenceOfElement(By by, int time)
	{
		return (new WebDriverWait(driver, time)).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	// Switch to new window by name
	protected void switchWindow(String windowName)
	{
		driver.switchTo().window(windowName);
	}
	
	// Switch to new frame by name
	protected  void switchFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
}
