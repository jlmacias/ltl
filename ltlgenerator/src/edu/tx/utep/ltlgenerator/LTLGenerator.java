package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.factories.TemplateFactory;
import edu.tx.utep.ltlgenerator.templates.Template;

public class LTLGenerator {

/**/private static String the_P_Proposition;
	private static CPGenerator cpGenerator = new CPGenerator();
	
	public String generateLTLFormula(String templateName, String pProposition, String qProposition, String rProposition, String lProposition) {
/**/    the_P_Proposition=pProposition;
/**/	if (templateName.equals("GlobalQStrictlyPrecedesPE")){       
/**/       pProposition= change_P_PropositionEnding(pProposition);   //change input pProposition ending from 'E' to 'H' 
        }                                                            //because P(LTL)H is asked in the pattern formula
        List<String> p = cpGenerator.getCompositeProposition(pProposition);
        List<String> q = cpGenerator.getCompositeProposition(qProposition);
		List<String> r = cpGenerator.getCompositeProposition(rProposition);
		List<String> l = cpGenerator.getCompositeProposition(lProposition);
		
		Template template = new TemplateFactory().getTemplate(templateName, qProposition);
		String formula = template.generateFormula(p, q, r, l);
		return formula;
	}

/**/private String change_P_PropositionEnding (String targetProposition){
	    StringBuilder changedProposition = new StringBuilder(targetProposition);
	    changedProposition.setCharAt(targetProposition.lastIndexOf('E'), 'H');
	    return changedProposition.toString();
    }
    
/**/public static String getPProposition(){
		return the_P_Proposition;
    }
}
