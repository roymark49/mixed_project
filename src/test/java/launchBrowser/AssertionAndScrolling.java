package launchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionAndScrolling extends CaptureAutoSuggetionList {
	WebDriver driver;


	@Test
	public void browserHistory() {
		driver = init();
		scrolling();
		
	}

	public void scrolling() {
		WebElement searchBarElement = driver.findElement(By.xpath("//input[@id='search2']"));
		searchBarElement.sendKeys("java");

		searchBarElement.sendKeys(Keys.ENTER);

		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);

		// Assertion
		Assert.assertEquals(PageTitle, "JavaScript Tutorial", "wrong page");

		// Scroll Down

		WebElement quizTestElement = driver.findElement(By.xpath("//h2[text()='JavaScript Quiz Test']"));
		Point point = quizTestElement.getLocation();
		int pointY = point.getY();

		System.out.println(pointY);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,3000)");
		js.executeScript("arguments[0].scrollIntoView()", quizTestElement);// so that element gets fully visible

		String text = quizTestElement.getText();
		System.out.println(text);

		driver.findElement(By.xpath("//a[text()='Start JavaScript Quiz!']")).click();

		String PageTitle2 = driver.getTitle();
		System.out.println(PageTitle2);

		// Assertion
		Assert.assertEquals(PageTitle2, "JavaScript Quiz", "wrong page");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");// Scroll to the bottom

		js.executeScript("window.scrollTo(0,0)");
	}
}
