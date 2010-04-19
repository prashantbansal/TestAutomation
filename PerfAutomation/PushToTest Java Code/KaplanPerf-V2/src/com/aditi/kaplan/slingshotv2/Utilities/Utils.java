package com.aditi.kaplan.slingshotv2.Utilities;

import java.util.HashMap;

import com.pushtotest.selenium.SeleniumHtmlunit;

/***
 * This class serves as utility purpose which has methods used by all the files
 * in all the features. 
 * @author Aditi
 *
 */
public class Utils {

	public SeleniumHtmlunit selenium = null;
	public HashMap<String, String> HM;
	
	String Base_URL;
	String Application_Path;
	String user;
	String password;
	
	/***
	 * Constructor which initializes SeleniumHtmlunit and HashMap object.
	 */
	public Utils()
	{
    	selenium = new SeleniumHtmlunit();
    	
    	HM = new HashMap<String, String>();
        HM.put("GUserName", "<<Grader User is not been Set>>");
        HM.put("GPassword", "<<Grader Password is not been Set>>");
        HM.put("GAUserName", "<<Grader Admin User is not been Set>>");
        HM.put("GAPassword", "<<Grader Admin Password is not been Set>>");
        HM.put("SAUserName", "<<Super Admin User is not been Set>>");
        HM.put("SAPassword", "<<Super Admin Password is not been Set>>");
        HM.put("SUserName", "<<Student User is not been Set>>");
        HM.put("SPassword", "<<Studnet Password is not been Set>>");
        HM.put("Base_URL", "<<Base_URL is not been Set>>");
        HM.put("Application_Path", "<<Application_Path is not been Set>>");        		
	}

	public void setUp()
	{
		
	}
	
	/***
	 * Clears HashMap and closed Selenium browser.
	 */
	public void tearDown()
	{
		try
		{
		       HM.clear();
			   selenium.close();
		       return;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	/***
	 * Log in the user by getting the following from .csv file.
	 * 1. Base URL
	 * 2. Application Path
	 * 3. Grader User Name
	 * 4. Grader Password
	 * @throws Exception
	 */
	public void graderLogin() throws Exception
	{
		try
		{
	        Base_URL = HM.get("Base_URL");	  		    
	        Application_Path = HM.get("Application_Path");

	        selenium.setBaseUrl(Base_URL);
			selenium.open(Application_Path);
			
    		user = HM.get("GUserName");		
    		password = HM.get("GPassword");
    		
    		System.out.println("\t\t ***  >> Grader User Name : "+user);
    		System.out.println("\t\t ***  >> Grader Password  : "+password);
	
    		selenium.type("TextBox1", user);
    		selenium.type("TextBox2", password);
			
    		selenium.click("ImageButton1");
    		selenium.waitForPageToLoad("45000");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/***
	 * Log in the user by getting the following from .csv file.
	 * 1. Base URL
	 * 2. Application Path
	 * 3. Grader Admin User Name
	 * 4. Grader Admin Password
	 * @throws Exception
	 */
	public void graderAdminLogin() throws Exception
	{
		try
		{
	        Base_URL = HM.get("Base_URL");		  		    
	        Application_Path = HM.get("Application_Path");

	        selenium.setBaseUrl(Base_URL);
			selenium.open(Application_Path);
			
    		user = HM.get("GAUserName");    		 	
    		password = HM.get("GAPassword");
   		
    		System.out.println("\t\t ***  >> Grader Admin User Name : "+user);
    		System.out.println("\t\t ***  >> Grader Admin Password  : "+password);
	
    		selenium.type("TextBox1", user);
    		selenium.type("TextBox2", password);
			
    		selenium.click("ImageButton1");
    		selenium.waitForPageToLoad("45000");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/***
	 * Log in the user by getting the following from .csv file.
	 * 1. Base URL
	 * 2. Application Path
	 * 3. Super Admin User Name
	 * 4. Super Admin Password
	 * @throws Exception
	 */
	public void superAdminLogin() throws Exception
	{
		try
		{
	        Base_URL = HM.get("Base_URL");		  		    
	        Application_Path = HM.get("Application_Path");

			selenium.setBaseUrl(Base_URL);
			selenium.open(Application_Path);
			
    		user = HM.get("SAUserName");   		
    		password = HM.get("SAPassword");
    		
    		System.out.println("\t\t ***  >> Super Admin User Name : "+user);
    		System.out.println("\t\t ***  >> Super Admin Password  : "+password);
	
    		selenium.type("TextBox1", user);
    		selenium.type("TextBox2", password);
			
    		selenium.click("ImageButton1");
    		selenium.waitForPageToLoad("45000");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/***
	 * Log in the user by getting the following from .csv file.
	 * 1. Base URL
	 * 2. Application Path
	 * 3. Student User Name
	 * 4. Student Password
	 * @throws Exception
	 */
	public void studentLogin() throws Exception
	{
		try
		{
	        Base_URL = HM.get("Base_URL");  		    
	        Application_Path = HM.get("Application_Path");

			selenium.setBaseUrl(Base_URL);
			selenium.open(Application_Path);
			
    		user = HM.get("SUserName");
    		password = HM.get("SPassword");
    		
    		System.out.println("\t\t ***  >> Student User Name : "+user);
    		System.out.println("\t\t ***  >> Student Password  : "+password);
	
    		selenium.type("TextBox1", user);
    		selenium.type("TextBox2", password);
			
    		selenium.click("ImageButton1");
    		selenium.waitForPageToLoad("45000");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/***
	 * 
	 * @param values - Key, Value mapping with HashMap
	 * @throws Exception
	 */
	public void applyValues(Object values)throws Exception {
		try {

	        if (values instanceof HashMap<?, ?>)
	        {
	            HashMap<?, ?> DPLvalues = (HashMap<?, ?>) values;	            
	            //System.out.println("DPLvalues>>>"+DPLvalues);
	            for (String key : HM.keySet())
	            {
	            	//System.out.println("Keyy >>>"+key);
	                if (DPLvalues.containsKey(key))
	                {
	                	//System.out.println("Here you go"+key+"<<>>"+DPLvalues.get(key));
	                    HM.put(key, (String) DPLvalues.get(key));
	                }
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	/***
	 * Check for the element till the specified timeout period 
	 * @param Element - Required Element to wait.
	 * @param waitTime - Required Time to wait.
	 * @throws Exception - Throws other unhandled exceptions.
	 */
    public void waitForElementPresent(String Element, int waitTime)throws Exception{
	        System.out.println("Waiting for the Element : <<"+Element+">>");
	        for (int i = 0; i< waitTime;i++)
	        {
	        	try
	        	{
	    	        System.out.println("Current Attempt No for the <<"+Element+">> is "+i);
		        	if (selenium.isElementPresent(Element)){
		                System.out.println("Found the Element : <<"+Element+">> in "+i+" attempts");
		                Thread.sleep(1000);
		                return;
		            }
		                Thread.sleep(1000);
		    	}
	        	catch (Exception e) 
		    	{
		    		System.out.println("\t\t ***  Exception in waitForElementPresent "+ e.getMessage());
		    		throw new Exception("Not Found the Element : "+Element);
		    	}
		    }
	        System.out.println("Not Found the Element : <<"+Element+">>");
	        throw new Exception("Not Found the Element : "+Element);
    }
    
}