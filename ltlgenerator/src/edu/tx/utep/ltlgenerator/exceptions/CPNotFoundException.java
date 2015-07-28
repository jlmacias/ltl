package edu.tx.utep.ltlgenerator.exceptions;

public class CPNotFoundException extends Exception {

	private static final long serialVersionUID = 7203926886624941980L;

	public CPNotFoundException() {
	}

	public CPNotFoundException(String cpName) {
		super("No Composite Proposition class found for " + cpName);
	}

}
