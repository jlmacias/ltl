package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

// Strategy Pattern
public interface Operator {

	public String andCPs(List<String> leftSides, String rightSides);

}
