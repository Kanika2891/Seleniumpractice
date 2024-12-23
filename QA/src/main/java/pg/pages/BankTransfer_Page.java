package pg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pg.util.API;
import pg.util.Constants;
import pg.util.ElementUtil;

public class BankTransfer_Page {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By confirmbutton=By.xpath("//p[text()='I have made this payment']");

	public BankTransfer_Page(WebDriver driver) {
		this.driver = driver;	
		eleUtil=new ElementUtil(driver);	
		}
	
	public String getTitle() {
		return eleUtil.doGetPageTitleIs(Constants.BANK_TRANSFER_PAGE, Constants.DEFAULT_TIMEOUT);
	}
	
	public PaymentConfirm_Page StatusCall() {
		eleUtil.doClick(confirmbutton);
		System.out.println("API targetted");
		return new PaymentConfirm_Page(driver);

	}
}
