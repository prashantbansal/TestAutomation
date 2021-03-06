package com.aditi.kaplan.slingshotv1.QBank;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;

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
	public void runTest(Object DPLValues, Object SiteValues) throws Exception
	{
		System.out.println("****** V1 QBank - Start Quiz Start ********");
		
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
			System.out.println("1");
			utils.selenium.waitForPopUp("QbankSplash", "40000");
			System.out.println("2");
			//utils.selenium.selectPopUp("QbankSplash");
			utils.selenium.selectWindow("name=QbankSplash");
			System.out.println("3");		
			utils.selenium.waitForElementPresent("//a[@id='ctl00_ContentPlaceHolder1_LinkBut5']");
			utils.selenium.focus("//a[@id='ctl00_ContentPlaceHolder1_LinkBut5']");
			utils.selenium.mouseOver("id=ctl00_ContentPlaceHolder1_LinkBut5");
			//utils.selenium.selectPopUp("QbankSplash");
			utils.selenium.selectWindow("QbankSplash");
			utils.selenium.click("id=ctl00_ContentPlaceHolder1_LinkBut5");
			
			utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_TextBox2");
			
			utils.selenium.type("ctl00_ContentPlaceHolder1_TextBox2", "2");
			utils.selenium.click("ctl00_ContentPlaceHolder1_ImageButton1");
			utils.selenium.waitForPageToLoad("30000");
							
		} 
		catch (Exception ex) 
		{
			System.out.println("****** Grader Login Failed ******");
            utils.selenium.saveSource("StartQuiz-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V1 QBank - Start Quiz Start ********");

	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}