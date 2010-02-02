package com.aditi.kaplan.slingshotv2.bvt;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

public class BVTRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		junit.textui.TestRunner.run(suite());
	}

	/***
	 * suite() method that calls all the test cases.
	 * 
	 * @return
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(
								BackToQueue.class
								,QuarantineEssay.class
								,SuperAdmin.class								
								,GraderAdmin.class
//TODO fix						,Grader.class
								);

		TestSetup ts = new SeleniumTestSetup(suite);
		return ts;
	}
}
