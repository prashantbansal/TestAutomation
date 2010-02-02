package com.aditi.kaplan.slingshotv2.bvt;

import org.junit.Test;

/***
 * Create date: January 25, 2010
 * Description:	This script will perform the following actions.
 * 1. Login as a Grader.
 * 2. Clicks Essay Queue -> Select an Essay -> Suspend the Essay.
 * 3. Verify that the Essay is suspended under My Essays -> Suspend Essays tab.
 * 4. Clicks My Essays -> Suspend Essays -> Submit the Essay.
 * 5. Verify that the Essay is submitted under My Essays -> Unbilled Essays tab.
 * 6. Submit the essay for Billing under My Essays -> Unbilled Essays tab.
 * 7. Verify that the essay is submitted for Billing under My Essays -> Prior Billing tab.
 * 8. Logout from the Grader.
 */

public class BackToQueue extends BaseBVTTest  {
	
		public String USERNAME;
		public String PASSWORD;
		
		/***
		 * Contructor which instantiates Utils object.
		 */
		public BackToQueue() {
			super();
		}

		/***
		 * This method consists of the actual testcase performed by a Grader.
		 */
		@Test
		public void testBVTBackToQueue()
		{
			try
			{
				USERNAME = obj.getProperty("GraderUserName");
				PASSWORD = obj.getProperty("GraderPassword");
				
				//User is logging into the application as Grader
				obj.Login(USERNAME, PASSWORD);
	
				/*--------------------SUSPEND ESSAY FUNCTION STARTED--------------------*/

				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_dvArrow");

				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isElementPresent("link=Essay ID")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				String getEssayForSuspend = obj.browser.getText("//td[1]/a");
				obj.browser.click("link=" + getEssayForSuspend);
				obj.browser.waitForPageToLoad("30000");

				obj.browser.click("document.forms[0].elements[5]");
				obj.browser.click("document.forms[0].elements[6]");
				obj.browser.click("document.forms[0].elements[7]");
				obj.browser.click("document.forms[0].elements[8]");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_Handwriting_0");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_LogicStructure_1");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_LengthDepthofAnalysis_2");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_GrammarPunctuation_1");
				obj.browser.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_txtComments", "W may argue that the oral agreement may not be enforced because it violates the Statute of Frauds (SOF). The SOF requires all agreements for the sale of land, for marriage, for surety, for goods over $500, and for agreements that can not be fully performed within a year be reduced to writing. Here, the two have an agreement that envisions many years into the future. However, the agreement can possibly be performed within a year. As such, the statute of frauds will not invalidate this oral agreement because it does not apply to this type of agreement.");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_btnSuspend");
				obj.browser.click("popup_ok");
				obj.browser.waitForPageToLoad("30000");
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab");

				assertEquals(getEssayForSuspend, obj.browser.isTextPresent(getEssayForSuspend));

				// Gets the Grader name inorder to verify in the Super Admin login.
				String getGraderName = obj.browser.getText("ctl00_ctl00_LoginInfor1_Label_UserInfor");
				
				// Grader is logging out of the application 
				obj.Logout();	
				
				/*-------------------- SUSPEND ESSAY FUNCTION COMPLETED --------------------*/
				
				/*-------------------- SUBMIT ESSAY FUNCTION STARTED --------------------*/
		
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
				
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_gradersTab");
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isElementPresent("link=# of Suspended essays")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				
				assertEquals(getGraderName, obj.browser.isTextPresent(getGraderName));
				
				String getID = obj.browser.getAttribute("//a[contains(text(),'" + getGraderName + "')]/@id");				
				obj.browser.click(getID.substring(0, getID.lastIndexOf('_')) + "_ReturnToQueue");
				obj.browser.click("popup_ok");
				
				// Grader Admin is logging out of the application
				obj.Logout();	
				
				/*-------------------- SUBMIT ESSAY FUNCTION COMPLETED  --------------------*/
				
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
				
				assertEquals(getEssayForSuspend, obj.browser.isTextPresent(getEssayForSuspend));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
		}

}
