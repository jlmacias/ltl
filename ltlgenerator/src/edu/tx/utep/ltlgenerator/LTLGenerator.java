package edu.tx.utep.ltlgenerator;

import edu.tx.utep.ltlgenerator.exceptions.TemplateNotFoundException;
import edu.tx.utep.ltlgenerator.factories.TemplateFactory;
import edu.tx.utep.ltlgenerator.templates.Template;

public class LTLGenerator {

	public String generateLTLFormula(String templateName, String pProposition, String qProposition, String rProposition, String lProposition) {

		Template template;
		try {
		
			template = new TemplateFactory().getTemplate(templateName, qProposition);
			String formula = template.generateFormula(pProposition, qProposition, rProposition, lProposition);
			return replaceOperatorStrings(formula);

		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	private String replaceOperatorStrings(String formula) {
		formula = formula.replace(OutputCharacters.O_AND, OutputCharacters.AND);
		formula = formula.replace(OutputCharacters.O_CLOSE_P, OutputCharacters.CLOSE_P);
		formula = formula.replace(OutputCharacters.O_OPEN_P, OutputCharacters.OPEN_P);
		return formula;
	}

}
