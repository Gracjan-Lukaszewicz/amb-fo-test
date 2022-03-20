package Utils.Screenshot;

import Core.Configuration.BaseConfiguration.BaseConfiguration;
import Core.Utils.DefaultScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot extends DefaultScreenshot
{
    public Screenshot(WebDriver driver, BaseConfiguration baseConfiguration) {
        super(driver, baseConfiguration);
    }

    public void makeScreenshot()
    {
        if (baseConfiguration.getScreenshotType().equals(pngType))
        {
            makePngScreenshot();
        }
        else
        {
            makePngScreenshot();
        }
    }
}
