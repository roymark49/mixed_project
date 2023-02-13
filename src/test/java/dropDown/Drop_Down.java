package dropDown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop_Down {

	WebDriver driver;

	@Test(priority = 0)
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test(enabled = false)
	public void captureDropdownOption() {

		driver.findElement(By.xpath("//select[@name='url']")).click();

		List<String> captureAll = new ArrayList<String>();
		List<WebElement> capture = driver.findElements(By.xpath("//option[starts-with(@value,'search-alias')]"));

		for (WebElement allOptions : capture) {

			captureAll.add(allOptions.getText());
		}
		System.out.println(captureAll);

	}
@Test(enabled = false)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
