package com.aditi.kaplan.slingshotv1.Grader;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;
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
	public void runTest(Object DPLValues,Object SiteValues  ) throws Exception
	{
		System.out.println("****** V1 Grader - Create Essay Grader Start ********");
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
			
			utils.selenium.waitForElementPresent("ctl00_LinkBut11");
			utils.selenium.click("ctl00_LinkBut11");
			utils.selenium.waitForPageToLoad("30000");
			
			utils.selenium.click("ctl00_LinkBut7");
			utils.selenium.waitForPageToLoad("30000");
			utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut_New");
			utils.selenium.waitForPageToLoad("30000");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_UserName", "EssayGraderName1");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_PWD", "EssayGraderName1");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_FName", "EssayGrader");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_LName", "Name1");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_KaplanID", "123");
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox_Email", "essaygradername1@test.com");
			utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut_Save");
					
		} 
		catch (Exception ex) 
		{
            System.out.println("****** Create Essay Grader Failed ******");
            utils.selenium.saveSource("CreateEssayGrader-report-failed.html");
            throw ex;
		}
	
		System.out.println("****** V1 Grader - Create Essay Grader End ********");

	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
		
}