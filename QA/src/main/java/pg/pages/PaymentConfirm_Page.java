package pg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pg.util.ElementUtil;

public class PaymentConfirm_Page {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public PaymentConfirm_Page(WebDriver driver) {
		this.driver = driver;	
		eleUtil=new ElementUtil(driver);	
		}
	
	private By success=By.xpath("//p[text()='Payment Successful']");

	public String verifyTitle() {
		eleUtil.waitForElementVisible(success, 80);
		return eleUtil.doGetText(success);
	}
	
}
