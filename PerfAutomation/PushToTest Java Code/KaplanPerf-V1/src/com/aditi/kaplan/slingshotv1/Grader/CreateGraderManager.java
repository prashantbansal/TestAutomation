package com.aditi.kaplan.slingshotv1.Grader;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test CreateGraderManager functionality of Grader feature.
 * @author Aditi
 *
 */
public class CreateGraderManager
{
	Utils utils = null;

	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public CreateGraderManager()
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
		System.out.println("****** V1 Grader - Create Grader Manager Start ********");
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
            
            utils.superAdminLogin();
			
			utils.selenium.waitForElementPresent("ctl00_LinkBut7");
			utils.selenium.click("ctl00_LinkBut7");
			utils.selenium.waitForPageToLoad("30000");
			
			utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut_New");
			utils.selenium.waitForPageToLoad("30000");
			
			utils.selenium.select("ctl00_ContentPlaceHolder1_DropDownList_Role", "label=Grader Manager");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_UserName", "GraderManagerName1");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_PWD", "GraderManagerName1");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_FName", "GraderManager");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_LName", "Name1");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_KaplanID", "123");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_Email", "gradermanagername1@test.com");
			utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut_Save");
			utils.selenium.waitForPageToLoad("30000");
					
		} 
		catch (Exception ex) 
		{
            System.out.println("****** Create Grader  Manager Failed ******");
            utils.selenium.saveSource("CreateGraderManager-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V1 Grader - Create Grader Manager End ********");
		
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
		
}