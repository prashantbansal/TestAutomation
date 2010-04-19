package com.aditi.kaplan.slingshotv1.EssayBank;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;

/***
 * This class is used to test StudentLogin functionality of QBank feature.
 * @author Aditi
 *
 */
public class SuspendEssay {
	
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */

	public SuspendEssay()
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
		System.out.println("****** V1 Essay Bank - Suspend Essay Start ********");
		
		try 
		{
		
			if (DPLValues != null) {
	           	utils.applyValues(DPLValues);
	        }

	        if (SiteValues != null) {
	           	utils.applyValues(SiteValues);
	        }
	            
	        utils.studentLogin();
			
			utils.selenium.waitForElementPresent("ctl00_LinkBut3_Img");			
			utils.selenium.click("ctl00_LinkBut3_Img");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_LinkBut08_Essay");
			utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut08_Essay");
			utils.selenium.waitForPopUp("EssayHome", "30000");
			utils.selenium.selectWindow("EssayHome");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ctl13");
			utils.selenium.click("ctl00_ContentPlaceHolder1_ctl13");
			utils.selenium.waitForPopUp("TestSplash", "30000");
			utils.selenium.selectWindow("TestSplash");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_LinkBut_Go");
			utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut_Go");
			utils.selenium.waitForPageToLoad("45000");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_Suspend_LinkBut_Img");
			utils.selenium.click("ctl00_ContentPlaceHolder1_Suspend_LinkBut_Img");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_GridView1_ctl02_LinkButton3");
					
		} 
		catch (Exception ex) 
		{
			System.out.println("****** Suspend Essay Failed ******");
            utils.selenium.saveSource("SuspendEssay-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V1 Essay Bank - Suspend Essay End ********");

	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}

}