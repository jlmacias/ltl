package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.exceptions.OperatorNotFoundException;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;
import edu.tx.utep.ltlgenerator.operators.Operator;

public class OperatorGenerator {

	public String getAndedPropositions(String andType, List<String> leftSides, List<String> rightSides) {
		
		Operator operator;
		try {
			
			String right = OutputCharacters.O_OPEN_P + String.join("", rightSides) + OutputCharacters.O_CLOSE_P;
			operator = new OperatorFactory().getOperatorClass(andType);
			return operator.andCPs(leftSides, right);
			
		} catch (OperatorNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}