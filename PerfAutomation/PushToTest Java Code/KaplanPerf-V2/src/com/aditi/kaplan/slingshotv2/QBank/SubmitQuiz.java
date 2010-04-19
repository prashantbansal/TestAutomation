package com.aditi.kaplan.slingshotv2.QBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test SubmitQuiz functionality of QBank feature.
 * @author Aditi
 *
 */
public class SubmitQuiz 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */

	public SubmitQuiz()
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
		System.out.println("****** V2 QBank - SubmitQuiz Start ********");
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
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Submit_LinkBut_Img");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_answerSheetUC_repeater1_ctl00_answerOptionA");
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_answerSheetUC_repeater1_ctl00_answerOptionA");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Submit_LinkBut_Img");
			
			utils.selenium.chooseOkOnNextConfirmation();
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_Submit_LinkBut_Img");
			utils.selenium.getConfirmation();
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_btnAnalyze_Img");
		}
		catch(Exception ex)
		{
			System.out.println("****** SubmitQuiz Failed ******");
            utils.selenium.saveSource("SubmitQuiz-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 QBank - SubmitQuiz End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}