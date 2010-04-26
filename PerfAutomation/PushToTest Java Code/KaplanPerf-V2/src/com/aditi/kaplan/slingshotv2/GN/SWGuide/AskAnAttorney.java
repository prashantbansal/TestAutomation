package com.aditi.kaplan.slingshotv2.GN.SWGuide;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test Ask An Attorney  functionality of Global Navigation.
 * @author Aditi
 *
 */
public class AskAnAttorney 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public AskAnAttorney()
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
		System.out.println("****** V2 Ask An Attorney Start ********");
		try
		{
            if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }
            
            utils.studentLogin();
            utils.selenium.waitForElementPresent("ctl00_Label_UserWelcomeInfo");
            utils.selenium.waitForElementPresent("//a[contains(text(),'Ask an Attorney')]");

            utils.selenium.click("link=Ask an Attorney");
            utils.selenium.waitForPageToLoad("45000");
            //utils.selenium.waitForElementPresent("link=Welcome");
			
		}
		catch(Exception ex)
		{
			System.out.println("****** AskAnAttorney  Failed ******");
            utils.selenium.saveSource("AskAnAttorney-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Ask An Attorney End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}