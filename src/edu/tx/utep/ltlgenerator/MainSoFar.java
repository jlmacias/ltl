package edu.tx.utep.ltlgenerator;

public class MainSoFar {

	private static CPGenerator cpGenerator = new CPGenerator();

	public static void main(String[] args) {
		System.out.println("AtLeastOneC: " + cpGenerator.getCompositeProposition("L_AtLeastOneC_4"));
		System.out.println("AtLeastOneC: " + cpGenerator.getCompositeProposition("P_AtLeastOneH_5"));
		System.out.println("AtLeastOneE: " + cpGenerator.getCompositeProposition("L_AtLeastOneE_3"));
		System.out.println("ParallelC: " + cpGenerator.getCompositeProposition("R_ParallelC_4"));
		System.out.println("ParallelH: " + cpGenerator.getCompositeProposition("R_ParallelH_5"));
		System.out.println("ParallelE: " + cpGenerator.getCompositeProposition("L_ParallelE_3"));
		System.out.println("ConsecutiveC: " + cpGenerator.getCompositeProposition("Q_ConsecutiveC_4"));
		System.out.println("ConsecutiveH: " + cpGenerator.getCompositeProposition("P_ConsecutiveH_5"));
		System.out.println("ConsecutiveE: " + cpGenerator.getCompositeProposition("P_ConsecutiveE_4"));
		System.out.println("EventualC: " + cpGenerator.getCompositeProposition("L_EventualC_3"));
		System.out.println("EventualH: " + cpGenerator.getCompositeProposition("L_EventualH_4"));
		System.out.println("EventualE: " + cpGenerator.getCompositeProposition("L_EventualE_5"));
	}

}
