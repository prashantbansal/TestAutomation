package com.aditi.kaplan.slingshotv2.EssayBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

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
	public void runTest(Object DPLValues,Object SiteValues) throws Exception
	{
		System.out.println("****** V2 EssayBank - Suspend Essay Start ********");
		try
		{
	         if (DPLValues != null) {
	            	utils.applyValues(DPLValues);
	            }

	            if (SiteValues != null) {
	            	utils.applyValues(SiteValues);
	            }

	            utils.studentLogin();
	            
				utils.selenium.waitForElementPresent("TabPractice");
				utils.selenium.click("TabPractice");
				
				utils.selenium.waitForElementPresent("ctl00_lnkStudentEssayBank");
				utils.selenium.click("ctl00_lnkStudentEssayBank");

				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_pickAnEssay_tabContainer_chooseOneTab_btnChooseOneForMe");
				utils.selenium.click("ctl00_ContentPlaceHolder1_pickAnEssay_tabContainer_chooseOneTab_btnChooseOneForMe");

				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucEssayHeader_btnSuspend");
				utils.selenium.click("ctl00_ContentPlaceHolder1_ucEssayHeader_btnSuspend");
				
				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_pickAnEssay_tabContainer_chooseOneTab_btnChooseOneForMe");

		}
		catch(Exception ex)
		{
			System.out.println("****** SuspendEssay  Failed ******");
            utils.selenium.saveSource("SuspendEssay-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 EssayBank - Suspend Essay End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
}
