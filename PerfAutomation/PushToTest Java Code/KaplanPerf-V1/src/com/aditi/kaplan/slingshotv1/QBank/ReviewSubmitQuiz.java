package com.aditi.kaplan.slingshotv1.QBank;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;

/***
 * This class is used to test ReviewSubmitQuiz functionality of QBank feature.
 * @author Aditi
 *
 */
public class ReviewSubmitQuiz 
{
	
	Utils utils = null;
		
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public ReviewSubmitQuiz()
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
		System.out.println("****** V1 QBank - Review Submit Quiz Start ********");
		try 
		{
			if (DPLValues != null) {
	           	utils.applyValues(DPLValues);
	        }

	        if (SiteValues != null) {
	           	utils.applyValues(SiteValues);
	        }
	            
	        utils.studentLogin();			
			
			utils.selenium.waitForElementPresent("ctl00_LinkBut3_Img");
			utils.selenium.click("ctl00_LinkBut3_Img");
			utils.selenium.waitForPageToLoad("30000");
			
			utils.selenium.waitForElementPresent("//a[@id='ctl00_ContentPlaceHolder1_A_Qbank_Click']/div");
			
			utils.selenium.click("//a[@id='ctl00_ContentPlaceHolder1_A_Qbank_Click']/div");
			utils.selenium.waitForPopUp("QbankSplash", "40000");
			utils.selenium.selectWindow("QbankSplash");
			utils.selenium.waitForElementPresent("//a[@id='ctl00_ContentPlaceHolder1_LinkBut5']");
			
			//assertTrue(utils.selenium.isTextPresent("For Customer Service"));
			utils.selenium.focus("//a[@id='ctl00_ContentPlaceHolder1_LinkBut5']");
			utils.selenium.mouseOver("id=ctl00_ContentPlaceHolder1_LinkBut5");
			utils.selenium.selectWindow("QbankSplash");
			utils.selenium.click("id=ctl00_ContentPlaceHolder1_LinkBut5");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_TextBox2");

			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox2", "2");
			utils.selenium.click("ctl00_ContentPlaceHolder1_ImageButton1");
			utils.selenium.waitForPageToLoad("30000");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_Next_LinkBut_Img");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_Template_AOptions_ra_v|0");

			utils.selenium.click("ctl00_ContentPlaceHolder1_Template_AOptions_ra_v|0");
			utils.selenium.mouseOver("ctl00_ContentPlaceHolder1_Next_LinkBut_Img");
			utils.selenium.click("ctl00_ContentPlaceHolder1_Next_LinkBut_Img");
			utils.selenium.selectWindow("name=QbankSplash");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_Template_AOptions_ra_v|0");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_Next_LinkBut_Img");

			utils.selenium.click("ctl00_ContentPlaceHolder1_Template_AOptions_ra_v|0");
			utils.selenium.click("ctl00_ContentPlaceHolder1_Next_LinkBut_Img");
			//assertEquals("This is the last question. Click \"OK\" to end the quiz. Click \"Cancel\" to submit the quiz later.", utils.selenium.getConfirmation());
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_QbankNavigation1_LinkBut2_Img");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_QbankNavigation1_LinkBut_Exit_Img");

			utils.selenium.click("ctl00_ContentPlaceHolder1_QbankNavigation1_LinkBut2_Img");
			utils.selenium.waitForPageToLoad("30000");
			utils.selenium.waitForElementPresent("link=Date & Time");

			utils.selenium.click("link=Date & Time");
			utils.selenium.waitForPageToLoad("30000");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ctl00_GridView1_ctl02_LinkButton1");
			utils.selenium.click("ctl00_ContentPlaceHolder1_ctl00_GridView1_ctl02_LinkButton1");
			utils.selenium.waitForPageToLoad("30000");
						
		} 
		catch (Exception ex) 
		{
			System.out.println("****** Grader Login Failed ******");
            utils.selenium.saveSource("ReviewSubmitQuiz-report-failed.html");
            throw ex;
		}
				
		System.out.println("****** V1 QBank - Review Submit Quiz End ********");

	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}