package com.aditi.kaplan.slingshotv2.Grader;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test ExpandState functionality of Grader feature.
 * @author Aditi
 *
 */
public class ExpandState 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public ExpandState()
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
		System.out.println("****** V2 Grader - ExpandState Start ********");
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
            
            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_dvArrow");	
		}
		catch(Exception ex)
		{
			 System.out.println("****** ExpandState Failed ******");
	         utils.selenium.saveSource("ExpandState-report-failed.html");
	         throw ex;
		}
		System.out.println("****** V2 Grader - ExpandState End ********");
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();		
	}
	
}