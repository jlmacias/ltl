package edu.tx.utep.ltlgenerator;

import edu.tx.utep.ltlgenerator.exceptions.TemplateNotFoundException;
import edu.tx.utep.ltlgenerator.factories.TemplateFactory;
import edu.tx.utep.ltlgenerator.templates.Template;

public class LTLGenerator {

	public String generateLTLFormula(String templateName, String pProposition, String qProposition, String rProposition, String lProposition) {

		try {

			Template template = new TemplateFactory().getTemplate(templateName, qProposition);
			return template.getLTLFormula(pProposition, qProposition, rProposition, lProposition);

		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
