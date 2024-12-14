package pg.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import pg.util.API;
import pg.util.Constants;
import pg.util.ExcelUtil;

public class DriverFactory {
	public static WebDriver driver;
	public static String highlight="true";
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal();
	API geturl;
	String URL;
	public String transRef;

	ChromeOptions co = new ChromeOptions();
	EdgeOptions eo = new EdgeOptions();



	/*
	 * DriverFactory class is responsible to initialize a driver with method
	 * setupDriver. Give the browser name and it will return the driver.
	 */

	public WebDriver setupDriver(String browser) throws InvalidFormatException {
		

		System.out.println("browser : "+ browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache();
			WebDriverManager.chromedriver().setup();
		//	co.addArguments("incognito");
			driver = new ChromeDriver();
			tlDriver.set(driver);
	        System.out.println("Chrome Test Thread ID: "+Thread.currentThread().getId());


		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			eo.addArguments("incognito");
			driver = new EdgeDriver(eo);
			tlDriver.set(driver);
	        System.out.println("Edge Test Thread ID: "+Thread.currentThread().getId());

		}
		
		geturl= new API();
		List<String> data=geturl.getUrl();
		URL=data.get(1);
		transRef=data.get(0);
		System.out.println("transac ref in DF is "+transRef);


		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().navigate().to(URL);
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();
	}
	
	/**
	 * this will return the thread local copy of the driver
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
