package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.templates.AfterL;
import edu.tx.utep.ltlgenerator.templates.Template;
import edu.tx.utep.ltlgenerator.templates.beforer.AbsenceOfPBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.ExistenceOfPBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.ExistenceOfPBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.QPrecedesPcBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.QPrecedesPcBeforeRe;
import edu.tx.utep.ltlgenerator.templates.global.GlobalAbsenceOfP;
import edu.tx.utep.ltlgenerator.templates.global.GlobalExistanceOfP;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPCPlus;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPCStar;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPEPlus;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPEStar;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQRespondsToP;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQStrictlyPrecedesPE;

// Factory Pattern
public class TemplateFactory {

	public Template getTemplate(String templateName, String qProposition) {

		// Global
		if (templateName.equals("GlobalAbsenceOfP"))
			return new GlobalAbsenceOfP();

		if (templateName.equals("GlobalExistanceOfP"))
			return new GlobalExistanceOfP();

		if (templateName.equals("GlobalQRespondsToP"))
			return new GlobalQRespondsToP();

		if (templateName.equals("GlobalQPrecedesPE"))
			return getGlobalQPrecedesPE(qProposition);

		if (templateName.equals("GlobalQPrecedesPC"))
			return getGlobalQPrecedesPC(qProposition);

		if (templateName.equals("GlobalQStrictlyPrecedesPE"))
			return new GlobalQStrictlyPrecedesPE();

		// if (templateName.equals("GlobalQStrictlyPrecedesPC"))
		// return new GlobalQStrictlyPrecedesPC();

		// Before R
		if (templateName.equals("AbsenceOfPBeforeRe"))
			return new AbsenceOfPBeforeRe();

		if (templateName.equals("ExistenceOfPBeforeRc"))
			return new ExistenceOfPBeforeRc();

		if (templateName.equals("ExistenceOfPBeforeRe"))
			return new ExistenceOfPBeforeRe();

		if (templateName.equals("QPrecedesPcBeforeRc"))
			return new QPrecedesPcBeforeRc();

		if (templateName.equals("QPrecedesPcBeforeRe"))
			return new QPrecedesPcBeforeRe();

		// After L
		if (templateName.equals("AbsenceOfPAfterL"))
			return new AfterL(new GlobalAbsenceOfP());

		if (templateName.equals("ExistanceOfPAfterL"))
			return new AfterL(new GlobalExistanceOfP());

		if (templateName.equals("QRespondsToPAfterL"))
			return new AfterL(new GlobalQRespondsToP());

		// if (templateName.equals("QStrictlyPrecedesPcAfterL"))
		// return new AfterL(new GlobalQStrictlyPrecedesPc());

		if (templateName.equals("QStrictlyPrecedesPeAfterL"))
			return new AfterL(new GlobalQStrictlyPrecedesPE());

		if (templateName.equals("GlobalQPrecedesPcAfterL")) {
			return new AfterL(getGlobalQPrecedesPC(qProposition));
		}

		if (templateName.equals("GlobalQPrecedesPeAfterL")) {
			return new AfterL(getGlobalQPrecedesPE(qProposition));
		}

		return null;
	}

	private Template getGlobalQPrecedesPE(String qProposition) {
		boolean isOfTypeStar = (qProposition.contains("Q_AtLeastOneC") || qProposition.contains("Q_ParallelC"));
		if (isOfTypeStar)
			return new GlobalQPrecedesPEStar();
		else
			return new GlobalQPrecedesPEPlus();
	}

	private Template getGlobalQPrecedesPC(String qProposition) {
		boolean isOfTypeStar = (qProposition.contains("Q_AtLeastOneC") || qProposition.contains("Q_ParallelC"));
		if (isOfTypeStar)
			return new GlobalQPrecedesPCStar();
		else
			return new GlobalQPrecedesPCPlus();
	}
}
