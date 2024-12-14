package pg.config;

import org.openqa.selenium.WebDriver;

public class DriverFactorySample {

	private DriverFactorySample() {
		
	}
	
	private static DriverFactorySample instance=new DriverFactorySample();
	
	public static DriverFactorySample getInstance() {
		return instance;
	}
	
	 ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public void setDriver(WebDriver driverparam) {
		tlDriver.set(driverparam);	
	}
	public void closeBrowser() {
		tlDriver.get().close();
		tlDriver.remove();
	}
}
