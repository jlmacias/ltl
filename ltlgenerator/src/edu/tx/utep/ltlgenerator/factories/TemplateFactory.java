package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.templates.AfterL;
import edu.tx.utep.ltlgenerator.templates.Template;
import edu.tx.utep.ltlgenerator.templates.beforer.*;
import edu.tx.utep.ltlgenerator.templates.global.GlobalAbsenceOfP;
import edu.tx.utep.ltlgenerator.templates.global.GlobalExistenceOfP;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPCPlus;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPCStar;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPEPlus;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQPrecedesPEStar;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQRespondsToP;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQStrictlyPrecedesPC;
import edu.tx.utep.ltlgenerator.templates.global.GlobalQStrictlyPrecedesPE;

// Factory Pattern
public class TemplateFactory {

	public Template getTemplate(String templateName, String qProposition) {

		// Global
		if (templateName.equals("GlobalAbsenceOfP"))
			return new GlobalAbsenceOfP();

		if (templateName.equals("GlobalExistenceOfP"))
			return new GlobalExistenceOfP();

		if (templateName.equals("GlobalQRespondsToP"))
			return new GlobalQRespondsToP();

		if (templateName.equals("GlobalQPrecedesPE"))
			return getGlobalQPrecedesPE(qProposition);

		if (templateName.equals("GlobalQPrecedesPC"))
			return getGlobalQPrecedesPC(qProposition);

		if (templateName.equals("GlobalQStrictlyPrecedesPC"))
			return new GlobalQStrictlyPrecedesPC();

		if (templateName.equals("GlobalQStrictlyPrecedesPE"))
			return new GlobalQStrictlyPrecedesPE();

		 if (templateName.equals("GlobalQStrictlyPrecedesPC"))
		 return new GlobalQStrictlyPrecedesPC();

		// Before R
		if (templateName.equals("AbsenceOfPBeforeRc"))
			return new AbsenceOfPBeforeRc();

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

		if (templateName.equals("QStrictlyPrecedesPcBeforeRc"))
			return new QStrictlyPrecedesPcBeforeRc();

		if (templateName.equals("QStrictlyPrecedesPeBeforeRc"))
			return new QStrictlyPrecedesPeBeforeRc();

		if (templateName.equals("QStrictlyPrecedesPcBeforeRe"))
			return new QStrictlyPrecedesPcBeforeRe();

		if (templateName.equals("QStrictlyPrecedesPeBeforeRe"))
			return new QStrictlyPrecedesPeBeforeRe();

		// After L
		if (templateName.equals("AbsenceOfPAfterL"))
			return new AfterL(new GlobalAbsenceOfP());

		if (templateName.equals("ExistenceOfPAfterL"))
			return new AfterL(new GlobalExistenceOfP());

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
