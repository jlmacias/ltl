package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.exceptions.OperatorNotFoundException;
import edu.tx.utep.ltlgenerator.operators.AndL;
import edu.tx.utep.ltlgenerator.operators.AndMinusL;
import edu.tx.utep.ltlgenerator.operators.AndR;
import edu.tx.utep.ltlgenerator.operators.Operator;

// Factory Pattern
public class OperatorFactory {

	public static final String AND_R = "andR";
	public static final String AND_L = "andL";
	public static final String AND_MINUS_L = "andMinusL";

	public Operator getOperatorClass(String andType) throws OperatorNotFoundException {
		switch (andType) {
		case AND_R:
			return new AndR();
		case AND_L:
			return new AndL();
		case AND_MINUS_L:
			return new AndMinusL();
		default:
			throw new OperatorNotFoundException(andType);
		}
	}

}
