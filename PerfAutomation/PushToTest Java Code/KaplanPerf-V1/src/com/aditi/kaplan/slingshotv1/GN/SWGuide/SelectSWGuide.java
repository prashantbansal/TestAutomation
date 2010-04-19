package com.aditi.kaplan.slingshotv1.GN.SWGuide;

import com.aditi.kaplan.slingshotv1.Utilities.Utils;

public class SelectSWGuide {
	/***
	 * This class is used to test Select SW Guide functionality of Grader feature.
	 * @author Aditi
	 *
	 */

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
			System.out.println("****** V1 Select SW Guide Start ********");
		
			try
			{
	            if (DPLValues != null) {
	            	utils.applyValues(DPLValues);
	            }

	            if (SiteValues != null) {
	            	utils.applyValues(SiteValues);
	            }
	            
	            utils.studentLogin();
	            utils.selenium.waitForElementPresent("ctl00_LinkBut4_Img");

	            utils.selenium.click("ctl00_LinkBut4_Img");
	            utils.selenium.waitForPageToLoad("45000");
	            utils.selenium.waitForElementPresent("ctl00_ContentPlaceHolder1_LinkBut_PSP");

	            utils.selenium.click("ctl00_ContentPlaceHolder1_LinkBut_PSP");
	          //  utils.selenium.waitForPageToLoad("45000");

	            utils.selenium.waitForPopUp("PSP", "30000");
	            utils.selenium.selectWindow("name=PSP");
	    		//selenium.selectWindow("name=PSP");
	            
	            utils.selenium.waitForElementPresent("ctl00_HyperLink_Support");


			}
			catch(Exception ex)
			{
				System.out.println("****** Submit Essay Failed ******");
	            utils.selenium.saveSource("SelectSWGuide-report-failed.html");
	            throw ex;
			}
			
			
			System.out.println("****** V1 Select SW Guide End ********");

		}
		
	
	

}
