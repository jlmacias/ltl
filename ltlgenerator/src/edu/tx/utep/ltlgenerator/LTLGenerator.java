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
			return formula;

		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
