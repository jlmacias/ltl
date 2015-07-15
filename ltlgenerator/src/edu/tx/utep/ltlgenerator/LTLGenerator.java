package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.factories.TemplateFactory;
import edu.tx.utep.ltlgenerator.templates.Template;

public class LTLGenerator {

	private static CPGenerator cpGenerator = new CPGenerator();
	
	public String generateLTLFormula(String templateName, String pProposition, String qProposition, String rProposition, String lProposition) {
		List<String> p = cpGenerator.getCompositeProposition2(pProposition);
		List<String> q = cpGenerator.getCompositeProposition2(qProposition);
		List<String> r = cpGenerator.getCompositeProposition2(rProposition);
		List<String> l = cpGenerator.getCompositeProposition2(lProposition);
		
		Template template = new TemplateFactory().getTemplate(templateName, qProposition);
		String formula = template.generateFormula(p, q, r, l);
		return formula;
	}
}
