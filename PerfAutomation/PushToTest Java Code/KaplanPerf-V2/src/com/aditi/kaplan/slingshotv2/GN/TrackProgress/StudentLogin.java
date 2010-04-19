package com.aditi.kaplan.slingshotv2.GN.TrackProgress;


import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test StudentLogin functionality of EssayBank feature.
 * @author Aditi
 *
 */
public class StudentLogin 
{
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
	public void runTest(Object DPLValues,Object SiteValues) throws Exception
	{
		System.out.println("****** V2 GN.TrackProgress - Student Login Start ********");
		try
		{
	         if (DPLValues != null) {
	            	utils.applyValues(DPLValues);
	            }

	            if (SiteValues != null) {
	            	utils.applyValues(SiteValues);
	            }

	            utils.studentLogin();
		}
		catch(Exception ex)
		{
			System.out.println("****** StudentLogin Failed ******");
            utils.selenium.saveSource("StudentLogin-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 GN.TrackProgress - Student Login End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}