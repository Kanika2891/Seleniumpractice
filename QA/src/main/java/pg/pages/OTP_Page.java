package pg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pg.util.ElementUtil;

public class OTP_Page {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public OTP_Page(WebDriver driver) {
		this.driver = driver;	
		eleUtil=new ElementUtil(driver);	
		}
	
	private By otp=By.xpath("//input[@aria-label='Please enter OTP character 1']");
	private By back=By.xpath("//span[text()='Back']");
	private By submit=By.xpath("//p[text()='Submit']");


	
	public void sendOTPExcel(String OTP) {
		eleUtil.doSendKeys(this.otp, OTP);
	}
	
	public PaymentConfirm_Page sendOTP() {
		System.out.println("otp page");
		eleUtil.doSendKeys(otp, "123456");
		eleUtil.doClick(submit);
		return new PaymentConfirm_Page(driver);
		
	}
}
