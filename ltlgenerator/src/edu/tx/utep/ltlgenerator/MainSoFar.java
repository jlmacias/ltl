package edu.tx.utep.ltlgenerator;

public class MainSoFar {

	public static void main(String[] args) {

		LTLGenerator ltlGenerator = new LTLGenerator();

		// Between L and Rc
		System.out.println("1. " + ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
		System.out.println("2. " + ltlGenerator.generateLTLFormula("ExistenceOfPBetweenLAndRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));
		System.out.println("3. " + ltlGenerator.generateLTLFormula("QPrecedesPcBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
		System.out.println("4. " + ltlGenerator.generateLTLFormula("QPrecedesPeBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
		System.out.println("5. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
		System.out.println("6. " + ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));
		System.out.println("7. " + ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3"));

	}

}