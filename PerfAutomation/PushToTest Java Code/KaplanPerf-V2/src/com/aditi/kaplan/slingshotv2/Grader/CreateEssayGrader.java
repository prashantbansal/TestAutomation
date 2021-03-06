package com.aditi.kaplan.slingshotv2.Grader;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test CreateEssayGrader functionality of Grader feature.
 * @author Aditi
 *
 */
public class CreateEssayGrader 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public CreateEssayGrader()
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
		System.out.println("****** V2 Grader - CreateEssayGrader Start ********");
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

            utils.graderAdminLogin();            
			
			utils.selenium.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab");
			utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_btnCreateNewGrader");
			
			utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_btnCreateNewGrader");			
			utils.selenium.waitForTextPresent("New User");
			
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtUserName", "EssayGraderName1");
			//utils.selenium.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlRole", "label=Grader");
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtName", "EssayGraderName1");
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtPhone", "(123)123-1234");
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtEmail", "essaygradername1@test.com");
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtAddress", "EssayGraderName1Address");
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtCity", "EssayGraderName1City");
			utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlState");
			utils.selenium.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlState", "label=ALASKA");
			utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtZipCode", "12345");
			utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_btnSaveProfile");
		}
		catch(Exception ex)
		{
			System.out.println("****** CreateEssayGrader Failed ******");
            utils.selenium.saveSource("CreateEssayGrader-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Grader - CreateEssayGrader End ********");
    	
	}
	

	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}