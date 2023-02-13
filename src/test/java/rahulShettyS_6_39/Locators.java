package rahulShettyS_6_39;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	@Test(enabled = false)
	public void locateElements() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElement(By.id("inputUsername")).sendKeys("roymark49");
		driver.findElement(By.name("inputPassword")).sendKeys("abc123");   
		driver.findElement(By.cssSelector("button.submit")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mark Roy");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("roymark49@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("616-334-8739");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//36 number line will fail because of timeout issue. (element click intercepted exception) sliding is in process so it co uld click. 
		System.out.println(	driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("roymark");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//p")).getText());
		driver.findElement(By.cssSelector("button.logout-btn")).click();

		
	}
	WebDriver driver;
	@Test(priority = 0)
	public void experiment() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys("roymark49");
		driver.findElement(By.name("inputPassword")).sendKeys(password);   
		driver.findElement(By.cssSelector("button.submit")).click(); 
	}
	@Test(enabled = false)
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String msg = driver.findElement(By.xpath("//*[text()=\"Please use temporary password 'rahulshettyacademy' to Login.\"]")).getText();
		Assert.assertEquals(msg, "Please use temporary password 'rahulshettyacademy' to Login.");
		String[] passwordArray = msg.split("'");
		String password = passwordArray[1].split("'")[0];
		
		return password;
		
		
		
		
		
		
	}
	
}
