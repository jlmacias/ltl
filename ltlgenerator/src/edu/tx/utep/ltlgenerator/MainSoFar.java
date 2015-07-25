package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.factories.OperatorFactory;
import edu.tx.utep.ltlgenerator.operators.Operator;

public class MainSoFar {

	public static void main(String[] args) {

		LTLGenerator ltlGenerator = new LTLGenerator();
//		System.out.println(ltlGenerator.generateLTLFormula("GlobalAbsenceOfP", "Q_AtLeastOneC_5", "", "", ""));
		System.out.println(ltlGenerator.generateLTLFormula("GlobalQPrecedesPE", "P_AtLeastOneC_3", "Q_ParallelC_3", "", ""));

	}

}
