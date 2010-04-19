package com.aditi.kaplan.slingshotv2.QBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test JumpGoQuiz functionality of QBank feature.
 * @author Aditi
 *
 */
public class JumpGoQuiz 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public JumpGoQuiz()
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
		System.out.println("****** V2 QBank - JumpGoQuiz Start ********");
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
			utils.selenium.waitForPageToLoad("45000");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_answerSheetUC_goToControlUC_TextBox_Question");

			utils.selenium.type("ctl00_ContentPlaceHolder1_ucQuizInterface_answerSheetUC_goToControlUC_TextBox_Question", "10");
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_answerSheetUC_goToControlUC_Button_Go");
			utils.selenium.waitForTextPresent("Question: 10 of 50");

		}
		catch (Exception ex) 
		{
			System.out.println("****** JumpGoQuiz Failed ******");
            utils.selenium.saveSource("JumpGoQuiz-report-failed.html");
            throw ex;
		}
		System.out.println("****** V2 QBank - JumpGoQuiz End ********");
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}