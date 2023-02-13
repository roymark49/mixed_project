package propertiesfile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Properties_file {
	
	WebDriver driver;
	String urlFromPropertiesFile;
	String browserFromPropertiesFile;

	@Test(priority = 0)
	public void readPropertiesFile() throws Exception {

		InputStream path = new FileInputStream("src/test/java/data/testData.properties");

		Properties prop = new Properties();
		prop.load(path);

		urlFromPropertiesFile = prop.getProperty("url");
		browserFromPropertiesFile = prop.getProperty("browser");

	}

	@Test(priority = 1)
	public void init() {
		
		
		ChromeOptions options = new ChromeOptions();
		
		//to run the browser in headless mode
		options.setHeadless(true);
		
		//to disable the information bar of chrome browser
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); 

		if (browserFromPropertiesFile.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.get(urlFromPropertiesFile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test(priority= 2)
	public void handlePopUpWindow() throws Exception {

		
		//driver.findElement(By.linkText("Sign in")).click();
		
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@name='callout']"));
		
		driver.switchTo().frame(iFrame);
		
		driver.findElement(By.xpath("//button[@aria-label='No thanks']")).click();
		
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Toyota Car");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement jsElement = driver.findElement(By.xpath("//h3[text()='Vehicle Gallery | Toyota Brand | Mobility']"));
		
		//force click on the webelement to avoid clickInterceptedException
		//js.executeScript("arguments[0].click()", jsElement);
		
		//System.out.println(jsElement.getLocation().getY());
		
		//scrolling using x and y coordinates
		js.executeScript("window.scrollTo(0,2200)");
		jsElement.click();
		
		
	}

	@Test(priority = 3)
	public void tearDown() {
		//driver.close();
		//driver.quit();
	}
		
		
		
	
}
