package com.demoBankingV1.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demoBankingV1.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browsers")

	@BeforeClass
	public void setup(@Optional String browser) {

		
		  logger = Logger.getLogger("ebanking"); 
		  PropertyConfigurator .configure(
		  "C:\\Users\\mtali\\eclipse-workspace\\demoBankingV1\\Configuration\\log4j.properties"
		  );
		 
	

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\mtali\\eclipse-workspace\\demoBankingV1\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(readconfig.getURL());

		logger.info("URL is opened:");
	}

	@AfterClass
	public void tearDown() {
	driver.quit();
	}

	public void captureScreen(WebDriver driver, String testName) throws IOException {

		String path = System.getProperty("user.dir") + "/Screenshots/" + testName + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(path);
		FileUtils.copyFile(src, trg);
		System.out.println("Screenshot taken");

	}

	public String randomEmail() {

		String randomString = RandomStringUtils.randomAlphabetic(7);
		return randomString;
	}

	public String randomNumber() {

		String randomNum = RandomStringUtils.randomNumeric(10);

		return randomNum;
	}
}
