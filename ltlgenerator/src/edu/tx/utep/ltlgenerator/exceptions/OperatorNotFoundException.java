package edu.tx.utep.ltlgenerator.exceptions;

public class OperatorNotFoundException extends Exception {

	private static final long serialVersionUID = -2557991501578287178L;

	public OperatorNotFoundException() {
	}

	public OperatorNotFoundException(String operatorName) {
		super("No Operator class found for " + operatorName);
	}

}
