package com.demoBankingV1.pageObjects;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoBankingV1.testCases.BaseClass;

public class EditCustomerPage extends BaseClass {

	WebDriver ldriver;

	public EditCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Edit Customer']")
	@CacheLookup
	WebElement btnEditCst;

	@FindBy(name = "cusid")
	@CacheLookup
	WebElement txtCustID;

	@FindBy(name = "AccSubmit")
	@CacheLookup
	WebElement btnSubmit;

	public void clickEditCst() throws InterruptedException {

		btnEditCst.click();
		Thread.sleep(2000);
		ldriver.navigate().refresh();
		ldriver.get("https://demo.guru99.com/v3/manager/EditCustomer.php");
		logger.info("Clicked on Edit Customer");
	}

	public void enterCustID(String custID) {

		txtCustID.sendKeys(custID);
		//logger.info("Entered invalid customer ID.");
	}

	public void clickSubmit() {

		btnSubmit.click();
		logger.info("Clicked on Submit");
	}

}
