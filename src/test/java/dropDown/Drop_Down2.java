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

public class Drop_Down2 {

	WebDriver driver;

	@Test(priority = 0)
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void captureDropdownOption() {

		WebElement countryList = driver.findElement(By.xpath("//select[@name='country']"));
		countryList.click();
		Select select = new Select(countryList);
		select.selectByVisibleText("UNITED STATES");
		
		List<WebElement> allOptions = select.getOptions();
		
		List<String> allCountryNames = new ArrayList<String>();
		
		for(WebElement options:allOptions) {
			allCountryNames.add(options.getText());
		}
		System.out.println(allOptions);
		
		

	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
