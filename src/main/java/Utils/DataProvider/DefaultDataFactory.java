package Utils.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.DataProvider;
import java.io.File;


// Create various new object.
public class DefaultDataFactory
{
	@DataProvider(name = "variousData")
	public static Object[][] providerData() {
		return new Object[][]
				{{"administrator@testarena.pl","sumXQQ72$L"},{"data2-1","data2-2"}};

	}
}
