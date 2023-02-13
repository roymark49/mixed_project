package dropDown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicTable {
	
	WebDriver driver;
	@Test(priority = 0)
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	@Test(priority = 1)
	public void handlingDynamicTable() {
		int tableColumn = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th")).size();
		System.out.println("Number of column " + tableColumn);
		int tableRow = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		System.out.println("Number of tableRow " + tableRow );
		
		String thirdRowSecondCellData = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td[3]")).getText();
		System.out.println("Third Row third cell Data of the table: " + thirdRowSecondCellData );
		
		List<Float> tableList = new ArrayList<Float>();
		for(int i = 0; i<tableRow; i++) {
			String tableData = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]")).get(i).getText();
			float tableDataAsFloat = Float.parseFloat(tableData);
			
			tableList.add(tableDataAsFloat);
		}
		System.out.println("Before sorting: " + tableList);
		//Sorting the arrayList in ascending order using "Collections.sort method. 
		Collections.sort(tableList);
		System.out.println("Ascending Order: " + tableList);
		////Sorting the arrayList in descending order using "Collections.reverseOrder()" method.
		Collections.sort(tableList,Collections.reverseOrder());
		System.out.println("Descending order: " + tableList);
		// Finding the maximum: 
		System.out.println("Maximum current price is: " + tableList.get(0));
	}
	
	@Test(enabled = false)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
