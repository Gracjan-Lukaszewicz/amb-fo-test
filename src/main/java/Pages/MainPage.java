package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends DefaultPage {


    public MainPage(WebDriver driver)
    {
        super(driver);
        initElements(this);
    }

    @FindBy(className = "item5")
    public WebElement menuItem5;

    public void clickMenuItem() {
        menuItem5.click();
    }
}
