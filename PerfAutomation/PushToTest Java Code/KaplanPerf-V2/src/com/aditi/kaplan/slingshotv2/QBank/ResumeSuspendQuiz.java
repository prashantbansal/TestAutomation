package com.aditi.kaplan.slingshotv2.QBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test ResumeSuspendQuiz functionality of QBank feature.
 * @author Aditi
 *
 */
public class ResumeSuspendQuiz 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public ResumeSuspendQuiz()
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
		System.out.println("****** V2 QBank - ResumeSuspendQuiz Start ********");
		try
		{
			if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }

            utils.studentLogin();
			
			utils.selenium.waitForElementPresent("TabPractice");

			utils.selenium.click("TabPractice");
			utils.selenium.click("ctl00_lnkMBEQBank");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_TextBox2");

			utils.selenium.type("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_TextBox2", "50");
			utils.selenium.click("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_ImageButton1");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Suspend_LinkBut_Img");
			utils.selenium.chooseOkOnNextConfirmation();
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_Suspend_LinkBut_Img");
			utils.selenium.getConfirmation();
			utils.selenium.waitForPageToLoad("45000");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_ImageButton1");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_ctl00_ctl01_GridView1_ctl02_LinkButton3");
			utils.selenium.click("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_ctl00_ctl01_GridView1_ctl02_LinkButton3");
			utils.selenium.waitForPageToLoad("45000");
			utils.selenium.waitForPageToLoad("30000");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Suspend_LinkBut_Img");

		}
		catch(Exception ex)
		{
			System.out.println("****** ResumeSuspendQuiz Failed ******");
            utils.selenium.saveSource("ResumeSuspendQuiz-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 QBank - ResumeSuspendQuiz End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}