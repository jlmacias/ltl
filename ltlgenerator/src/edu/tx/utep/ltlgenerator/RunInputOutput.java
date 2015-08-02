package edu.tx.utep.ltlgenerator;

import edu.tx.utep.ltlgenerator.inputoutput.LTLInputOutput;
public class RunInputOutput {

	public static void main(String[] args) {
		LTLInputOutput.processInput();
//		LTLGenerator ltlGenerator = new LTLGenerator();

//		System.out.println(ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRc", "P_ConsecutiveC_2", "Q_ParallelC_2", "R_AtLeastOneC_2", "L_ParallelC_2"));
//		System.out.println(ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRe", "P_ConsecutiveC_2", "Q_ParallelC_2", "R_AtLeastOneC_2", "L_ParallelC_2"));

//		System.out.println("Between L and Rc");
//		System.out.println("1. " + ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("2. " + ltlGenerator.generateLTLFormula("ExistenceOfPBetweenLAndRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("3. " + ltlGenerator.generateLTLFormula("QPrecedesPcBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("4. " + ltlGenerator.generateLTLFormula("QPrecedesPeBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("5. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("6. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("7. " + ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//
//		System.out.println("Between L and Re");
//		System.out.println("1. " + ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRe", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("2. " + ltlGenerator.generateLTLFormula("ExistenceOfPBetweenLAndRe", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("3. " + ltlGenerator.generateLTLFormula("QPrecedesPcBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("4. " + ltlGenerator.generateLTLFormula("QPrecedesPeBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("5. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("6. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("7. " + ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//
//		System.out.println("After L Until Rc");
////		System.out.println(ltlGenerator.generateLTLFormula("AbsenceOfPAfterLUntilRc", "P_ConsecutiveC_2", "Q_ParallelC_2", "R_AtLeastOneC_2", "L_ParallelC_2"));
////		System.out.println(ltlGenerator.generateLTLFormula("ExistenceOfPAfterLUntilRc", "P_ConsecutiveC_2", "Q_ParallelC_2", "R_AtLeastOneC_2", "L_ParallelC_2"));
//		System.out.println("1. " + ltlGenerator.generateLTLFormula("AbsenceOfPAfterLUntilRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("2. " + ltlGenerator.generateLTLFormula("ExistenceOfPAfterLUntilRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("3. " + ltlGenerator.generateLTLFormula("QPrecedesPcAfterLUntilRc", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("4. " + ltlGenerator.generateLTLFormula("QPrecedesPeAfterLUntilRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("5. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcAfterLUntilRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("6. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeAfterLUntilRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//		System.out.println("7. " + ltlGenerator.generateLTLFormula("QRespondsToPAfterLUntilRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
//
//		System.out.println("7. " + ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRc", "P_ConsecutiveC_2", "Q_ParallelC_2", "R_AtLeastOneC_2", "L_ParallelC_2"));

	}

}