package rahulshetty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows_activities {
	
	WebDriver driver;
	@Test
	public void winodwActivities() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.navigate().to("https://rahulshettyacademy.com");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
	}
}
