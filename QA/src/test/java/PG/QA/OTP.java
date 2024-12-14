package PG.QA;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OTP extends BaseTest{
	
	@BeforeClass
	public void EnterCardDetails() throws InterruptedException {
		pc=pm.clickPayByCard();
		otp=pc.InitiatePayment();
	}
	
	@Test
	public void EnterOTP() {
		otp.sendOTP();
	}
	
}
