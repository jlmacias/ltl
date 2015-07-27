package edu.tx.utep.ltlgenerator;

import java.util.List;

public class MainSoFar {

	public static void main(String[] args) {

		CPGenerator cpGenerator = new CPGenerator();
		LTLGenerator ltlGenerator = new LTLGenerator();

		System.out.println(ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "L_ConsecutiveC_3"));

	}

}