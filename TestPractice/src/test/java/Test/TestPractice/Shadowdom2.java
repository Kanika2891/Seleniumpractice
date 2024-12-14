package Test.TestPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadowdom2 {
	
	WebDriver driver;
	String text="Sample";
	int loop=0;
	/*
	 1. Navigate to the URL :
https://fiddle.luigi-project.io/#/home/wc1
2. Send text to “new list item” textbox
3. Click on + icon 
4. Validate if the text is entered or not */
	
	@BeforeTest
	public void browser() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

	driver.get("https://fiddle.luigi-project.io/#/home/wc1");	
	}
	
	@Test
	public void ShadowdomSet2() {
		WebElement shadowHost = driver.findElement(By.cssSelector("luigi-wc-68747470733a2f2f666964646c652e6c756967692d70726f6a6563742e696f2f77632f6c6973742e6a73[lui_web_component='true']"));
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		SearchContext shadowRoot = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot", shadowHost);

		WebElement shadowHost1 = shadowRoot.findElement(By.cssSelector("input[class='add-new-list-item-input']"));
		shadowHost1.sendKeys(text);
		WebElement shadowHost2 = shadowRoot.findElement(By.cssSelector("button[class='editable-list-add-item icon']"));
		shadowHost2.click();
		List<WebElement> list = shadowRoot.findElements(By.cssSelector("li[class='item-list-element']"));

		for (int i=0; i<list.size();i++){
			String a=list.get(i).getText();			
			if(a.contains(text)) {
			System.out.println("Text is present");
			loop=1;
			}	
		}
			
		if(loop==0)
			System.out.println("Text is absent");
	}
	
	@AfterTest
	public void exit() {
		driver.quit();
	}
	
}
