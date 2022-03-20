package Configuration.BaseConfiguration;

import Core.Configuration.BaseConfiguration.AbstractBaseConfiguration;
import Core.Configuration.BaseConfiguration.BaseConfiguration;

public class DefaultBaseConfiguration extends AbstractBaseConfiguration implements BaseConfiguration
{
    public DefaultBaseConfiguration()
    {

        baseProtocol = "http://";
        baseURL = "demo.testarena.pl/zaloguj";

        baseAuthorizationUsername = "T4ren4";
        baseAuthorizationPassword = "ta20!&r3NA";

        screenshotType = "png";
        screenshotPath = "screenshot/screenshot";

        chromeDriverPath = "../drivers/chromedriver.exe";
        firefoxDriverPath = "../drivers/geckodriver.exe";

    }

    @Override
    public String getBaseProtocol() {
        return this.baseProtocol;
    }

    @Override
    public String getBaseURL() {
        return this.baseURL;
    }

    @Override
    public String getBaseAuthorizationUsername() {
        return this.baseAuthorizationUsername;
    }

    @Override
    public String getBaseAuthorizationPassword() {
        return this.baseAuthorizationPassword;
    }

    @Override
    public String getScreenshotType() {
        return this.screenshotType;
    }

    @Override
    public String getScreenshotPath() {
        return this.screenshotPath;
    }

    @Override
    public String getChromeDriverPath() {
        return this.chromeDriverPath;
    }

    @Override
    public String getFirefoxDriverPath() {
        return this.firefoxDriverPath;
    }
}
