package rahul_DropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	WebDriver driver;
	
	@Test(priority = 0)
	public void dropDown() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(staticDropDown);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByIndex(1);
		
		
		
		
		
		
		
	}
	
}
