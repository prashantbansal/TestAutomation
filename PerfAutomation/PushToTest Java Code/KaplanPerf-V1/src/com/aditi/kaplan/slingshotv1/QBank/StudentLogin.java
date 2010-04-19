package com.aditi.kaplan.slingshotv1.QBank;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;

/***
 * This class is used to test StudentLogin functionality of QBank feature.
 * @author Aditi
 *
 */
public class StudentLogin {
	
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */

	public StudentLogin()
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
		System.out.println("****** V1 QBank - Student Login Start ********");
		
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
					
		} 
		catch (Exception ex) 
		{
			System.out.println("****** Grader Login Failed ******");
            utils.selenium.saveSource("StudentLogin-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V1 QBank - Student Login End ********");

	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}

}