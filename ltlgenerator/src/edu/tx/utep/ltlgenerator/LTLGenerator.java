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
        List<String> p = cpGenerator.getCompositeProposition2(pProposition);
        List<String> q = cpGenerator.getCompositeProposition2(qProposition);
		List<String> r = cpGenerator.getCompositeProposition2(rProposition);
		List<String> l = cpGenerator.getCompositeProposition2(lProposition);
		
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
