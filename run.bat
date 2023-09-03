cd C:\Users\mtali\eclipse-workspace\demoBankingV1
mvn clean install


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="demoBankingV1">
	<listeners>
		<listener class-name="com.demoBankingV1.utilities.Reporting" />
	</listeners>

	<test thread-count="5" name="Test">
		<parameter name="browsers" value="chrome" />

		<classes>
			<class name="com.demoBankingV1.testCases.TC_LoginTest_001" />
			<class name="com.demoBankingV1.testCases.TC_LoginDDT_002" />
			<class name="com.demoBankingV1.testCases.TC_AddCustomerTest_003" />
			<class name="com.demoBankingV1.testCases.TC_EditCustomerTest_004" />
			<class name="com.demoBankingV1.testCases.TC_EditCustomerValidTest_005" />


		</classes>

	</test> <!-- Test -->
</suite> <!-- -->



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("URL of your webpage");

        // Locate the elements
        WebElement dropdownButton = driver.findElement(By.id("dropdownButton"));
        WebElement optionToClick = driver.findElement(By.xpath("//li[text()='Option 2']"));

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

        // Perform the mouse actions
        actions.moveToElement(dropdownButton).perform(); // Hover over the button
        actions.click(optionToClick).perform(); // Click on the desired option

        // Close the browser
        driver.quit();
    }
}
