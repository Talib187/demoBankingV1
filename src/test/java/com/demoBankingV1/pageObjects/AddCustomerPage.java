package com.demoBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkNewCust;
	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustName;
	@FindBy(name = "rad1")
	@CacheLookup
	WebElement rdGender;
	@FindBy(name = "dob")
	@CacheLookup
	WebElement dpDOB;
	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtAddress;
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtCity;
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtState;
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtPin;
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txtMobile;
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEmail;
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPass;
	@FindBy(name = "sub")
	@CacheLookup
	WebElement btnSubmit;

	public void clickAddCust() throws InterruptedException {
		linkNewCust.click();
		Thread.sleep(2000);
		ldriver.navigate().refresh();
		ldriver.get("https://demo.guru99.com/v3/manager/addcustomerpage.php");
	}

	public void enterName(String custName) {
		txtCustName.sendKeys(custName);
	}

	public void selGender(String gender) {
		rdGender.click();
	}

	public void selDOB(String mm, String dd, String yy) {
		dpDOB.sendKeys(mm);
		dpDOB.sendKeys(dd);
		dpDOB.sendKeys(yy);
	}

	public void addCustAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void addCustCity(String city) {
		txtCity.sendKeys(city);
	}

	public void addCustState(String state) {
		txtState.sendKeys(state);
	}

	public void addCustPin(String pin) {
		txtPin.sendKeys(pin);
	}

	public void addCustMobile(String mobile) {
		txtMobile.sendKeys(mobile);
	}

	public void addCustEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void addCustPassword(String pass) {
		txtPass.sendKeys(pass);
	}
	public void clickSubmit() {
		
		btnSubmit.click();
	}
}
