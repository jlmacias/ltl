package edu.tx.utep.ltlgenerator;

public class MainSoFar {

	public static void main(String[] args) {

		LTLGenerator ltlGenerator = new LTLGenerator();
//		System.out.println(ltlGenerator.generateLTLFormula("GlobalAbsenceOfP", "Q_AtLeastOneC_5", "", "", ""));
//		System.out.println(ltlGenerator.generateLTLFormula("GlobalQPrecedesPE", "P_AtLeastOneC_3", "Q_ParallelC_3", "", ""));

		System.out.println(ltlGenerator.generateLTLFormula("AbsenceOfPBeforeRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", ""));

	}

}