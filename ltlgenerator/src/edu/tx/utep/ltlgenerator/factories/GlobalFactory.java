package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.LTLPatternType;


public class GlobalFactory extends LTLGeneratorFactory {
	
	@Override
	public String getLTLFormula(LTLPatternType ltlPatternType, String p, String q, String r, String l){
		switch (ltlPatternType){
			case Absence:
				return ltlGenerator.generateLTLFormula("GlobalAbsenceOfP", p, q, r, l);
			
			case Existence:
				return ltlGenerator.generateLTLFormula("GlobalExistenceOfP", p, q, r, l);
			
			case Response:
				return ltlGenerator.generateLTLFormula("GlobalQRespondsToP", p, q, r, l);
				
			case StricPrecedence:
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("GlobalQStrictlyPrecedesPC", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("GlobalQStrictlyPrecedesPE", p, q, r, l);
				} else {
					return null;
				}
				
			case Precedence:
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("GlobalQPrecedesPE", p, q, r, l);
				} else {
					return null;
				}
				
			default: 
				return null;
				
		}
	}
	
}
