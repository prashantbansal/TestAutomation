package com.aditi.kaplan.slingshotv2.GN.TrackProgress;


import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test StudentLogin functionality of EssayBank feature.
 * @author Aditi
 *
 */
public class SubmitSimulatedFloridaPracticeExam 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public SubmitSimulatedFloridaPracticeExam()
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
		System.out.println("****** V2 GN.TrackProgress - SubmitSimulatedFloridaPracticeExam Start ********");
		try
		{
	         if (DPLValues != null) {
	            	utils.applyValues(DPLValues);
	            }

	            if (SiteValues != null) {
	            	utils.applyValues(SiteValues);
	            }

	            utils.studentLogin();
	            
				utils.selenium.waitForElementPresent("//div[2]/ul/li[3]/a");
	            utils.selenium.click("//div[2]/ul/li[3]/a");
	            
	            utils.selenium.waitForPageToLoad("45000");
	            
				utils.selenium.waitForElementPresent("//div[@id='mainContent']/div/div[1]/span");

				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucTestProgressStateFinalExam_ctl02_HyperLink_TakeTest");
				
				utils.selenium.click("ctl00_ContentPlaceHolder1_ucTestProgressStateFinalExam_ctl02_HyperLink_TakeTest");
				utils.selenium.waitForPageToLoad("45000");
				
				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_btnSubmit");
				
				utils.selenium.waitForElementPresent("tinymce");
				utils.selenium.type("tinymce", "test answer");
				
				utils.selenium.waitForElementPresent("//td[2]/div/table/tbody/tr/td[1]/div");
				utils.selenium.click("//td[2]/div/table/tbody/tr/td[1]/div");
				
				utils.selenium.waitForElementPresent("//div[6]/table/tbody/tr/td[2]/div/table/tbody/tr/td[2]/div");
				utils.selenium.click("//div[6]/table/tbody/tr/td[2]/div/table/tbody/tr/td[2]/div");

				utils.selenium.waitForElementPresent("//div[7]/table/tbody/tr/td[2]/div/table/tbody/tr/td[3]/div");
				utils.selenium.click("//div[7]/table/tbody/tr/td[2]/div/table/tbody/tr/td[3]/div");

				utils.selenium.waitForElementPresent("//div[8]/table/tbody/tr/td[2]/div/table/tbody/tr/td[4]/div");
				utils.selenium.click("//div[8]/table/tbody/tr/td[2]/div/table/tbody/tr/td[4]/div");
				
				utils.selenium.click("ctl00_ContentPlaceHolder1_btnSubmit");			
				utils.selenium.waitForElementPresent("popup_content");
				utils.selenium.click("popup_ok");
				
				utils.selenium.waitForPageToLoad("45000");

				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_btnGoToAnalysis");

		}
		catch(Exception ex)
		{
			System.out.println("****** SubmitSimulatedFloridaPracticeExam Failed ******");
            utils.selenium.saveSource("SubmitSimulatedFloridaPracticeExam-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 GN.TrackProgress - SubmitSimulatedFloridaPracticeExam End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}