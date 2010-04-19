package com.aditi.kaplan.slingshotv2.Grader;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test BillSelected functionality of Grader feature.
 * @author Aditi
 *
 */
public class BillSelected 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public BillSelected()
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
		System.out.println("****** V2 Grader - BillSelected Start ********");
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

            System.out.println("***** 1 *****");
            utils.graderLogin();
            System.out.println("***** 2 *****");	            
            utils.selenium.waitForElementPresent("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab");
            utils.selenium.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab");
            System.out.println("***** 3 *****");
			utils.selenium.waitForElementPresent("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_suspendedEssayTab");
			utils.selenium.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_suspendedEssayTab");
			System.out.println("***** 4 *****");
			utils.selenium.waitForElementPresent("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab");
			utils.selenium.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab");
			System.out.println("***** 5 *****");
			utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab_unBilledEssay_unBilledEssayGrid_ctl02_chkItem");
			utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab_unBilledEssay_unBilledEssayGrid_ctl02_chkItem");
			System.out.println("***** 6 *****");
			utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab_unBilledEssay_btnSubmit");
			utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab_unBilledEssay_btnSubmit");
			System.out.println("***** 7 *****");
			utils.selenium.waitForElementPresent("popup_message");
			utils.selenium.click("popup_ok");
			System.out.println("***** 8 *****");
		}
		catch(Exception ex)
		{
			System.out.println("****** BillSelected Failed ******");
            utils.selenium.saveSource("BillSelected-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Grader - BillSelected End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}	

}
