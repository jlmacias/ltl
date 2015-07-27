package edu.tx.utep.ltlgenerator;

import java.util.List;

public class MainSoFar {

	public static void main(String[] args) {

		CPGenerator cpGenerator = new CPGenerator();
		List<String> p = cpGenerator.getCompositeProposition("P_ConsecutiveC_3");
		List<String> pH = cpGenerator.getCompositeProposition("P_ConsecutiveH_3");
		List<String> pInverse = cpGenerator.getCompositeProposition("P_ParallelInverse_3");
		List<String> q = cpGenerator.getCompositeProposition("Q_EventualE_3");
		List<String> r = cpGenerator.getCompositeProposition("R_ParallelH_3");
		List<String> rH = cpGenerator.getCompositeProposition("R_ParallelH_3");
		List<String> rInverse = cpGenerator.getCompositeProposition("R_ParallelInverse_3");

		LTLGenerator ltlGenerator = new LTLGenerator();

		System.out.println(ltlGenerator.generateLTLFormula("GlobalQPrecedesPCStar", "P_EventualC_3", "Q_ConsecutiveE_3", "", ""));

//		System.out.println(ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBeforeRc", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", ""));
//		System.out.println(ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBeforeRc", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", ""));
//		System.out.println(ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBeforeRe", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", ""));
//		System.out.println(ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBeforeRe", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", ""));

	}

}