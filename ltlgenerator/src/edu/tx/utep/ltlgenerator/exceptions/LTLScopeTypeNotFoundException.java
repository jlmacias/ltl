package edu.tx.utep.ltlgenerator.exceptions;

public class LTLScopeTypeNotFoundException extends Exception {

	private static final long serialVersionUID = 7203926886624941980L;

	public LTLScopeTypeNotFoundException() {
	}

	public LTLScopeTypeNotFoundException(String cpName) {
		super("No LTLScopeType found for " + cpName);
	}

}
