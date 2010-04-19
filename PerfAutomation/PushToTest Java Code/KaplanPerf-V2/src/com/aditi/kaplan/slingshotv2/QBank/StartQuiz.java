package com.aditi.kaplan.slingshotv2.QBank;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test StartQuiz functionality of QBank feature.
 * @author Aditi
 *
 */
public class StartQuiz 
{	
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public StartQuiz()
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
		System.out.println("****** V2 QBank - StartQuiz Start ********");
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
			
			utils.selenium.waitForElementPresent("ctl00_lnkMBEQBank");
			utils.selenium.click("ctl00_lnkMBEQBank");

			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_TextBox2");
			utils.selenium.type("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_TextBox2", "50");
			
			utils.selenium.click("ctl00_ContentPlaceHolder1_CreateQuizMasterControlUC_CreateQuizUC_ImageButton1");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_ucQuizInterface_Submit_LinkBut_Img");
			
		}
		catch (Exception ex) 
		{
			System.out.println("****** StartQuiz Failed ******");
            utils.selenium.saveSource("StartQuiz-report-failed.html");
            throw ex;
		}
		System.out.println("****** V2 QBank - StartQuiz End ********");
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}