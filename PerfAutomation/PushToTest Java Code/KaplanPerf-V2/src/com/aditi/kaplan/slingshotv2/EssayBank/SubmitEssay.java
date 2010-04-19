package com.aditi.kaplan.slingshotv2.EssayBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

public class SubmitEssay {

	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public SubmitEssay()
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
		System.out.println("****** V2 EssayBank - Submit Essay Start ********");
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

				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucEssayHeader_btnSubmit");
								
				utils.selenium.waitForElementPresent("tinymce");
				utils.selenium.type("tinymce", "test answer");
				utils.selenium.click("ctl00_ContentPlaceHolder1_ucEssayHeader_btnSubmit");
				utils.selenium.waitForPageToLoad("45000");
				
				utils.selenium.waitForElementPresent("//img[@title='Return to Essay Home']");
				
				String message = "This essay has not yet been graded."; 
				utils.selenium.assertTrue(message.equals(utils.selenium.getText("//div[@id='ctl00_ContentPlaceHolder1_ucEssayScore_divNoScore']/span/strong")));

				utils.selenium.click("//img[@title='Return to Essay Home']");
				utils.selenium.waitForPageToLoad("45000");
				
				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_pickAnEssay_tabContainer_chooseOneTab_btnChooseOneForMe");

		}
		catch(Exception ex)
		{
			System.out.println("****** SubmitEssay  Failed ******");
            utils.selenium.saveSource("SubmitEssay-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 EssayBank - Submit Essay End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
}
