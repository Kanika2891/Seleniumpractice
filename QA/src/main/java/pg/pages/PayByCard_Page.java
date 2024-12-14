package pg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pg.util.Constants;
import pg.util.ElementUtil;

public class PayByCard_Page {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By cardnumber=By.name("cardNumber");
	private By expiry=By.name("expiryDate");
	private By cvv=By.name("CVV");
	private By pin=By.name("PIN");
	private By paybutton=By.xpath("//div/button/span[@class='font-Poppins transition font-semibold text-sm']");
	private By savecard=By.id("saveCard");
	private By viewsavedcard=By.xpath("//div[text()='View saved cards']\")");
	
	public PayByCard_Page(WebDriver driver) {
		this.driver = driver;	
		eleUtil=new ElementUtil(driver);
	}
	
	public String getTitle() {
		return eleUtil.doGetPageTitleIs(Constants.PAY_BY_CARD_PAGE, Constants.DEFAULT_TIMEOUT);
	}
	
	public boolean isPayButtonEnabled() {
		return eleUtil.doIsEnabled(paybutton);
	}
	
	public boolean isSaveCardButtonSelected() {
		return eleUtil.doIsSelected(savecard);
	}
	
	public OTP_Page InitiatePayment() throws InterruptedException {
		eleUtil.doSendKeys(cardnumber, "5060990580000217499");
		eleUtil.doSendKeys(expiry, "03/50");
		eleUtil.doSendKeys(cvv, "111");
		eleUtil.doSendKeys(pin, "1111");
		eleUtil.waitForElementVisible(paybutton, 20);
		eleUtil.doClick(paybutton);
		return new OTP_Page(driver);
	}
	
	public OTP_Page InitiatePaymentFromExcel(String cardNum,String exp,String cvv_in,String pin_in) {
		eleUtil.doSendKeys(cardnumber, cardNum);
		eleUtil.doSendKeys(expiry, exp);
		eleUtil.doSendKeys(cvv, cvv_in);
		eleUtil.doSendKeys(pin, pin_in);
		eleUtil.doClick(paybutton);
		return new OTP_Page(driver);
	}

}
