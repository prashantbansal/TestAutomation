package com.aditi.kaplan.slingshotv2.Grader;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test EditProfile functionality of Grader feature.
 * @author Aditi
 *
 */
public class EditProfile 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public EditProfile()
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
		System.out.println("****** V2 Grader - EditProfile Start ********");
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

            utils.selenium.setSpeed("40");
            utils.graderLogin();
	            
			utils.selenium.waitForElementPresent("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab");
			utils.selenium.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab");			
			
			utils.selenium.waitForElementPresent("//input[@id='ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab_userProfile_btnSaveProfile' and @value='Edit']");
			utils.selenium.click("//input[@id='ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab_userProfile_btnSaveProfile' and @value='Edit']");			
			
			utils.selenium.waitForElementPresent("//input[@id='ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab_userProfile_btnSaveProfile' and @value='Save']");
					
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab_userProfile_txtName", "Kaplan Grader 1");
			utils.selenium.click("//input[@id='ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab_userProfile_btnSaveProfile' and @value='Save']");
			
			utils.selenium.waitForElementPresent("//input[@id='ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_contactInfoTab_userProfile_btnSaveProfile' and @value='Edit']");
		}
		catch(Exception ex)
		{
			System.out.println("****** EditProfile Failed ******");
            utils.selenium.saveSource("EditProfile-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Grader - EditProfile End ********");
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}