package com.aditi.kaplan.slingshotv2.bvt;

import org.junit.Test;

/***
 * Create date: January 27, 2010
 * Description:	This script will perform the following actions.
 * 1. Login as a GraderAdmin.
 * 2. Clicks Graders -> Create New Grader.
 * 3. Enter all the required details in the respective fields.
 * 4. Save the details.
 * 5. Verify that the created Grader is present in the table in Graders tab.
 * 6. Logout from the GraderAdmin.
 */

public class GraderAdmin extends BaseBVTTest  {
	
		public String USERNAME;
		public String PASSWORD;
		
		/***
		 * Contructor which instantiates Utils object.
		 */
		public GraderAdmin() {
			super();
		}
			
		/***
		 * This method consists of the actual testcase performed by a Grader Admin.
		 */
		@Test
		public void testBVTGraderAdminFunctions()
		{
			try
			{
				String GraderName = "TestGrader " + obj.getDateTime();
							
				USERNAME = obj.getProperty("GraderAdminUserName");
				PASSWORD = obj.getProperty("GraderAdminPassword");
				
				// User is logging into the application as Grader Admin
				obj.Login(USERNAME, PASSWORD);
				
				obj.browser.isTextPresent("Quarantined");
				obj.browser.isTextPresent("Essay Queue");
				obj.browser.isTextPresent("My Essays");
				obj.browser.isTextPresent("Graders");
				obj.browser.isTextPresent("Contact Info");
				
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_btnCreateNewGrader");

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("New User")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
						
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtUserName", GraderName);
				obj.browser.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlRole","label=Grader");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtName", GraderName);
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtPhone", "(123)123-1234");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtEmail", "testgrader1@aditi.com");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtAddress", "testaddress");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtCity", "testcity");
				obj.browser.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlState", "label=ALASKA");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtZipCode", "12345");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_btnSaveProfile");

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("Return To Queue")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				assertEquals(GraderName, obj.browser.isTextPresent(GraderName));

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
		}

}
