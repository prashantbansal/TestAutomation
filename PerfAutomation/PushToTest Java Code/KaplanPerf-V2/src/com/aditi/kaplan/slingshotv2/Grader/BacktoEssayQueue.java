package com.aditi.kaplan.slingshotv2.Grader;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test BacktoEssayQueue functionality of Grader feature.
 * @author Aditi
 *
 */
public class BacktoEssayQueue 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public BacktoEssayQueue()
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
		System.out.println("****** V2 Grader - BacktoEssayQueue Start ********");
		try
		{
			utils.selenium.getWebClient().setAjaxController(new AjaxController(){
                /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				
				@Override
                public boolean processSynchron(HtmlPage page,
                        WebRequestSettings settings, boolean async) {
                    return true;
                }
			});
			
            if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }

            utils.graderLogin();

            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_dvArrow");
            
			utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_ctl01_ctl02_dcitem0");
			
			utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_ctl01_ctl02_dcitem0");			
			utils.selenium.waitForElementPresent("//img[@alt='Back to Essay Queue']");

			utils.selenium.chooseOkOnNextConfirmation();
			utils.selenium.click("//img[@alt='Back to Essay Queue']");
			utils.selenium.getConfirmation();

		}
		catch(Exception ex)
		{
			System.out.println("****** BacktoEssayQueue Failed ******");
            utils.selenium.saveSource("BacktoEssayQueue-report-failed.html");
            throw ex;
		}
		System.out.println("****** V2 Grader - BacktoEssayQueue End ********");
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}
