package com.aditi.kaplan.slingshotv2.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SlingShotV2BVTCases {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.aditi.kaplan.slingshotv2.tests");
		
		//$JUnit-BEGIN$
		suite.addTestSuite(BVT_BackToQueue.class);
		suite.addTestSuite(BVT_SuperAdmin.class);
		suite.addTestSuite(BVT_GraderAdmin.class);
		suite.addTestSuite(BVT_QuarantineEssay.class);
		suite.addTestSuite(BVT_Grader.class);
		//$JUnit-END$
		
		return suite;
	}

}
