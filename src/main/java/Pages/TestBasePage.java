package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBasePage extends DefaultPage {

    public TestBasePage(WebDriver driver) {
        super(driver);
        initElements(this);
    }

    @FindBy(className = "button_link_nav")
    public WebElement addTestCaseList;

    @FindBy(css = "li.button_link_li:nth-child(2)")
    public WebElement testCaseList;

    @FindBy(id = "name")
    public WebElement testCaseNameInput;

    @FindBy(id = "description")
    public WebElement testCasedescriptionInput;

    @FindBy(id = "result")
    public WebElement testCaseResultInput;

    @FindBy(id = "add")
    public WebElement saveTestCaseForm;

    public TestBasePage goToAddTestCase() {
        addTestCaseList.click();
        testCaseList.click();
        return new TestBasePage(this.driver);
    }

    public TestBasePage fillAndSaveTestCase() {
        testCaseNameInput.sendKeys("Moje testy");
        testCasedescriptionInput.sendKeys("Moje testy");
        testCaseResultInput.sendKeys("Moje testy");
        saveTestCaseForm.click();
        return new TestBasePage(this.driver);
    }

    public TestBasePage addTestCaseSuccess() {

        return new TestBasePage(this.driver);
    }
}
