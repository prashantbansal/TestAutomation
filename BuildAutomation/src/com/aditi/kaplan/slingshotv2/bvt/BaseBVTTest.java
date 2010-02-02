package com.aditi.kaplan.slingshotv2.bvt;

import org.junit.After;
import org.junit.Before;

import com.thoughtworks.selenium.SeleneseTestCase;

public class BaseBVTTest extends SeleneseTestCase {

	public Utils obj;

	public BaseBVTTest() {
		super();
		obj = new Utils();	
	}

	public BaseBVTTest(String name) {
		super(name);
	}

	/**
	 * setUp method()
	 */
	@Before
	public void setUp() {
		// Opens a browser for testing.
		obj.setUp();
	}

	/***
	 * tearDown() method
	 */
	@After
	public void tearDown() {
		
		// User is logging out of the application
		obj.Logout();	
		
		// Closes the browser.
		obj.tearDown();
	}

}