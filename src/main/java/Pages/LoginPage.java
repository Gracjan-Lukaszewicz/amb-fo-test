package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class LoginPage extends DefaultPage
{		
	@FindBy (id = "email")
	public WebElement emailField;
	
	@FindBy (id = "password")
	public WebElement passwordField;
	
	@FindBy (id = "login")
	public WebElement loginBtn;
	
	@FindBy (id = "remember")
	public WebElement rememberMe;
	
	@FindBy (xpath = "html/body/section/header/div/div/div/form/div[5]/div[1]/a")
	public WebElement lostPassword;	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		initElements(this);
	}

	// Wait for Webelement and fill the email field
	public void fillEmailField(String phrase)
	{
		waitAndclickElement(emailField);
		fillInputElement(emailField, phrase);
	}
	
	// Wait for Webelement and fill the password field
	public void fillPasswordField(String phrase)
	{
		waitAndclickElement(passwordField);
		fillInputElement(passwordField, phrase);
	}
	
	// Click login button
	public void clickLoginBtn()
	{
		clickElement(loginBtn);
	}

	public LoginPage fillLoginFormAndSubmit(String email, String password) {


		emailField.clear();
		emailField.sendKeys(email);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginBtn.click();
		return new LoginPage(this.driver);
	}

	public void loginSuccess() {
		Assert.assertEquals(driver.getTitle(), "Kokpit - TestArena Demo");
	}

}