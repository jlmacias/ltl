package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.LTLPatternType;

public class BeforeRFactory extends LTLGeneratorFactory {

	@Override
	public String getLTLFormula(LTLPatternType ltlPatternType, String p, String q, String r, String l) {
		switch (ltlPatternType){
			case Absence:
				if ( isCompositePropositionOfTypeC(r) ){
					return ltlGenerator.generateLTLFormula("AbsenceOfPBeforeRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(r)) {
					return ltlGenerator.generateLTLFormula("AbsenceOfPBeforeRe", p, q, r, l);
				} else {
					return null;
				}
				
			case Existence:
				if ( isCompositePropositionOfTypeC(r) ){
					return ltlGenerator.generateLTLFormula("ExistenceOfPBeforeRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(r)) {
					return ltlGenerator.generateLTLFormula("ExistenceOfPBeforeRe", p, q, r, l);
				} else {
					return null;
				}
				
			case Response:
				if ( isCompositePropositionOfTypeC(r) ){
					return ltlGenerator.generateLTLFormula("QRespondsToPBeforeRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(r)) {
					return ltlGenerator.generateLTLFormula("QRespondsToPBeforeRe", p, q, r, l);
				} else {
					return null;
				}
				
			case StricPrecedence:
				if ( isCompositePropositionOfTypeC(p) ){
					if ( isCompositePropositionOfTypeC(r) ){
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBeforeRc", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(r)) {
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBeforeRe", p, q, r, l);
					} else {
						return null;
					}
				} else if (isCompositePropositionOfTypeE(p)) {
					if ( isCompositePropositionOfTypeC(r) ){
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBeforeRc", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(r)) {
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBeforeRe", p, q, r, l);
					} else {
						return null;
					}
				} else {
					return null;
				}
				
			case Precedence:
				if ( isCompositePropositionOfTypeC(p) ){
					if ( isCompositePropositionOfTypeC(r) ){
						return ltlGenerator.generateLTLFormula("QPrecedesPcBeforeRc", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(r)) {
						return ltlGenerator.generateLTLFormula("QPrecedesPcBeforeRe", p, q, r, l);
					} else {
						return null;
					}
				} else if (isCompositePropositionOfTypeE(p)) {
					if ( isCompositePropositionOfTypeC(r) ){
						return ltlGenerator.generateLTLFormula("QPrecedesPeBeforeRc", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(r)) {
						return ltlGenerator.generateLTLFormula("QPrecedesPeBeforeRe", p, q, r, l);
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
