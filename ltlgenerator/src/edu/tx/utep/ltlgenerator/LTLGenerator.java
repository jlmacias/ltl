package edu.tx.utep.ltlgenerator;

import edu.tx.utep.ltlgenerator.factories.TemplateFactory;
import edu.tx.utep.ltlgenerator.templates.Template;

public class LTLGenerator {

	public String generateLTLFormula(String templateName, String pProposition, String qProposition, String rProposition, String lProposition) {

		Template template = new TemplateFactory().getTemplate(templateName, qProposition);
		String formula = template.generateFormula(pProposition, qProposition, rProposition, lProposition);
		return formula;
	}

}
