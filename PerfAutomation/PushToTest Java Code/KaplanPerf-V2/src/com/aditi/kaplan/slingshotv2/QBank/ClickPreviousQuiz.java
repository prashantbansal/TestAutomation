package com.aditi.kaplan.slingshotv2.QBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test Click Previous Quiz functionality of QBank feature.
 * @author Aditi
 *
 */
public class ClickPreviousQuiz 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public ClickPreviousQuiz()
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
		System.out.println("****** V2 QBank - ClickPreviousQuiz Start ********");
		try
		{
			if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }

            utils.studentLogin();
	            
	        utils.selenium.waitForElementPresent("link=Practice");

			utils.selenium.click("link=Practice");
			utils.selenium.click("ctl00_lnkMBEQBank");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_TextBox2");

			utils.selenium.type("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_TextBox2", "5");
			utils.selenium.click("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_ImageButton1");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Next_LinkBut_Img");

			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_Next_LinkBut_Img");
			utils.selenium.waitForPageToLoad("30000");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Previous_LinkBut_Img");
			
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_Previous_LinkBut_Img");

			utils.selenium.waitForElementNotPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Previous_LinkBut_Img");
		}
		catch (Exception ex) 
		{
			System.out.println("****** ClickPreviousQuiz Failed ******");
            utils.selenium.saveSource("ClickPreviousQuiz-report-failed.html");
            throw ex;
		}
		System.out.println("****** V2 QBank - ClickPreviousQuiz End ********");
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}