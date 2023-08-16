package Common;

import org.openqa.selenium.WebDriver;

public class AbtractPage {

	public static void openPageURL( WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}
}
