package com.demoBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoBankingV1.pageObjects.loginPage;
import com.demoBankingV1.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {

	//	String path = System.getProperty("user.dir" + "/src/test/java/com/demoBankingV1/testData/LoginData.xlsx");
		
		String path = "C:\\Users\\mtali\\eclipse-workspace\\demoBankingV1\\src\\test\\java\\com\\demoBankingV1\\testData\\LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colCount];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colCount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) throws IOException {

		loginPage lp = new loginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
	
		lp.setPassword(password);
		logger.info("Passwrod entered");
		lp.clickSubmit();
		logger.info("Clicked on submit");

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept(); // will not login
			logger.info("Invalid credentials");
			logger.warn("Login failure");
			captureScreen(driver, "loginDDT");
			driver.switchTo().defaultContent();

			Assert.assertTrue(false);

		}

		else {

			Assert.assertTrue(true);
			logger.info("Valid Credentials");
			
			lp.clickLogOut();
			
			logger.info("User Logged out");

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() {

		// So basically this will check if alert is there then will give true or false
		// accordingly.
		// We are doing because if login is invalid, a popup will appear and we can
		// validate that credential are invaid.

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {

			return false;
		}

	}

}
