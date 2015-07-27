package edu.tx.utep.ltlgenerator;

public class MainSoFar {

	public static void main(String[] args) {

		LTLGenerator ltlGenerator = new LTLGenerator();
//		System.out.println(ltlGenerator.generateLTLFormula("GlobalAbsenceOfP", "Q_AtLeastOneC_5", "", "", ""));
//		System.out.println(ltlGenerator.generateLTLFormula("GlobalQPrecedesPE", "P_AtLeastOneC_3", "Q_ParallelC_3", "", ""));

		System.out.println(ltlGenerator.generateLTLFormula("QPrecedesPcBeforeRc", "P_ConsecutiveC_4", "Q_ConsecutiveE_2", "R_ParallelC_3", ""));
		System.out.println(ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBeforeRc", "P_ConsecutiveC_3", "Q_ConsecutiveE_2", "R_ParallelC_3", ""));
		System.out.println(ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBeforeRe", "P_ConsecutiveC_3", "Q_ConsecutiveE_2", "R_ParallelC_3", ""));

	}

}