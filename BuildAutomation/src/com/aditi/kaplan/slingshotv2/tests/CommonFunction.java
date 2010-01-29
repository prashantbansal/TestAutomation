package com.aditi.kaplan.slingshotv2.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

/***
 * Create date: January 25, 2010
 * Description:	This class is used for performing common functions.
 */
public class CommonFunction {
	public Selenium browser;
	public String SERVER_HOST;
	public int SERVER_PORT;
	public String BROWSER_START_COMMAND;
	public String BROWSER_URL;
	
	/***
	 * Connect to server, start browser and set the speed of test (milliseconds between each action)
	 */
	public void setUp() 
	{	
		SERVER_HOST = ReadFromPropertiesFile("ServerHost");
		SERVER_PORT = Integer.parseInt(ReadFromPropertiesFile("ServerPort"));
		BROWSER_START_COMMAND = ReadFromPropertiesFile("BrowserStartCommand");
		BROWSER_URL = ReadFromPropertiesFile("BrowserURL");

		// browser = new DefaultSelenium("localhost", 4444, "*firefox", "http://172.16.136.165/");
		browser = new DefaultSelenium(SERVER_HOST,SERVER_PORT,BROWSER_START_COMMAND,BROWSER_URL);
		browser.start();
		browser.open("/Slingshotv2Auto/Default.aspx");
		browser.waitForPageToLoad("45000");
	}
	
	/***
	 * This function is used for Login purpose.
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public void Login(String username, String password) throws Exception
	{
		browser.type("TextBox1", username);
		browser.type("TextBox2", password);
		browser.click("ImageButton1");
		browser.waitForPageToLoad("45000");
	}
	
	/***
	 * This function is used for Logout purpose.
	 */
	public void Logout()
	{
		browser.click("ctl00_ctl00_LoginInfor1_btnLogout");
		browser.waitForPageToLoad("45000");
		SeleneseTestCase.assertTrue(browser.isTextPresent("Forgot Your Password?"));
	}

	/***
	 * This method will read from properites file and get the required PropertyValue based on the PropertyName passed.
	 * @param getPropertyName
	 * @return
	 */
	public String ReadFromPropertiesFile(String getPropertyName)
	{
		String getPropertyValue = null;
		
		// create an instance of properties class
		Properties props = new Properties();

		// try retrieve data from file
		try {

			props.load(new FileInputStream("D:/Kaplan/Testing/Automation Related/workspace/TestSelenium/src/com/aditi/kaplan/slingshotv2/tests/General.properties"));
			if (props.getProperty(getPropertyName) != null) {
				getPropertyValue = props.getProperty(getPropertyName);
			}
		}

		// catch exception in case properties file does not exist
		catch (IOException e) {
			e.printStackTrace();
		}
		return getPropertyValue;
	}

	/***
	 * This method will close the browser.
	 */
	public void tearDown() {
		try {
			// Closes the browser
			browser.stop();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
