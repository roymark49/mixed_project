package dropDown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAWebTable {

	WebDriver driver;
	String data = "Bangladesh";

	@Test(priority = 0)
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void captureTableData() {
		int rowCount = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr")).size();
		int columnCount = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr/th")).size();

		// table[@class='ws-table-all']/tbody/tr[2]/td[1]
		String xpathFirstPart = "//table[@class='ws-table-all']/tbody/tr[";
		String xpathSecondPart = "]/td[";
		String xpathThirdPart = "]";

		List<String> tableData = new ArrayList<String>();

		for (int i = 2; i <= rowCount; i++) {
			for (int j = 1; j <= columnCount; j++) {
				String eachData = driver
						.findElement(By.xpath(xpathFirstPart + i + xpathSecondPart + j + xpathThirdPart)).getText();

				if (eachData.equalsIgnoreCase(data)) {
					tableData.add(eachData);
					System.out.println("Data found in the table: " + eachData);
					System.out.println("row " + i + " column " + j);
					break;
				}
			}
 
		}

		if (tableData.size() <= 0) {
			System.out.println("No data found");
		}
//		if (tableData.contains(data)) {
//			System.out.println("Data found in the table");
//		} else {
//			System.out.println("Data not found in the table");
//		}

	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
