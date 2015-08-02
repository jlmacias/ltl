package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.LTLPatternType;

public class AfterLFactory extends LTLGeneratorFactory {

	@Override
	public String getLTLFormula(LTLPatternType ltlPatternType, String p, String q, String r, String l) {
		switch (ltlPatternType){
			case Absence:
				return ltlGenerator.generateLTLFormula("AbsenceOfPAfterL", p, q, r, l);
				
			case Existence:
				return ltlGenerator.generateLTLFormula("ExistenceOfPAfterL", p, q, r, l);
				
			case Response:
				return ltlGenerator.generateLTLFormula("QRespondsToPAfterL", p, q, r, l);
				
			case StricPrecedence:
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcAfterL", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeAfterL", p, q, r, l);
				} else {
					return null;
				}
				
			case Precedence:
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("QPrecedesPcAfterL", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("QPrecedesPeAfterL", p, q, r, l);
				} else {
					return null;
				}
				
			default: 
				return null;
		}
	}

}
