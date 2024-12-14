package PG.QA;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class E2E_PayByCard extends BaseTest {
	
	@Test(priority=1)
	public void isPayByCardEnable() {
		pm.isPayByCardExist();
	}
	
	@Test(priority=2)
	public void ClickPayByCard() {
		pc=pm.clickPayByCard();
	}
	
	@Test(priority=3)
	public void InitiatePayment() throws InterruptedException {
		otp=pc.InitiatePayment();
	}
	
	@Test(priority=4)
	public void EnterOTP() {
		confirm=otp.sendOTP();
	}
	
	@Test(priority=5)
	public void VerifySuccessPage() {
		String success=confirm.verifyTitle();
		Assert.assertTrue(success.equals("Payment Successful"));
		System.out.println("Transaction Completed");
	}
}
