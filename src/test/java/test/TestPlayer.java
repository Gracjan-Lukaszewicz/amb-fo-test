package test;

import Core.Tests.DefaultTest;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestPlayer extends DefaultTest {

	private static final Logger logger = LogManager.getLogger(Go3Test.class.getName());

	@Test
	public void playTrailer() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		driver.get("https://player.pl/");
		driver.manage().window().maximize();

		playerLandingPage.search().selectProduct().playTrailer();
	}

}
