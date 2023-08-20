package com.demoBankingV1.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoBankingV1.pageObjects.AddCustomerPage;
import com.demoBankingV1.pageObjects.loginPage;
import com.demoBankingV1.utilities.ReadConfig;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test

	public void addNewCustomer() throws InterruptedException, IOException {

		loginPage lp = new loginPage(driver);

		lp.setUserName(readconfig.getUsername());
		logger.info("Provided username");
		lp.setPassword(readconfig.getPassword());
		logger.info("Provided password");

		lp.clickSubmit();

		Thread.sleep(2000);

		AddCustomerPage addCust = new AddCustomerPage(driver);

		addCust.clickAddCust();

		logger.info("Providing customer details");

		Thread.sleep(5000);

		addCust.enterName("Mohammad Talib");
		addCust.selGender("Male");
		addCust.selDOB("10", "15", "1994");

		Thread.sleep(2000);

		addCust.addCustAddress("Char Yaar Road");
		addCust.addCustCity("Bulandshahr");
		addCust.addCustState("Uttar Pradesh");
		addCust.addCustPin("203001");
		// addCust.addCustMobile("9989898989");

		String mobile = randomNumber();
		addCust.addCustMobile(mobile);

		// addCust.addCustEmail("talib@yopmail.com");

		String email = randomEmail() + "@gmail.com";
		addCust.addCustEmail(email);
		addCust.addCustPassword("Pass@12345");
		addCust.clickSubmit();

		logger.info("Validation started");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (result == true) {

			Assert.assertTrue(true);

			logger.info("TC_AddCustomerTest_003 passed");
		} else {
			captureScreen(driver, "addNewCustomer");
			logger.info("Customer info submission failed");
			Assert.assertTrue(false);
		}

	}

}
