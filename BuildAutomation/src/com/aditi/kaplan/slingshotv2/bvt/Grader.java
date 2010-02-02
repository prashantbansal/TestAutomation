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

public class Grader extends BaseBVTTest  {
	
		public String USERNAME;
		public String PASSWORD;
		
		/***
		 * Contructor which instantiates Utils object.
		 */
		public Grader() {
			super();
		}
			
		/***
		 * This method consists of the actual testcase performed by a Grader.
		 */
		@Test
		public void testBVTGraderFunctions()
		{
			try
			{
			
				USERNAME = obj.getProperty("GraderUserName");
				PASSWORD = obj.getProperty("GraderPassword");

				// User is logging into the application as Grader				
				obj.Login(USERNAME,PASSWORD);
	
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
			
				obj.browser.click("//tr[3]/td[2]/input");
				obj.browser.click("//tr[3]/td[3]/input");
				obj.browser.click("//tr[3]/td[4]/input");
				obj.browser.click("//tr[3]/td[5]/input");
				
/*				obj.browser.click("//td[2]/table/tbody/tr/td[1]/input");
				obj.browser.click("//tr[3]/td[2]/table/tbody/tr/td[2]/input");
				obj.browser.click("//tr[4]/td[2]/table/tbody/tr/td[3]/input");
				obj.browser.click("//tr[5]/td[2]/table/tbody/tr/td[2]/input");

				obj.browser.type("//textarea", "W may argue that the oral agreement may not be enforced because it violates the Statute of Frauds (SOF). The SOF requires all agreements for the sale of land, for marriage, for surety, for goods over $500, and for agreements that can not be fully performed within a year be reduced to writing. Here, the two have an agreement that envisions many years into the future. However, the agreement can possibly be performed within a year. As such, the statute of frauds will not invalidate this oral agreement because it does not apply to this type of agreement.");				
*/
				
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

				/*-------------------- SUSPEND ESSAY FUNCTION COMPLETED --------------------*/
				
				/*-------------------- SUBMIT ESSAY FUNCTION STARTED --------------------*/
		
				obj.browser.click("link=" + getEssayForSuspend);
				obj.browser.waitForPageToLoad("30000");

				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_imgSubmit");
				
/*				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isElementPresent("//input[@id='popup_ok']")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}*/
				
/*				if(obj.browser.getText("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_lblScore").equalsIgnoreCase("0.00"))
				{
					obj.browser.click("popup_ok");
				}
*/				
				obj.browser.waitForPageToLoad("30000");				
				
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab");
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab");
				
				assertEquals(getEssayForSuspend, obj.browser.isTextPresent(getEssayForSuspend));
								
				obj.browser.click("document.forms[0].elements[4]");
				obj.browser.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_unbilledEssaysTab_unBilledEssay_btnSubmit");
				assertTrue(obj.browser.getConfirmation().matches("^You have selected 1 essays\\. Do you want to continue[\\s\\S]$"));

				/*-------------------- SUBMIT ESSAY FUNCTION COMPLETED --------------------*/
				
				/*-------------------- PRIOR BILLING FUNCTION STARTED  --------------------*/

				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab");
				obj.browser.click("__tab_ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_priorBillingTab");
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("Billing")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				String getEssayForPriorBilling = obj.browser.getText("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_graderEssaysTab_graderEssays_essaysTabContainer_priorBillingTab_priorBilling_priorBillingGrid_ctl02_dcitem1");
				obj.browser.fireEvent("link=" +  getEssayForPriorBilling,"click");
				obj.browser.selectFrame("fancybox-frame");
							
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (obj.browser.isTextPresent("Essay ID")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				assertEquals("Student", obj.browser.isTextPresent("Student"));
				obj.browser.selectFrame("relative=up");
				obj.browser.click("fancybox-close");

				/*-------------------- PRIOR BILLING FUNCTION COMPLETED  --------------------*/

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
		}
}
