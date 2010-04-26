package com.aditi.kaplan.slingshotv2.QBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

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
	public void runTest(Object DPLValues,Object SiteValues) throws Exception
	{
		System.out.println("****** V2 QBank - ReviewSubmitQuiz Start ********");
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
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Submit_LinkBut_Img");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_answerSheetUC_repeater1_ctl00_answerOptionA");
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_answerSheetUC_repeater1_ctl00_answerOptionA");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Submit_LinkBut_Img");
			
			utils.selenium.chooseOkOnNextConfirmation();
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_Submit_LinkBut_Img");
			utils.selenium.getConfirmation();
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_btnQBankHome_Img");			
			utils.selenium.click("ctl00_ContentPlaceHolder1_ucQuizInterface_btnQBankHome_Img");
			utils.selenium.waitForPageToLoad("45000");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_ImageButton1");
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_ctl00_ctl02_GridView1_ctl02_LinkButton1");
			utils.selenium.click("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_ctl00_ctl02_GridView1_ctl02_LinkButton1");
			utils.selenium.waitForPageToLoad("30000");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_btnAnalyze_Img");
		}
		catch(Exception ex)
		{
			System.out.println("****** ReviewSubmitQuiz Failed ******");
            utils.selenium.saveSource("ReviewSubmitQuiz-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 QBank - ReviewSubmitQuiz End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}