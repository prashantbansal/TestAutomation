package com.aditi.kaplan.slingshotv2.GN.SWGuide;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;

/***
 * This class is used to test "Select Strength and weakness guide" link functionality of Global Navigation.
 * @author Aditi
 *
 */
public class SelectSWGuide 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public SelectSWGuide()
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
		System.out.println("****** V2 Select Strength and weakness guide Start ********");
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
            utils.selenium.waitForElementPresent("link=Strength and Weakness Guide");
				
            utils.selenium.click("link=Strength and Weakness Guide");
            utils.selenium.waitForPageToLoad("30000");
            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_repeaterTopic_ctl00_imgQuiz1Status");
			
		}
		catch(Exception ex)
		{
			System.out.println("****** SelectSWGuide  Failed ******");
            utils.selenium.saveSource("SelectSWGuide-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Select Strength and weakness guide End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();
	}
	
}