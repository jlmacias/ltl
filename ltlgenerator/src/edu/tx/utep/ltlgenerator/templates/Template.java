package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

import edu.tx.utep.ltlgenerator.OperatorGenerator;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;


public abstract class Template {

	public abstract String generateFormula(List<String> p, List<String> q, List<String> r, List<String> l);
	protected OperatorGenerator operatorGenerator = new OperatorGenerator();
	
	protected static final String AND_L = OperatorFactory.AND_L;
	protected static final String AND_R = OperatorFactory.AND_R;
	protected static final String AND_MINUS_L = OperatorFactory.AND_MINUS_L;

	
	// Template Method Pattern
	public String getLTLFormula(List<String> p, List<String> q, List<String> r, List<String> l){
		return generateFormula(p, q, r, l);
	}

}
