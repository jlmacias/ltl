package edu.tx.utep.ltlgenerator.templates.afterl;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class AfterL extends Template {

	// L &l !Pg
	private String lAndNotPg = "L &l " + OutputCharacters.NOT + "Pg";

	// !((!L) U (L &l !Pg))
	private String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + "L" + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL +
			OutputCharacters.OPEN_P + lAndNotPg + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

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
		notP.add(OutputCharacters.NOT);
		notP.add(OutputCharacters.OPEN_P);
		notP.add(pg);
		notP.add(OutputCharacters.CLOSE_P);
		
		String andedP = operatorGenerator.getAndedPropositions(AND_L, l, notP);
		formula = formula.replace(lAndNotPg, andedP);
		
		formula = formula.replace("L", lString);

		return formula;
	}

}
