package edu.tx.utep.ltlgenerator;

public class MainSoFar {

	private static CPGenerator cpGenerator = new CPGenerator();

	public static void main(String[] args) {
		System.out.println("AtLeastOneC: " + cpGenerator.getCompositeProposition("L_AtLeastOneC_4"));
		System.out.println("AtLeastOneE: " + cpGenerator.getCompositeProposition("L_AtLeastOneE_3"));
		System.out.println("ParallelC: " + cpGenerator.getCompositeProposition("R_ParallelC_4"));
		System.out.println("ParallelE: " + cpGenerator.getCompositeProposition("R_ParallelE_3"));
		System.out.println("ConsecutiveC: " + cpGenerator.getCompositeProposition("Q_ConsecutiveC_4"));
	}

}
