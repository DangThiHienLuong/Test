package I;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.AbtractPage;
import pageObject.DashboardPageObject;

public class DashboardTestcase extends DashboardPageObject {

	WebDriver driver;
	Select select;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert1;
	
	AbtractPage Abtract;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\libraries\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		action = new Actions(driver);
		driver.get("https://skills.kynaenglish.vn/");

	}
	@Test
	public void testcase_1() {
		Abtract.openPageURL(driver, LOGIN_EMAIL_TEXTBOX);
	}
}
