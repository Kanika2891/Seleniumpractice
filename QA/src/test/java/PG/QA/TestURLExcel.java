package PG.QA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pg.util.ExcelUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pg.util.ExcelUtil;


public class TestURLExcel {
	public static void main(String[] args) {
		
		ExcelUtil readdata=new ExcelUtil();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		  driver.manage().window().maximize();

		driver.get(readdata.readData("URL").get(0));
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
driver.findElement(By.xpath("//div[text()='Pay by card']")).click();
	}

}