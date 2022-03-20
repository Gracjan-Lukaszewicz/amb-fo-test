package Core.Configuration.BaseConfiguration;

public interface BaseConfiguration {

    String getBaseProtocol();
    String getBaseURL();
    String getBaseAuthorizationUsername();
    String getBaseAuthorizationPassword();
    String getScreenshotType();
    String getScreenshotPath();
    String getChromeDriverPath();
    String getFirefoxDriverPath();
}
