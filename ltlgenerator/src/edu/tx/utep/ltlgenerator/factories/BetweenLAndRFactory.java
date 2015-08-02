package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.LTLPatternType;

public class BetweenLAndRFactory extends LTLGeneratorFactory {

	@Override
	public String getLTLFormula(LTLPatternType ltlPatternType, String p, String q, String r, String l) {
		switch (ltlPatternType){
			case Absence:
				if ( isCompositePropositionOfTypeC(r) ){
					return ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(r)) {
					return ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRe", p, q, r, l);
				} else {
					return null;
				}
				
			case Existence:
				if ( isCompositePropositionOfTypeC(r) ){
					return ltlGenerator.generateLTLFormula("ExistenceOfPBetweenLAndRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(r)) {
					return ltlGenerator.generateLTLFormula("ExistenceOfPBetweenLAndRe", p, q, r, l);
				} else {
					return null;
				}
				
			case Response:
				if ( isCompositePropositionOfTypeC(r) ){
					return ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRc", p, q, r, l);
				} else if (isCompositePropositionOfTypeE(r)) {
					return ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRe", p, q, r, l);
				} else {
					return null;
				}
				
			case StricPrecedence:
				if ( isCompositePropositionOfTypeC(r) ){
					if ( isCompositePropositionOfTypeC(p) ){
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBetweenLAndRc", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(p)) {
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBetweenLAndRc", p, q, r, l);
					} else {
						return null;
					}
				} else if (isCompositePropositionOfTypeE(r)) {
					if ( isCompositePropositionOfTypeC(p) ){
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBetweenLAndRe", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(p)) {
						return ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBetweenLAndRe", p, q, r, l);
					} else {
						return null;
					}
				} else {
					return null;
				}
				
			case Precedence:
				if ( isCompositePropositionOfTypeC(r) ){
					if ( isCompositePropositionOfTypeC(p) ){
						return ltlGenerator.generateLTLFormula("QPrecedesPcBetweenLAndRc", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(p)) {
						return ltlGenerator.generateLTLFormula("QPrecedesPeBetweenLAndRc", p, q, r, l);
					} else {
						return null;
					}
				} else if (isCompositePropositionOfTypeE(r)) {
					if ( isCompositePropositionOfTypeC(p) ){
						return ltlGenerator.generateLTLFormula("QPrecedesPcBetweenLAndRe", p, q, r, l);
					} else if (isCompositePropositionOfTypeE(p)) {
						return ltlGenerator.generateLTLFormula("QPrecedesPeBetweenLAndRe", p, q, r, l);
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
