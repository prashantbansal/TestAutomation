package com.aditi.kaplan.slingshotv2.GN.SWGuide;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test Start Checkpoint Quiz button functionality of Global Navigation.
 * @author Aditi
 *
 */
public class StartCheckpointQuiz 
{
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
		System.out.println("****** V2 Start Checkpoint Quiz - Start ********");
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
            
            utils.selenium.click("link=Study Plan");
            utils.selenium.click("link=Strength and Weakness Guide");
            utils.selenium.waitForPageToLoad("30000");
            
            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_repeaterTopic_ctl00_imgQuiz1Status");
			
            utils.selenium.click("ctl00_ContentPlaceHolder1_repeaterTopic_ctl00_imgQuiz1Status");
            utils.selenium.click("ctl00_ContentPlaceHolder1_repeaterTopic_ctl00_btnToggle");
			
            utils.selenium.pause("3000");
			
            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_repeaterTopic_ctl00_ucQuizInfo_lnkReview");
            utils.selenium.click("ctl00_ContentPlaceHolder1_repeaterTopic_ctl00_ucQuizInfo_lnkReview");
            utils.selenium.waitForPageToLoad("45000");
			
            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucCPQHomeView_btnStartQuiz");
            
            utils.selenium.click("ctl00_ContentPlaceHolder1_ucCPQHomeView_btnStartQuiz");
            utils.selenium.waitForPageToLoad("30000");
            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Suspend_LinkBut_Img");
					
		}
		catch(Exception ex)
		{
			System.out.println("****** StartCheckpointQuiz  Failed ******");
            utils.selenium.saveSource("StartCheckpointQuiz-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Start Checkpoint Quiz -  End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}