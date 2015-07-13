package edu.tx.utep.ltlgenerator;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import test.edu.tx.utep.ltlgenerator.ZTestSuite;

public class MainSoFar {

	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(ZTestSuite.class);
		
		int passed = result.getRunCount() - result.getFailureCount() - result.getIgnoreCount();
		System.out.println("Ran " + result.getRunCount() + " tests");
		System.out.println("\tFailed:  " + result.getFailureCount());
		System.out.println("\tIgnored: " + result.getIgnoreCount());
		System.out.println("\tPassed:  " + passed);
	}

}
