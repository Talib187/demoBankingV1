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