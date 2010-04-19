package com.aditi.kaplan.slingshotv1.GN.SWGuide;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;
/***
 * This class is used to test Start Check point Quiz of Global Navigation feature.
 * @author Aditi
 *
 */
public class StartCheckpointQuiz {
	
Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public StartCheckpointQuiz()
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
		System.out.println("****** V1 Start Check point Quiz Start ********");
		try
		{
            if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }
            
            utils.studentLogin();
            utils.selenium.waitForElementPresent("ctl00_LinkBut4_Img");
			
            utils.selenium.click("ctl00_LinkBut4_Img");
			
            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_LinkBut_PSP");
            utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut_PSP");
            utils.selenium.waitForPopUp("PSP", "30000");
            utils.selenium.selectWindow("name=PSP");
            
            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_PSP_L1Section8_L2Section1_Quiz1_1");

            utils.selenium.click("ctl00_ContentPlaceHolder1_PSP_L1Section8_L2Section1_Quiz1_1");
            utils.selenium.waitForPopUp("TestSplash", "30000");
		}
		catch(Exception ex)
		{
			System.out.println("****** Submit Essay Failed ******");
            utils.selenium.saveSource("StartCheckpointQuiz-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V1 Start Check point Quiz End ********");
		
		
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}


}
