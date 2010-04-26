package com.aditi.kaplan.slingshotv2.GN.SWGuide;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test Syllabus link functionality of Global Navigation.
 * @author Aditi
 *
 */
public class Syllabus 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public Syllabus()
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
		System.out.println("****** V2 Syllabus Start ********");
		try
		{
            if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }
            
            utils.studentLogin();
            utils.selenium.waitForElementPresent("ctl00_Label_UserWelcomeInfo");
            
            utils.selenium.click("TabStudyPlan");
            utils.selenium.waitForElementPresent("ctl00_lnkStudentSyllabus");
    		
            utils.selenium.click("ctl00_lnkStudentSyllabus");
			
		}
		catch(Exception ex)
		{
			System.out.println("****** Syllabus Failed ******");
            utils.selenium.saveSource("Syllabus-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Syllabus End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}