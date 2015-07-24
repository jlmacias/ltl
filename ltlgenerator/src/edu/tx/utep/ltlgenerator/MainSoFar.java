package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.factories.OperatorFactory;
import edu.tx.utep.ltlgenerator.operators.Operator;

public class MainSoFar {

	public static void main(String[] args) {

//		CPGenerator cpGenerator = new CPGenerator();
//		OperatorGenerator operatorGenerator = new OperatorGenerator();
//		String ANDL = OperatorFactory.AND_L;

//		List<String> leftSides = cpGenerator.getCompositeProposition("P_AtLeastOneE_3");
//		List<String> rightSides = cpGenerator.getCompositeProposition("Q_AtLeastOneH_3");
//		System.out.println( operatorGenerator.getAndedPropositions(ANDL, leftSides, rightSides));

		CPGenerator cp = new CPGenerator();

		System.out.println("AT LEAST ONE");
		System.out.println(cp.getCompositeProposition("P_AtLeastOneC_3"));
		System.out.println(cp.getCompositeProposition("P_AtLeastOneH_3"));
		System.out.println(cp.getCompositeProposition("P_AtLeastOneE_3"));

		System.out.println();
		System.out.println("PARALLEL");
		System.out.println(cp.getCompositeProposition("P_ParallelC_3"));
		System.out.println(cp.getCompositeProposition("P_ParallelH_3"));
		System.out.println(cp.getCompositeProposition("P_ParallelE_3"));

		System.out.println();
		System.out.println("CONSECUTIVE");
		System.out.println(cp.getCompositeProposition("P_ConsecutiveC_3"));
		System.out.println(cp.getCompositeProposition("P_ConsecutiveH_3"));
		System.out.println(cp.getCompositeProposition("P_ConsecutiveE_3"));

		System.out.println();
		System.out.println("EVENTUAL");
		System.out.println(cp.getCompositeProposition("P_EventualC_3"));
		System.out.println(cp.getCompositeProposition("P_EventualH_3"));
		System.out.println(cp.getCompositeProposition("P_EventualE_3"));

		OperatorGenerator og = new OperatorGenerator();

		String AND_L = OperatorFactory.AND_L;
		String AND_R = OperatorFactory.AND_R;
		String AND_MINUS_L = OperatorFactory.AND_MINUS_L;

		System.out.println();
		System.out.println("OPERATOR L");
		System.out.println(og.getAndedPropositions(AND_L, cp.getCompositeProposition("P_AtLeastOneC_3"), cp.getCompositeProposition("Q_ParallelC_3")));
		System.out.println(og.getAndedPropositions(AND_L, cp.getCompositeProposition("P_AtLeastOneC_3"), cp.getCompositeProposition("Q_ParallelC_3")));

		System.out.println();
		System.out.println("OPERATOR R");
		System.out.println(og.getAndedPropositions(AND_R, cp.getCompositeProposition("P_AtLeastOneC_3"), cp.getCompositeProposition("Q_ParallelC_3")));

		System.out.println();
		System.out.println("OPERATOR -L");
		System.out.println(og.getAndedPropositions(AND_MINUS_L, cp.getCompositeProposition("P_AtLeastOneC_3"), cp.getCompositeProposition("Q_ParallelC_3")));

	}

}
