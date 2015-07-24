package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.factories.OperatorFactory;
import edu.tx.utep.ltlgenerator.operators.Operator;

public class OperatorGenerator {

	public String getAndedPropositions(String andType, List<String> leftSides, List<String> rightSides) {
		String right = "[" + String.join("", rightSides) + "]";
		Operator operator = new OperatorFactory().getOperatorClass(andType);

		if (operator != null)
			return operator.getCombinedCPs(leftSides, right);

		return "No Operator class of " + andType;

	}

}