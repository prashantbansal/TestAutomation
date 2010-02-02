package com.aditi.kaplan.slingshotv2.bvt;

import org.junit.Test;

/***
 * Create date: January 27, 2010
 * Description:	This script will perform the following actions.
 * 1. Login as Grader.
 * 2. Clicks Essay Queue -> Select an Essay -> perform Report Problem.
 * 3. Enter all the required details in the respective fields for reporting the problem.
 * 4. Click Send button.
 * 5. Logout from Grader.
 * 6. Login as SuperAdmin.
 * 7. Verify that the Essay is present under Quarantine tab.
 * 8. Click the Essay and click Return to Queue button.
 * 9. Click Ok from the Popup which is displayed.
 * 10. Logout from SuperAdmin.
 * 11. Login as Grader.
 * 12. Clicks Essay Queue.
 * 13. Verify that the Essay was returned from the Quarantine tab from SuperAdmin.
 * 14. Logout from Grader
 */

public class QuarantineEssay extends BaseBVTTest  {
	
		public String USERNAME;
		public String PASSWORD;
		
		/***
		 * Contructor which instantiates Utils object.
		 */
		public QuarantineEssay() {
			super();
		}
			
		/***
		 * This method consists of the actual testcase performed by a Super Admin.
		 */
		@Test
		public void testBVTQuarantineEssay()
		{
			try
			{
				
				/* -------------------- REPORT PROBLEM STARTED --------------------*/
				
				USERNAME = obj.getProperty("GraderUserName");
				PASSWORD = obj.getProperty("GraderPassword");
				
				// User is logging into the application as Grader
				obj.Login(USERNAME, PASSWORD);

				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_dvArrow");

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isElementPresent("link=Essay ID")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				String getEssayForQuarantine = obj.browser.getText("//td[1]/a");
				obj.browser.click("link=" + getEssayForQuarantine);
				obj.browser.waitForPageToLoad("40000");
				
				String getQuestionID = obj.browser.getText("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_lblQuestionInfo");
				System.out.println(getQuestionID);
				
				String getStudentID = obj.browser.getText("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_lblStudentID");
				System.out.println(getStudentID);		

				obj.browser.fireEvent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_fancyDiv","click");
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_pnlPopup")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				obj.browser.select("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ddlIssueTypes", "label=Content Error");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_txaDescription", "test");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_btnSend");

				//User is logging out of the application as Grader
				obj.Logout();	
				
				/* -------------------- REPORT PROBLEM COMPLETED --------------------*/
				
				/* -------------------- QUARANTINE ESSAY STARTED --------------------*/
				
				USERNAME = obj.getProperty("SuperAdminUserName");
				PASSWORD = obj.getProperty("SuperAdminPassword");
				
				// User is logging into the application as Super Admin
				obj.Login(USERNAME, PASSWORD);


				assertEquals(getEssayForQuarantine, obj.browser.isTextPresent(getEssayForQuarantine));
				
				obj.browser.click("link=" +  getEssayForQuarantine);
				obj.browser.waitForPageToLoad("30000");
				
				assertEquals(getQuestionID, obj.browser.isTextPresent(getQuestionID));
				assertEquals(getStudentID, obj.browser.isTextPresent(getStudentID));
				
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_btnReturnToQueue");
				obj.browser.click("popup_ok");
				
				//User is logging out of the application as Grader
				obj.Logout();	
				
				/* -------------------- QUARANTINE ESSAY COMPLETED --------------------*/
				
				/* -------------------- VERIFICATION STARTED --------------------*/

				USERNAME = obj.getProperty("GraderUserName");
				PASSWORD = obj.getProperty("GraderPassword");
				
				// User is logging into the application as Grader
				obj.Login(USERNAME, PASSWORD);

				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_dvArrow");

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isElementPresent("link=Essay ID")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				assertEquals(getEssayForQuarantine, obj.browser.isTextPresent(getEssayForQuarantine));
				
				/* -------------------- VERIFICATION COMPLETED --------------------*/

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
		}

}
