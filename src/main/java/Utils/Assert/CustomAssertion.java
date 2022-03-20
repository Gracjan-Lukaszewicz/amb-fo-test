package Utils.Assert;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CustomAssertion
{
    protected WebDriver driver;

    public CustomAssertion(WebDriver driver) {
        this.driver = driver;
    }

    public void assertTitle(String pageTitle) {
        assertEquals(driver.getTitle(), pageTitle);
    }

    public void assertElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void assertElementIsSelected(WebElement element) {
        assertTrue(element.isSelected());
    }

    public void assertContainsText(String phrase) {
        assertTrue(driver.getPageSource().contains(phrase));
    }
}

