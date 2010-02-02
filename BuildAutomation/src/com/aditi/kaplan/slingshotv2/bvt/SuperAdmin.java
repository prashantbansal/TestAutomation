package com.aditi.kaplan.slingshotv2.bvt;

import org.junit.Test;

/***
 * Create date: January 27, 2010
 * Description:	This script will perform the following actions.
 * 1. Login as a SuperAdmin.
 * 2. Clicks Graders -> Create New Grader.
 * 3. Enter all the required details in the respective fields for creating new Grader Admin.
 * 4. Save the details.
 * 5. Verify that the created Grader Admin is present in the table in Graders tab.
 * 6. Clicks Pods -> Create New Pod.
 * 7. Enter all the required details in the respective fields for creating new Pod.
 * 8. Save the details.
 * 9. Verify that the created Pod is present in the table in Pods tab.
 * 10. Logout from the GraderAdmin.
 */

public class SuperAdmin extends BaseBVTTest  {
	
		public String USERNAME;
		public String PASSWORD;
		
		/***
		 * Contructor which instantiates Utils object.
		 */
		public SuperAdmin() {
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
				String GraderAdminName = "TestGA " + obj.getDateTime();
				String PODName = "POD " + obj.getDateTime();
								
				USERNAME = obj.getProperty("SuperAdminUserName");
				PASSWORD = obj.getProperty("SuperAdminPassword");
				
				// User is logging into the application as Super Admin
				obj.Login(USERNAME, PASSWORD);
								
				obj.browser.isTextPresent("Quarantined");
				obj.browser.isTextPresent("Essay Queue");
				obj.browser.isTextPresent("My Essays");
				obj.browser.isTextPresent("Graders");
				obj.browser.isTextPresent("Pods");
				obj.browser.isTextPresent("Contact Info");
				
				/* ------------------- CREATE NEW GRADER ADMIN STARTED  -------------------*/
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_btnCreateNewGrader");
				

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("New User")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				obj.browser.focus("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtUserName");				
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtUserName", GraderAdminName);
				obj.browser.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlRole","label=Grader Admin");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtName", "TestGraderAdmin");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtPhone", "(123)123-1234");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtEmail", "testga1@aditi.com");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtAddress", "testaddress");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtCity", "testcity");
				obj.browser.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlState", "label=ALASKA");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_txtZipCode", "12345");
				obj.browser.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_ddlGraderPod", "label=Pod FL");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab_graders_userProfile_btnSaveProfile");

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("Return To Queue")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				assertEquals(GraderAdminName, obj.browser.isTextPresent(GraderAdminName));
				/* ------------------- CREATE NEW GRADER ADMIN COMPLETED  -------------------*/
				
				/* ------------------- CREATE NEW POD STARTED  -------------------*/
				
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_podsTab");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_podsTab_podsControl_podGrid_btnAddPod");
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("Add Pod")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_podsTab_podsControl_podAdd_txtPodName", PODName);
				//obj.browser.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_podsTab_podsControl_podAdd_ddlState", "label=PA");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_podsTab_podsControl_podAdd_btnAddState");
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("Remove")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_podsTab_podsControl_podAdd_btnSave");

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("created")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_podsTab_podsControl_podAdd_lnkPodHome");
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("Pod name")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				assertEquals(PODName, obj.browser.isTextPresent(PODName));
				
				/* ------------------- CREATE NEW POD COMPLETED  -------------------*/

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
		}
}
