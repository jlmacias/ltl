package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

public abstract class Operator {

	protected static final String AND = " & ";
	protected static final String OPEN_P = "[";
	protected static final String CLOSE_P = "]";
	protected static final String NEXT = "X";

	protected abstract String andCPs(List<String> leftSides, String rightSides);
	
	// Template Method Pattern
	public String getCombinedCPs(List<String> leftSides, String rightSides){
		return andCPs(leftSides, rightSides);
	}
}
