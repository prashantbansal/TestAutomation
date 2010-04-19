package com.aditi.kaplan.slingshotv2.Grader;

import com.aditi.kaplan.slingshotv2.Utilities.Utils;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/***
 * This class is used to test SubmitEssay functionality of Grader feature.
 * @author Aditi
 *
 */
public class SubmitEssay 
{
	Utils utils = null;
	
	/***
	 * Constructor that instantiates object of Utils class. 
	 */
	public SubmitEssay()
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
		System.out.println("****** V2 Grader - SubmitEssay Start ********");
		try
		{
			utils.selenium.getWebClient().setAjaxController(new AjaxController(){
                /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				
				@Override
                public boolean processSynchron(HtmlPage page,
                        WebRequestSettings settings, boolean async) {
                    return true;
                }
			});
			
            if (DPLValues != null) {
            	utils.applyValues(DPLValues);
            }
            
            if (SiteValues != null) {
            	utils.applyValues(SiteValues);
            }

            utils.graderLogin();

            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_dvArrow");
            
            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_ctl01_ctl02_dcitem0");

            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_tabContainer_essayQueueTab_EQ1_index0_ctl01_ctl02_dcitem0");
			
            utils.selenium.click("//td[1]/a");
            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_imgSubmit");

            utils.selenium.waitForElementPresent("//tr[3]/td[2]/input");
            utils.selenium.click("//tr[3]/td[2]/input");
            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_lblScore");

            utils.selenium.waitForElementPresent("//tr[3]/td[3]/input");
            utils.selenium.click("//tr[3]/td[3]/input");
            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_lblScore");

            utils.selenium.waitForElementPresent("//tr[3]/td[4]/input");
            utils.selenium.click("//tr[3]/td[4]/input");
            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_lblScore");
            
            utils.selenium.waitForElementPresent("//tr[3]/td[5]/input");
            utils.selenium.click("//tr[3]/td[5]/input");
            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_lblScore");
            
            utils.selenium.waitForElementPresent("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_Handwriting_0");
            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_Handwriting_0");
            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_LogicStructure_1");
            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_LengthDepthofAnalysis_2");
            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_RadioButtonList_GrammarPunctuation_1");
            utils.selenium.type("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_ucScoring_txtComments", "F and R may try to argue that there was a valid novation that absolved them from personal liability on the contract. A novation is an agreement between the new corporation and the other party to the contract to release the promoters of all their obligations. Novations, at a minimum, require a formal act on the part of the board of directors and ascent by the other party to the contract. The facts are silent as to whether the board ever acted to grant a novation. Further, the landlord will argue that he never agreed to a formal novation. As such, F and R will not be able to show that a novation was ever formed.");
            
            utils.selenium.click("ctl00_ctl00_ContentPlaceHolder1Base_ContentPlaceHolder1_ucGradingInterface_imgSubmit");
            
            utils.selenium.waitForElementPresent("popup_message");
            utils.selenium.click("popup_ok");
            utils.selenium.waitForPageToLoad("45000");
          		
		}
		catch(Exception ex)
		{
			System.out.println("****** SubmitEssay Failed ******");
            utils.selenium.saveSource("SubmitEssay-report-failed.html");
            throw ex;
		}
		
		System.out.println("****** V2 Grader - SubmitEssay End ********");
    	
	}
	
	/***
	 * Calls Utils class tearDown() method which will clear HashMap and closes SeleniumHtmlunit.
	 */
	public void tearDown()
	{
		utils.tearDown();	
	}
	
}