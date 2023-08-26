package com.demoBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoBankingV1.pageObjects.EditCustomerPage;
import com.demoBankingV1.pageObjects.loginPage;

public class TC_EditCustomerTest_004 extends BaseClass {

	@Test
	public void editCustoer() throws IOException, InterruptedException {

		loginPage lp = new loginPage(driver);
		lp.setUserName(readconfig.getUsername());
		logger.info("Provided username");
		lp.setPassword(readconfig.getPassword());
		logger.info("Provided password");
		lp.clickSubmit();
		logger.info("User logged in successfully");

		EditCustomerPage editCust = new EditCustomerPage(driver);

		editCust.clickEditCst();

		String custId = randomNumber();
		editCust.enterCustID(custId);
		System.out.println(custId);

		editCust.clickSubmit();

		if (isAlertPresent() == true) {

			if (driver.switchTo().alert().getText().equals("You are not authorize to edit this customer!!")) {
				
				System.out.println("Popup says:" + driver.switchTo().alert().getText());

				driver.switchTo().alert().accept();

				Assert.assertTrue(true);
				logger.info("Invalid customer ID.");
			}

			else {
				captureScreen(driver, "editCustoer");
				Assert.assertTrue(false);
			}
		}

	}

	public boolean isAlertPresent() {

		try {

			driver.switchTo().alert();

			return true;
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
		}
		return false;
	}

}
