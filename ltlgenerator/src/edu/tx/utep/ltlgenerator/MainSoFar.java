package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.factories.OperatorFactory;

public class MainSoFar {

	public static void main(String[] args) {
//		JUnitCore junit = new JUnitCore();
//		Result result = junit.run(ZTestSuite.class);
//		
//		int passed = result.getRunCount() - result.getFailureCount() - result.getIgnoreCount();
//		System.out.println("Ran " + result.getRunCount() + " tests");
//		System.out.println("\tFailed:  " + result.getFailureCount());
//		System.out.println("\tIgnored: " + result.getIgnoreCount());
//		System.out.println("\tPassed:  " + passed);
		
		
		CPGenerator cpGenerator = new CPGenerator();
		OperatorGenerator operatorGenerator = new OperatorGenerator();
		String ANDL = OperatorFactory.AND_L;
		
		List<String> leftSides = cpGenerator.getCompositeProposition2("P_AtLeastOneE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("Q_AtLeastOneH_3");
		System.out.println( operatorGenerator.getAndedPropositions(ANDL, leftSides, rightSides));

	}

}
