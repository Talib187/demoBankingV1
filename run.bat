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


			driver.findElemenBy.xpath().click();


			Actions action = new Actions(driver);

			action.moveToElement(webElement).click().perform();
			action.click(webElement).perform();


			action.doubleClick();
			action.clickAndHold();
			action.dragAndDrop(sourceWebElement, targetWebElement).
			action.moveToElement(webElement).perform();
			action.contextClick();

			sendKeys(keys.Enter);
			keyUp(modifier_keys);
			keyDown(modifier_keys);

			WebDriverManager.chromeDriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("wwww.google.com");

			webElement ele = driver.findElement(By.id("password"));

			Actions act  = new Actions(driver);
			act.doubleClick(ele).perform();
			act.contextClick(ele).perform();
			act.dragAndDrop(ele, ele2).perform();
			act.clickAndHold(webElement ele , -100, 0).build().perform();
			act.moveToElement(ele).perform();
			// If you want to double mouse hover we will use:

			act.moveToElement(ele1).moveToElement(ele2).build().perform();

			// Keyboard actons using action class:

			act.sendKeys(keys.Enter).perform();
			act.sendKeys(ele, "Hello").perform();

			act.clickAndHold(ele1)
			.pause(Duration.ofSecond(3))
			.moveToElement(ele2).
			.release().
			.perform();

			driver.switchTo().alert().dismiss();
			driver.switchTo().alert().accept();
			driver.switchTo().alert().getText();
			driver.switchTo().alert().sendKeys("Hello");


			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			driver.switchTo().window("Window Name");
			driver.switchTo().frame(driver.findElement(By.xpath("xpath_string"));
			Action.dragAndDrop(ele1, ele2).perform();

			WebElement ele = driver.findElement(by.id("pass"));

			ele.isDisplayed();
			ele.isEnabled();
			ele.isSelected();

			When someone click on the such link somitimes error message is dispayed, like a page not found. There may not be any error message at all. These are essentially invalid HTTP request and have 4xx and 5xx status code.
			To find the broken link, first we need to find all the links on a webpage. using the HTML Anchor tag <a>.

			public class BrokenLinks{

			public static void verifyLinks(String linkURL){

			try{

			URL url = new URL(linkURL);
			httpURLConnection htcon = (httpURLConnection) url.openConnection();

			htcon.connect();

			int resCode = htcon.getResponseCode();

			if(resCode>=400){

			System.out.println(url + " is invalid");

			}
			
			else{
			
				System.out.println("URL is valid");
			}
			}
			
			catch (exception e){
			
				System.out.println("Issue in the getVerify link method");
				
				
				
				
				public static void main(String[] args){
				
				
				System.setProperty("webdriver.chrome.driver", "path_to_driver");
				
				WebDriver driver = new ChromeDriver();
				driver.get("www.google.ccom");
				driver.manage().window().maximize();
				driver.manage().timeOuts().implicitlyWait(5, TimeUnits.Seconds);
				
				List<WebElement> list = driver.findElements(By.tagName("a"));
				
				int listSize = list.size();
				
				for(int i=0; i<=listSize-1; i++) {
				
				
					webElement ele = lists.get(i);
					
					String url = ele.getAttribute("href");
				
					verifyLinks(url);
				
				}

			}
			
			

// Taking the full Screenshot:

TakesScreenshhot ts = (TakesScreenshot) driver;
File src = ts.getScreensshotAs(OutputType.FILE);
File trg = new File("");

FileUtils.copyFile(src, trg);

// Taking the partila screenshots: 

WebElement ele = driver.findElement(By.xpath(""));

TakesScreenshot ts = (TakeScreenshot) driver;
File src = ele.getScreenshotsAs(OutputType.FILE);


public static void uploadFile(String path){


try{

	StringSelection sel = new StringSelection();
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContent(sel, null);
	
	Robot rob = new Robot();
	rob.delay(500);
	
	rob.keyPress(keyEvent.VK_ENTER);
	rob.keyRelease(keyEvent.VK_ENTER);
	
	rob.keyPress(keyEvent.VK_CONTROL);
	rob.keyPress(keyEvent.VK_V);
	
	rob.keyRelease(keyEvent.VK_CONTROL);
	rob.keyRelease(keyEvent.VK_V);
	
	rob.keyPress(keyEvent.VK_ENTER);
	rob.keyRelease(keyEvent.VK_ENTER);
	
	}
	
	
	catch(Exception e){
	
	System.out.println("Issue in uploadFile");
	
	
	}
	
	
	// HeadLess Browser:
	
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--headless");
	
	Webdriver driver = new ChromeDriver(opt);
	
	// Stale Element Reference:
	
	A statle element refernce exception is the thrown in one of the two cases:
	1. The element has been deleted permanetly.
	2. The element is no longer attached to the DOM.
	
	To fix this. refersh the webpage.
	use try catch block:
	
	try {
	
		driver.findElement(By.xpath("")).click();
		
		}
		
		
		catch(staleElementRefernceException e) {
		
		
			System.out.println(e.getMessage());
			
			}
			
			
	WebElement ele = driver.findElement(By.xpath(""));
	WebddriverWait wait = new WebddriverWait(driver, 10);
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.staleNessOf(ele)));
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	
	
	javaScriptExecutor js = (javaScriptExecutor) driver;
	
	js.executeScript("arguments[0].click();" , ele);


// Fluent wait


	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(30, Timeunit.SECONDS)
									.pollingEvery(5, TimeUnit.SECONDS);
									.ignoring(NoSuchElementException.class);
									
	
	
	Function<WebDriver, WebElement> function = new Function<Webdriver, WebElement>(){
	
			public WebElement apply (webdriver driver) {
			
				webElement ele = driver.findElemen(By.xpath(""));
				
				if(ele.isDisplayed){
				
					return element;
					
					}
					
					
					return null
					
					

// Assertion in testNG framework is used to validate the actual and expected result. By assertion if actual and expected will not match then test case will fail and same reasonc can be obtained from html report.

Actual result is comapared with the expected result with the help of the assertion. It means verification is done to check if the state of the application is the same to what we are expecting or not. For creating assertion, we are going to use the Assert Class provied by the TestNG.

WE have two types of the Assertion:

1. Soft assert or Verify.
2. Hard assert.

In case of the soft assert, if actual and expected data will not match then test cse will not immediaely fail, till assertAll() statment is not executed.

Soft asserts are just the opposite of the hard assert. In soft assert, the susqueent assertions keep on running even though one assert validation fails. i.e. the test execution does not stop. Soft assert does not include by the default in TestNG. For this you need to include the org.testng.assert.softassert. So

public class softAssertion(){


	JavaScriptExecutor js = (JavaScriptExecutor) driver;
	
	js.executScript("document.getElementById(id).click())
	
	js.executScript("document.getElementById("id").click();");
	js.executeScript("arguments[0].click();", ele);
	
	js.executeScript("document.getElementById("id").value = 'Passowrd';");
	
	
	js.executeScript("document.getElementById("id").checked = true;");
	
	js.executeScript("alert('Welcome to the selenium testing')");
	
	js.executeScript("return document.domain;").toString();
	
	
	
	
	Page Factory in Selenium is a way of implementing the Page Object Model (POM) for Selenium WebDriver. It is an inbuilt framework concept that helps to initialize the web elements of a page class without using the FindElement or FindElements methods. It also provides a convenient way to access the web elements using annotations and the @FindBy locator.
The Page Factory class in Selenium has a static method called initElements, which takes a WebDriver instance and a page class as parameters, and returns an object of that page class with all the web elements initialized. The web elements are declared as fields in the page class, and they are annotated with the @FindBy locator, which specifies how to locate them on the web page. For example, you can use the id, name, className, css, xpath, etc. attributes to locate the web elements.
The advantage of using Page Factory in Selenium is that it makes the code more readable, maintainable, and reusable. It also supports lazy loading of the web elements, which means they are initialized only when they are accessed, not when the page class is instantiated. This improves the performance and avoids unnecessary exceptions.

Maven is especially useful for the automation test automation frameworks that use selenium. as it can handle the selenium dependencies and execut ethe automated test with different configurations. Maven also follow a standard project structure and a project objec 

Maven is a tool that helps to automate the build and test process of a software project. It can manage the dependencies, compile the source code, run the test cases, generate the reports, and package the final product Maven is especially useful for test automation frameworks that use Selenium, as it can handle the Selenium dependencies and execute the automated tests with different configurations²⁴. Maven also follows a standard project structure and a project object model (POM), which makes it easier to maintain and share the test automation code³⁵. Maven can also integrate with other tools and plugins, such as TestNG, Apache POI, Surefire, etc., to enhance the test automation capabilities.


			<class name="com.demoBankingV1.testCases.TC_LoginTest_001" />
			<class name="com.demoBankingV1.testCases.TC_LoginDDT_002" />
			<class name="com.demoBankingV1.testCases.TC_AddCustomerTest_003" />
			<class name="com.demoBankingV1.testCases.TC_EditCustomerTest_004" />
			<class name="com.demoBankingV1.testCases.TC_EditCustomerValidTest_005" />
			
			
			
			
			<class name="com.demoBankingV1.testCases.TC_LoginTest_001" />
			<class name="com.demoBankingV1.testCases.TC_LoginDDT_002" />
			<class name="com.demoBankingV1.testCases.TC_AddCustomerTest_003" />
			<class name="com.demoBankingV1.testCases.TC_EditCustomerTest_004" />
			<class name="com.demoBankingV1.testCases.TC_EditCustomerValidTest_005" />
			
			
			

#################### JavascriptExecutor Demo Program ############################################

	public static void main(Strings[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();  // We add parenthese because these are the method being called from the internal class. variable can be called without parenthese.
		
		// JavaScriptExecutor will be used when selenium inbuilt method are insufficient to perform action on any webelement in browser.
		// JavascriptExecutor execute the statement of the javascript language.
		// JavascriptExecutor is an interface and its parent is WebDdriver and child are browser driver like ChromeDriver, EdgeDriver etc.
		
		So if I am declaring the webdriver as below 
		
				WebDriver driver = new ChromeDriver();

		then while declaring the JavascriptExecutor I will have to typecast it. like below 
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
		If am declaring the chromedriver direclty like as below
			
			ChromeDriver driver = new ChromeDriver();
			
		Then while declaring the JavascriptExecutor there is no need to typecast it like below:
		
			JavascriptExecutor js = driver
			
		
		Reason for this is: since ChromeDriver(class) implents the JavascriptExecutor(interface) and 
		
				Differnt kind of JavascriptExecutor statemnts.
				
				
				
	 #### below are some useful Javascript functionalit: 
	 
				JavascriptExecutor js = (JavascriptExecutor)driver;

		
		// Sendkey using javascript
		WebElement ele = driver.findElement(By.xpath("//input[@id=\"name\"]"));
		js.executeScript("arguments[0].setAttribute('value', 'Mohammad Talib')", ele);
		
		// Element click using JavaScript
		WebElement clickEle = driver.findElement(By.xpath("//input[@id=\"female\"]"));
		js.executeScript("arguments[0].click()", clickEle);
		
		// Scroll to a Specific Element:
		WebElement scrollEle = driver.findElement(By.xpath("//label[normalize-space()='Sorted List:']"));
		js.executeScript("arguments[0].scrollIntoView();", scrollEle);
		
		// Scroll to the Bottom of the Page:
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		// Explanation: window.scrollTo(x, y), 
		// This method scrolls the browser window to the specified x (horizontal) and y (vertical) coordinates.
		//x = 0: No horizontal scrolling.
		//y = document.body.scrollHeight: Scrolls to the maximum vertical position, i.e., the bottom of the page.
		// y=0, it will go to top of the page.
		
		// Scroll to the Top of the Page
		js.executeScript("window.scrollTo(0, 0); ");
		
		// Zooming the page.
		js.executeScript("document.body.style.zoom='50%'; ");
	}