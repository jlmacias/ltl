package edu.tx.utep.ltlgenerator.templates;

import java.util.ArrayList;
import java.util.List;

public class AfterL extends Template {

	private String template = "!((!L) U (L &l !Pg))";
	private Template globalTemplate;
	
	public AfterL(Template globalTemplate){
		this.globalTemplate = globalTemplate;
	}
	
	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		String pg = globalTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);
		List<String> l = getCompositeProposition(lProposition);
		String lString = String.join("", l);
		
		List<String> notP = new ArrayList<String>();
		notP.add("!(");
		notP.add(pg);
		notP.add(")");
		
		String andedP = operatorGenerator.getAndedPropositions(AND_L, l, notP);
		formula = formula.replace("(L &l !Pg)", andedP);
		
		formula = formula.replace("L", lString);

		return formula;
	}

}
