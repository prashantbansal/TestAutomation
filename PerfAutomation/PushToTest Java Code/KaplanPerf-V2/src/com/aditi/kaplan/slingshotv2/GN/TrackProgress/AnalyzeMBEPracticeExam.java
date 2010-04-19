package com.aditi.kaplan.slingshotv2.GN.TrackProgress;


import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test StudentLogin functionality of EssayBank feature.
 * @author Aditi
 *
 */
public class AnalyzeMBEPracticeExam 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public AnalyzeMBEPracticeExam()
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
		System.out.println("****** V2 GN.TrackProgress - AnalyzeMBEPracticeExam Start ********");
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
	            
				//utils.selenium.waitForElementPresent("//div[@id='mainContent']/div/div[1]/span");

				utils.waitForElementPresent("//span[2]/a",30);
				utils.selenium.click("//span[2]/a");
				utils.selenium.waitForPageToLoad("45000");
				
				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ibtnSubmit");
				
				utils.selenium.waitForElementPresent("//td[2]/div/table/tbody/tr/td[1]/div");
				utils.selenium.click("//td[2]/div/table/tbody/tr/td[1]/div");
				
				utils.selenium.waitForElementPresent("//table[2]/tbody/tr/td[2]/div/table/tbody/tr/td[2]/div");
				utils.selenium.click("//table[2]/tbody/tr/td[2]/div/table/tbody/tr/td[2]/div");
				
				utils.selenium.waitForElementPresent("//table[3]/tbody/tr/td[2]/div/table/tbody/tr/td[3]/div");
				utils.selenium.click("//table[3]/tbody/tr/td[2]/div/table/tbody/tr/td[3]/div");

				utils.selenium.waitForElementPresent("//table[4]/tbody/tr/td[2]/div/table/tbody/tr/td[4]/div");
				utils.selenium.click("//table[4]/tbody/tr/td[2]/div/table/tbody/tr/td[4]/div");
				
				utils.selenium.click("ctl00_ContentPlaceHolder1_ibtnSubmit");
				utils.selenium.waitForElementPresent("popup_content");

				utils.selenium.click("popup_ok");

				utils.selenium.waitForPageToLoad("45000");

				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucMBEPracticeExamInterface_btnAnalyze_Img");
				utils.selenium.click("ctl00_ContentPlaceHolder1_ucMBEPracticeExamInterface_btnAnalyze_Img");
				
				utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_lbtnReview_Img");
				
		}
		catch(Exception ex)
		{
			System.out.println("****** AnalyzeMBEPracticeExam Failed ******");
            utils.selenium.saveSource("AnalyzeMBEPracticeExam-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 GN.TrackProgress - AnalyzeMBEPracticeExam End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}