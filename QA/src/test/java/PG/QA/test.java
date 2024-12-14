package PG.QA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

    public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		  driver.manage().window().maximize();

		driver.get("https://qa-app.hydrogenpay.com/login?portal=merchant");
		  
			/*
			 * Actions actions = new Actions(driver); actions.keyDown(Keys.CONTROL);
			 * actions.sendKeys("t"); actions.build().perform();
			 */
		  driver.findElement(By.id("emailAddress")).sendKeys("kevincostner@mailinator.com");
		  driver.findElement(By.id("password")).sendKeys("zvwdAYT#0634");
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  driver.manage().timeouts();
		  driver.findElement(By.className( "text-white m-0 flex flex-col items-center p-0 font-Poppins text-[10px] font-normal leading-3")).sendKeys("1");
		//  driver.findElement(By.xpath("//span[text()='HydrogenPay']")).click();
		  driver.findElement(By.linkText("Create Payment Links ")).click();

		  driver.findElement(By.name("customerName")).sendKeys("kanika");
driver.findElement(By.className("focus:border-[#EFF1F3] focus:ring-0 outline-offset-0 focus:outline-gray-700 focus:outline-0 outline-0 outline-current w-full h-[48px] rounded-[4px] bg-[#F9F9F9] border border-solid border-[#EFF1F3] pl-[60px] placeholder:text-[#D0D0D0] text-[14px] font-Poppins font-normal leading-[21px]")).sendKeys("1");



		  driver.switchTo().newWindow(WindowType.TAB);
		  
	}

}
