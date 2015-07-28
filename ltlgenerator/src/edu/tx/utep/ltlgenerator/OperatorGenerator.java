package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.exceptions.OperatorNotFoundException;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;
import edu.tx.utep.ltlgenerator.operators.Operator;

public class OperatorGenerator {

	public String getAndedPropositions(String andType, List<String> leftSides, List<String> rightSides) {
		String right = OutputCharacters.O_OPEN_P + String.join("", rightSides) + OutputCharacters.O_CLOSE_P;
		Operator operator;
		try {
			operator = new OperatorFactory().getOperatorClass(andType);

			if (operator != null)
				return operator.andCPs(leftSides, right);
		} catch (OperatorNotFoundException e) {
			e.printStackTrace();
		}

		return "No Operator class of " + andType;

	}

}