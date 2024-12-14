package pg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pg.util.Constants;
import pg.util.ElementUtil;

public class PaymentMethod_Page {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By pageheader=By.xpath("//div[text()='Payment Request']");
	private By merchantsection=By.xpath("//*[@class='flex items-center ml-4']");
	private By paycard=By.xpath("//div[text()='Pay by card']");
	private By banktransfer=By.xpath("//div[text()='Bank transfer']");
	
	
	public PaymentMethod_Page(WebDriver driver) {
		
		this.driver = driver;	
		eleUtil=new ElementUtil(driver);
	}

	public boolean isPageHeaderExist() {
		return eleUtil.doIsDisplayed(pageheader);
	}
	
	public boolean isMerchantSectionExist() {
		return eleUtil.doIsDisplayed(merchantsection);
	}
	
	public boolean isBankTransferExist() {
		return eleUtil.doIsDisplayed(banktransfer);
	}
	
	public boolean isPayByCardExist() {
		return eleUtil.doIsDisplayed(paycard);
	}
	
	public PayByCard_Page clickPayByCard() {
		eleUtil.doClick(paycard);
		return new PayByCard_Page(driver);
	}
	
	public BankTransfer_Page clickBankTransfer() {
		eleUtil.doClick(banktransfer);
		return new BankTransfer_Page(driver);
	}
}
