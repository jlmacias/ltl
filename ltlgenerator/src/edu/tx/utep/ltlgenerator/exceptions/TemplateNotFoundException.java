package edu.tx.utep.ltlgenerator.exceptions;

public class TemplateNotFoundException extends Exception {

	private static final long serialVersionUID = 2279919734523310533L;

	public TemplateNotFoundException() {
	}

	public TemplateNotFoundException(String templateName) {
		super("No Template class found for " + templateName);
	}

}
