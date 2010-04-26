package com.aditi.kaplan.slingshotv2.GN.SWGuide;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test student Login functionality of Global Navigation.
 * @author Aditi
 *
 */
public class GNStudentLogin 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public GNStudentLogin()
	{
		utils = new Utils();		
	}
	
	public void setUp() 
	{
		
	}
	
	/***
	 * This method will execute the actual test.
	 * @param DPLValues - Gets User Credentials from .csv file
	 * @param SiteValues - Gets URL details from .csv file
	 * @throws Exception 
	 */
	public void runTest(Object DPLValues, Object SiteValues) throws Exception
	{
		System.out.println("****** V2 Student - Login Start ********");
		try
		{
            if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }
            
            utils.studentLogin();
            utils.selenium.waitForElementPresent("link=Strength and Weakness Guide");
		}
		catch(Exception ex)
		{
			System.out.println("****** GNStudentLogin  Failed ******");
            utils.selenium.saveSource("GNStudentLogin-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Student - Login End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}