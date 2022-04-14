package test;

import Core.Tests.DefaultTest;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.ListenerTest.class)
public class Go3Test extends DefaultTest {

	private static final Logger logger = LogManager.getLogger(Go3Test.class.getName());

	@Test
	public void logIn() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		driver.get("https://go3.lv/");
		go3LoggingPage.waitForClickableElement(go3LoggingPage.userIcon);
		driver.manage().window().maximize();

		go3LoggingPage.clickLoginButton().loginToGo3Page();

		driver.quit();

	}

	@Test
	public void swichAdult() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		driver.get("https://go3.lv/");
		go3LoggingPage.waitForClickableElement(go3LoggingPage.userIcon);
		driver.manage().window().maximize();

		go3LoggingPage.clickKids().clickAdult().assertSubscribeButton();

	}

}
