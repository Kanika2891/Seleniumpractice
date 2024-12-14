package PG.QA;

import org.testng.Assert;
import org.testng.annotations.Test;

import pg.util.Constants;

public class PaymentMethod extends BaseTest {
	
	@Test(priority=0)
	public void VerifyPageHeader() {
		Assert.assertTrue(pm.isPageHeaderExist());
	}
	
	@Test(priority=1)
	public void VerifyMerchantInfo() {
		Assert.assertTrue(pm.isMerchantSectionExist());
	}
	
	@Test(priority=2)
	public void VerifyPaybyCarddisplayed() {
		Assert.assertTrue(pm.isPayByCardExist());
	}
	
	@Test(priority=3)
	public void VerifyBankTransferdisplayed() {
		Assert.assertTrue(pm.isBankTransferExist());
	}
	
	@Test(priority=4)
	public void PayByCardClick() {
		pc=pm.clickPayByCard();
		System.out.println(pc.getTitle());
		Assert.assertEquals(pc.getTitle(), Constants.PAY_BY_CARD_PAGE);
	}
}
