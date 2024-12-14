package PG.QA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class E2E_BankTransfer extends BaseTest{

	@Test(priority=1)
	public void isBankTransferEnable() {
		pm.isBankTransferExist();
	}
	
	@Test(priority=2)
	public void ClickBankTransfer() {
		bt=pm.clickBankTransfer();
	}
	
	@Test(priority=3)
	public void InitiatePayment() throws InterruptedException {
		confirm=bt.StatusCall();
	}
	
	@Test(priority=4)
	public void VerifySuccessPage() {
		String success=confirm.verifyTitle();
		Assert.assertTrue(success.equals("Payment Successful"));
		System.out.println("Transaction Completed");
	}
}
