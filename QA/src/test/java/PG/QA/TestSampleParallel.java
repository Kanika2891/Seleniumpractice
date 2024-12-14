package PG.QA;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pg.config.DriverFactory;
import pg.pages.BankTransfer_Page;
import pg.pages.OTP_Page;
import pg.pages.PayByCard_Page;
import pg.pages.PaymentConfirm_Page;
import pg.pages.PaymentMethod_Page;
import pg.util.Constants;
import pg.util.ExcelUtil;

public class TestSampleParallel {

	WebDriver driver;
	DriverFactory df;
	PaymentMethod_Page pm;
	PayByCard_Page pc;
	BankTransfer_Page bt;
	OTP_Page otp;
	PaymentConfirm_Page confirm;


	@Test(dataProvider="getData")
	public void setUp(String url) throws InvalidFormatException {
		System.out.println("Inside base test");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println(url);
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws InvalidFormatException {
		Object readdata[][]=ExcelUtil.getTestData("URL");
		return readdata;
		
	}
}
