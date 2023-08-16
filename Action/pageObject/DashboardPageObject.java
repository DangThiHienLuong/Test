package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUI.DashboardUI;
//Khai báo
public class DashboardPageObject extends DashboardUI {
	WebDriver driver;
	WebElement element;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;	
	JavascriptExecutor jsExecutor;
	
	public void CustomerDropdown(String parentLocator, String itemLocator, String expectedItem)
			throws InterruptedException {

		long timeOutInSeconds = 0;
		// 1- Click vào 1 thẻ bất kì để sổ ra hết tất cả các item trong dropdown ra
		explicitWait = new WebDriverWait(driver, timeOutInSeconds);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(parentLocator)));
		driver.findElement(By.xpath(parentLocator)).click();

		// 2- Chờ cho tất cả item được có trong html dom
				explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemLocator)));

				// 3- Lấy hết tất cả các item này đưa vào 1 lít element
				List<WebElement> allItems = driver.findElements(By.xpath(itemLocator));

				// Tổng số lượng item trong 1 dropdown bằng bao nhiêu
				System.out.println("Item size=" + allItems.size());

				// 4- Duyệt qua từng item
				for (WebElement item : allItems) {
					// toLowercase: chuyển sang chữ thường
					String actualItem = item.getText();
					System.out.println(actualItem);

					// Nếu như mà bằng thì click vào và thoát khoải, không cần duyệt nữa
					// Nếu như không bằng thì lại duyệt tiếp cho đến hết tất cả item
					jsExecutor = (JavascriptExecutor) driver;
					if (actualItem.trim().equals(expectedItem)) {
						// Trước khi click thì nên scroll đến element
//						jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
//						Thread.sleep(2000);
						// Wait for element clickable
						explicitWait.until(ExpectedConditions.elementToBeClickable(item));
						item.click();
						Thread.sleep(1000);
						break;
			}
		}
	}
//	public Object verifyURL() {
//		getTitlePage(driver);
//		return null;
//	}
//	public void verifyURL(WebDriver driver, String email) {
//		openPageURL(driver, LOGIN_EMAIL_TEXTBOX);
//	}
	
}
