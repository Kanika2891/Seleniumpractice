package PG.QA;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pg.config.DriverFactory;
import pg.pages.BankTransfer_Page;
import pg.pages.OTP_Page;
import pg.pages.PayByCard_Page;
import pg.pages.PaymentConfirm_Page;
import pg.pages.PaymentMethod_Page;
import pg.util.API;
import pg.util.Constants;
import pg.util.ExcelUtil;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	PaymentMethod_Page pm;
	PayByCard_Page pc;
	BankTransfer_Page bt;
	OTP_Page otp;
	PaymentConfirm_Page confirm;
	//SoftAssert softAssert;

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws InvalidFormatException {
		df = new DriverFactory();
		driver=df.setupDriver(browser);
		pm = new PaymentMethod_Page(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
