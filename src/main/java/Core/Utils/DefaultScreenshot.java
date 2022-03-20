package Core.Utils;

import Core.Configuration.BaseConfiguration.BaseConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public abstract class DefaultScreenshot
{
    public static String after_method = "after_method";
    public static String afterFail_method = "afterFail_method";
    public static String before_after_method = "before_after_method";
    public static String before_afterFail_method = "before_afterFail_method";

    public static String pngType = "png";

    protected WebDriver driver;
    protected BaseConfiguration baseConfiguration;

    public DefaultScreenshot(WebDriver driver, BaseConfiguration baseConfiguration)
    {
        this.driver = driver;
        this.baseConfiguration = baseConfiguration;
    }

    protected void makePngScreenshot() {
        makeScreenShot(pngType);
    }

    private void makeScreenShot(String fileType) {
        String getPath = new File(baseConfiguration.getScreenshotPath()).getAbsolutePath();
        File filePath = new File(getPath + new Date().getTime() + "." + fileType);

        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screenFile, filePath);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
