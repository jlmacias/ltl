package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.LTLPatternType;

public class AfterLUntilRFactory extends LTLGeneratorFactory {

	@Override
	public String getLTLFormula(LTLPatternType ltlPatternType, String p, String q, String r, String l) {
		switch (ltlPatternType){
		case Absence:
			if ( isCompositePropositionOfTypeC(r) ){
				return ltlGenerator.generateLTLFormula("AbsenceOfPAfterLUntilRc", p, q, r, l);
			} else if (isCompositePropositionOfTypeE(r)) {
				return ltlGenerator.generateLTLFormula("AbsenceOfPAfterLUntilRe", p, q, r, l);
			} else {
				return null;
			}
			
		case Existence:
			if ( isCompositePropositionOfTypeC(r) ){
				return ltlGenerator.generateLTLFormula("ExistenceOfPAfterLUntilRc", p, q, r, l);
			} else if (isCompositePropositionOfTypeE(r)) {
				return ltlGenerator.generateLTLFormula("ExistenceOfPAfterLUntilRe", p, q, r, l);
			} else {
				return null;
			}
			
		case Response:
			if ( isCompositePropositionOfTypeC(r) ){
				return ltlGenerator.generateLTLFormula("QRespondsToPAfterLUntilRc", p, q, r, l);
			} else if (isCompositePropositionOfTypeE(r)) {
				return ltlGenerator.generateLTLFormula("QRespondsToPAfterLUntilRe", p, q, r, l);
			} else {
				return null;
			}
			
		case StricPrecedence:
			if ( isCompositePropositionOfTypeC(r) ){
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcAfterLUntilRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeAfterLUntilRc", p, q, r, l);
				} else {
					return null;
				}
			} else if (isCompositePropositionOfTypeE(r)) {
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcAfterLUntilRe", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeAfterLUntilRe", p, q, r, l);
				} else {
					return null;
				}
			} else {
				return null;
			}
			
		case Precedence:
			if ( isCompositePropositionOfTypeC(r) ){
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("QPrecedesPcAfterLUntilRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("QPrecedesPeAfterLUntilRc", p, q, r, l);
				} else {
					return null;
				}
			} else if (isCompositePropositionOfTypeE(r)) {
				if ( isCompositePropositionOfTypeC(p) ){
					return ltlGenerator.generateLTLFormula("QPrecedesPcAfterLUntilRe", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(p)) {
					return ltlGenerator.generateLTLFormula("QPrecedesPeAfterLUntilRe", p, q, r, l);
				} else {
					return null;
				}
			} else {
				return null;
			}
			
		default: 
			return null;
	}
	}

}
