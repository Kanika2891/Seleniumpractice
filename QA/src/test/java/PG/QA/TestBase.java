package PG.QA;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	pg.config.DriverFactory df;

	@Test
	public void beforeMethodMethod() {
		df = new pg.config.DriverFactory();
		setupDriver("chrome");
		driver.get("https://qa-gateway.hydrogenpay.com?transactionId=11a70000-89e4-aee5-7fc2-08dba2fcc7c1");
		
	}
	
	/*
	@BeforeTest
	public void beforeTestMethod() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "reports" + File.separator + "TestReport.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("UserName", "root");
		spark.config().setDocumentTitle("AutomationReport");
		spark.config().setReportName("Automation Test Results");
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser, Method testMethod) {
		df = new pg.config.DriverFactory();
		logger = extent.createTest(testMethod.getName());
		setupDriver("chrome");
		driver.get("https://qa-gateway.hydrogenpay.com?transactionId=11a70000-89e4-aee5-7fc2-08dba2fcc7c1");
		
	}

	@AfterMethod
	public void afterMethodMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " -  TC Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " -  TC Failed", ExtentColor.RED));
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " -  TC Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " -  TC Skipped", ExtentColor.GREEN));
		}
		driver.quit();
	}

	@AfterTest
	public void afterTestMethod() {
		extent.flush();
	} */

	public void setupDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
}