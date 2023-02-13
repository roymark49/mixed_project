package launchBrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureAutoSuggetionList {

	WebDriver driver;

	@Test(priority = 0)
	public WebDriver init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;

	}
	@Test(enabled = false) // if you want to disable it "enabled = false"
	public void tearDown() {  
		driver.close();
		driver.quit();
	}
	@Test(priority = 1)
	public void showSearchsuggetion() {
		WebElement searchBarElement = driver.findElement(By.xpath("//input[@id='search2']"));
	 
		searchBarElement.sendKeys("java");
		
		//(//div[@id='listofsearchresults']/a)[]
		
		String xpathFirstPart = "(//div[@id='listofsearchresults']/a)[";
		String xpathSecondPart = "]";
		
		List<String> textList = new ArrayList <String>();
		 for(int i = 1; i<8; i++) {
			String text = driver.findElement(By.xpath(xpathFirstPart + i + xpathSecondPart)).getText();
			textList.add(text);
		}
		System.out.println(textList);
		
		//List<WebElement> elementList = driver.findElements(By.xpath("(//div[@id='listofsearchresults']/a)[]"));
		
//		for(WebElement list : elementList) {
//			textList.add(list.getText());
//			
//		}
//		
//		System.out.println(textList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
