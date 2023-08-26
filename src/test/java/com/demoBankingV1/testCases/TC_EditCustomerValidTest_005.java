package com.demoBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoBankingV1.pageObjects.EditCustomerPage;
import com.demoBankingV1.pageObjects.loginPage;

public class TC_EditCustomerValidTest_005 extends BaseClass {

	@Test
	public void editCustomerValid() throws IOException, InterruptedException {

		loginPage lp = new loginPage(driver);
		lp.setUserName(readconfig.getUsername());
		logger.info("Provided username");
		lp.setPassword(readconfig.getPassword());
		logger.info("Provided password");
		lp.clickSubmit();
		logger.info("User logged in successfully");

		EditCustomerPage editCust = new EditCustomerPage(driver);

		editCust.clickEditCst();

//		String custId = randomNumber();

		editCust.enterCustID("70469");
		System.out.println(75606);
		logger.info("Entered valid cusstomer id");

		editCust.clickSubmit();

		if (isAlertPresent() == true) {

			captureScreen(driver, "editCustoer");
			if (driver.switchTo().alert().getText().equals("You are not authorize to edit this customer!!")) {

				System.out.println("Popup says:" + driver.switchTo().alert().getText());

				driver.switchTo().alert().accept();

				Assert.assertTrue(false);
				logger.info("Invalid customer ID.");
			}

			else {
			
				System.out.println("Title of the page:" +driver.getTitle());
				Assert.assertTrue(true);
				
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
