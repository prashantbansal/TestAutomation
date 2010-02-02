package com.aditi.kaplan.slingshotv2.bvt;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

/***
 * Create date: January 25, 2010
 * Description:	This class is used for performing utility functions.
 */
public class Utils {
	
	public Selenium browser;
	public String SERVER_HOST;
	public int SERVER_PORT;
	public String BROWSER;
	public String BROWSER_URL;
	public String APPLICATION_URL;
	private Properties props;
	private Properties envProps;
	
	/***
	 * Constructor which call the initializeProperties() method to initialize all the properties.
	 */
	public Utils() {
		initializeProperties();
	}
	
	/***
	 * Connect to server, start browser and set the speed of test (milliseconds between each action)
	 */
	public void setUp() 
	{	
		SERVER_HOST = getProperty("ServerHost");
		SERVER_PORT = Integer.parseInt(getProperty("ServerPort"));
		BROWSER = getProperty("Browser");
		BROWSER_URL = getProperty("BrowserURL");
		APPLICATION_URL = getProperty("ApplicationURL");
		
		browser = new DefaultSelenium(SERVER_HOST,SERVER_PORT,BROWSER,BROWSER_URL);
		browser.start();
		browser.open(APPLICATION_URL);
		browser.waitForPageToLoad("45000");
	}
	
	/***
	 * This method is used for Login purpose.
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
	 * This method is used for Logout purpose.
	 */
	public void Logout()
	{
		browser.click("ctl00_ctl00_LoginInfor1_btnLogout");
		browser.waitForPageToLoad("45000");
		SeleneseTestCase.assertTrue(browser.isTextPresent("Forgot Your Password?"));
	}

	/***
	 * This method will read from properites file and get the required PropertyValue based on the PropertyName passed.
	 * @param propName
	 * @return
	 */
	public String getProperty(String propName)
	{
		if (envProps.containsKey(propName)) {
			return envProps.getProperty(propName);
		}
		if (!props.containsKey(propName)) {
			System.out.println("WARNING: unknown property name: " +  propName);
			return "";
		}
		String propValue = props.getProperty(propName);
		return propValue;
	}

	/***
	 * Initialize the Properties.
	 */
	private void initializeProperties (){
		props = new Properties();
		envProps = System.getProperties();
		// try retrieve data from file
		try {			
			props.load(Utils.class.getResourceAsStream("General.properties"));
		}
		// catch exception in case properties file does not exist
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/***
	 * This method will get the current Date and Time.
	 * @return
	 */
    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
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
