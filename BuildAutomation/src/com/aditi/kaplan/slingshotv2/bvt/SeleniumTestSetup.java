package com.aditi.kaplan.slingshotv2.bvt;

import org.openqa.selenium.server.SeleniumServer;

import junit.extensions.TestSetup;
import junit.framework.Test;

public class SeleniumTestSetup extends TestSetup {

	private SeleniumServer ss;
	
	/***
	 * Consturctor of SeleniumTestSetup class thats calls the constructor of TestSetup class
	 * @param test
	 */
	public SeleniumTestSetup(Test test) {
		super(test);
	}

	/***
	 * setUp() method that starts the Selenium Server.
	 */
	public void setUp(){
		try {
			ss = new SeleniumServer();
			ss.start();
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();			
		}		
	}
	
	/***
	 * tearDown() method that stops the Selenium Server.
	 */
	public void tearDown(){
		if(ss != null) {
			ss.stop();
		}
	}
}
