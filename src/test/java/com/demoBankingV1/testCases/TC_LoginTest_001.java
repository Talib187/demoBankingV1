package com.demoBankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoBankingV1.pageObjects.loginPage;
import com.demoBankingV1.utilities.ReadConfig;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {

		loginPage lp = new loginPage(driver);

		lp.setUserName(readconfig.getUsername());

		logger.info("Entered Username");
		lp.setPassword(readconfig.getPassword());
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Click on login");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage1")) {

			Assert.assertTrue(true);
			logger.info("TC_LoginTest_001 Passed");
			// captureScreen(driver, "TC_LoginTest_001");
		}

		else {

			logger.info("TC_LoginTest_001 Failed"); // it needs to be written before below condition as after above
													// condition no statement will be executed;

			captureScreen(driver, "loginTest");

			Assert.assertTrue(false);

		}
	}

}
