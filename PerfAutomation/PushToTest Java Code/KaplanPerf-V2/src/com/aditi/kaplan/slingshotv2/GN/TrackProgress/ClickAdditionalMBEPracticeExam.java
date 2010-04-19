package com.aditi.kaplan.slingshotv2.GN.TrackProgress;


import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test StudentLogin functionality of EssayBank feature.
 * @author Aditi
 *
 */
public class ClickAdditionalMBEPracticeExam 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public ClickAdditionalMBEPracticeExam()
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
		System.out.println("****** V2 GN.TrackProgress - ClickAdditionalMBEPracticeExam Start ********");
		try
		{
	         if (DPLValues != null) {
	            	utils.applyValues(DPLValues);
	            }

	            if (SiteValues != null) {
	            	utils.applyValues(SiteValues);
	            }

	            utils.studentLogin();
	            
	        	utils.selenium.waitForElementPresent("//a[contains(text(),'Track Progress')]");
				utils.selenium.click("//a[contains(text(),'Track Progress')]");
	            utils.selenium.waitForPageToLoad("45000");
	            
				utils.selenium.waitForElementPresent("//div[@id='mainContent']/div/div[1]/span");
		
				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucTestProgressStateFinalExam_ctl01_HyperLink_TakeTest");
				utils.selenium.click("ctl00_ContentPlaceHolder1_ucTestProgressStateFinalExam_ctl01_HyperLink_TakeTest");
				utils.selenium.waitForPageToLoad("45000");
				
				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ibtnSubmit");
				
		}
		catch(Exception ex)
		{
			System.out.println("****** ClickAdditionalMBEPracticeExam Failed ******");
            utils.selenium.saveSource("ClickAdditionalMBEPracticeExam-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 GN.TrackProgress - ClickAdditionalMBEPracticeExam End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}