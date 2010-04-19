package com.aditi.kaplan.slingshotv1.Grader;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test SubmitEssay functionality of Grader feature.
 * @author Aditi
 *
 */
public class SubmitEssay 
{
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
	public void runTest(Object DPLValues, Object SiteValues) throws Exception
	{
		System.out.println("****** V1 Grader - Submit Essay Start ********");
		
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
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_LinkBut_StateView");
			utils.selenium.clickAt("ctl00_ContentPlaceHolder1_State9_LinkBut08_Title_Img", "");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_State9_429_1");
			utils.selenium.click("ctl00_ContentPlaceHolder1_State9_429_1");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_I3046");
			
			utils.selenium.click("//td[2]/input");
			
			utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut1_Submit_Img");
			utils.selenium.waitForPageToLoad("30000");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_LinkBut_StateView");
						
		} 
		catch (Exception ex) 
		{
            System.out.println("****** Submit Essay Failed ******");
            utils.selenium.saveSource("SubmitEssay-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V1 Grader - Submit Essay End ********");
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}