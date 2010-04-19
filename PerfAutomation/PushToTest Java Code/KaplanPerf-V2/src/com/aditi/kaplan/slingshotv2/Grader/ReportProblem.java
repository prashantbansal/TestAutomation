package com.aditi.kaplan.slingshotv2.Grader;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ReportProblem {

	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public ReportProblem()
	{
    	utils = new Utils();
	}
	
	/***
	 * This method will execute the actual test.
	 * @param DPLValues - Gets User Credentials from .csv file.
	 * @param SiteValues - Gets URL details from .csv file.
	 * @throws Exception - Throws other unhandled exceptions.
	 */
	public void runTest(Object DPLValues, Object SiteValues) throws Exception
    {
    	System.out.println("****** V2 Grader - ReportProblem Start ********");
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
        	
    		System.out.println("0. Opening http://121.242.143.28/Slingshotv2Auto/Default.aspx");
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

            utils.selenium.waitForElementPresent("//div[1]/div[1]/div[2]/a");
            utils.selenium.click("//div[1]/div[1]/div[2]/a");

            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_pnlPopup");
            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_txaDescription");

            utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_txaDescription", "Test");

            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_btnSend");
            
        } 
        catch (Exception ex) 
        {
            System.out.println("****** Report Problem Failed ******");
            utils.selenium.saveSource("ReportProblem-report-failed.html");
            throw ex;
        }
        System.out.println("****** V2 Grader - ReportProblem End ********");

    }

    public void tearDown() {
    	utils.tearDown();
    }
}
