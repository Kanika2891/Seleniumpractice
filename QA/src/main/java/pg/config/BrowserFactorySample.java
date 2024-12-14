package pg.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactorySample {
	public static WebDriver doBrowserSetup(String browserName){

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")){
            //steup chrome browser
            WebDriverManager.chromedriver().setup();


            //Add options for --headed or --headless browser launch
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("-headed");
            chromeOptions.addArguments("--incognito");

            //initialize driver for chrome
            driver = new ChromeDriver(chromeOptions);

            //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }
        
   return driver;
}
}
