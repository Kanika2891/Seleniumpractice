package PG.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadowdom1 {
	
	WebDriver driver;
	
	@BeforeTest
	public void browser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("http://watir.com/examples/shadow_dom.html");
	}
	
	@Test
	public void ShadowdomSet1() {
		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		SearchContext shadowRoot = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot", shadowHost);
		//WebElement shadowContent = shadowRoot.findElement(By.cssSelector("#shadow_content"));

		WebElement shadowHost1 = shadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
		SearchContext shadowRoot1 = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot", shadowHost1);
		WebElement nestedShadowContent = shadowRoot1.findElement(By.cssSelector("#nested_shadow_content"));


		System.out.println(nestedShadowContent.getText());
	}
}
