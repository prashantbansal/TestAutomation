package com.aditi.kaplan.slingshotv1.GN.SWGuide;
import com.aditi.kaplan.slingshotv1.Utilities.Utils;

/***
 * This class is used to test StudentLogin functionality of Grader feature.
 * @author Aditi
 *
 */
public class GNStudentLogin {
	
Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public GNStudentLogin()
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
		System.out.println("****** V1 Studen - Login Start ********");
		try
		{
            if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }

            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }
            
            utils.studentLogin();
            utils.selenium.waitForElementPresent("ctl00_LinkBut1_Img");

		}
		catch(Exception ex)
		{
			System.out.println("****** Submit Essay Failed ******");
            utils.selenium.saveSource("GNStudentLogin-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V1 Studen - Login End ********");
		
		
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}

}
