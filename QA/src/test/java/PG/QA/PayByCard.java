package PG.QA;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PayByCard extends BaseTest{

	@BeforeClass
	public void ClickPayByCard() {
		pc=pm.clickPayByCard();
	}
	
	@Test(priority=0)
	public void VerifyPayButtonisDisabled() {
		Assert.assertFalse(pc.isPayButtonEnabled());
	}
	
	@Test(priority=1)
	public void VerifySaveCheckboxisNotSelected() {
		Assert.assertFalse(pc.isSaveCardButtonSelected());
	}
	
	@Test(priority=2, enabled=false)
	public void InitiatePayment() throws InterruptedException {
		pc.InitiatePayment();
	}
	
	@Test(priority=2, enabled=true,dataProvider="getTestData")
	public void InitiatePaymentFromExcel(String cardNum,String exp,String cvv_in,String pin_in) throws InterruptedException {
		pc.InitiatePaymentFromExcel(cardNum,exp,cvv_in,pin_in);
	}
}
