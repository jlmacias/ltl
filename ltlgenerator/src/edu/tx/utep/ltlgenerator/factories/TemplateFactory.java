package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.exceptions.TemplateNotFoundException;
import edu.tx.utep.ltlgenerator.templates.Template;
import edu.tx.utep.ltlgenerator.templates.afterl.AfterL;
import edu.tx.utep.ltlgenerator.templates.afterl.AfterLUntilRc;
import edu.tx.utep.ltlgenerator.templates.beforer.AbsenceOfPBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.AbsenceOfPBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.ExistenceOfPBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.ExistenceOfPBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.QPrecedesPcBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.QPrecedesPcBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.QPrecedesPeBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.QPrecedesPeBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.QRespondsToPBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.QRespondsToPBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.QStrictlyPrecedesPcBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.QStrictlyPrecedesPcBeforeRe;
import edu.tx.utep.ltlgenerator.templates.beforer.QStrictlyPrecedesPeBeforeRc;
import edu.tx.utep.ltlgenerator.templates.beforer.QStrictlyPrecedesPeBeforeRe;
import edu.tx.utep.ltlgenerator.templates.between.BetweenLAndRc;
import edu.tx.utep.ltlgenerator.templates.between.BetweenLAndRe;
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

	public Template getTemplate(String templateName, String qProposition) throws TemplateNotFoundException {

		if (templateName.contains("Global"))
			return getGlobalTemplate(templateName, qProposition);

		if (templateName.contains("BeforeR"))
			return getBeforeRTemplate(templateName);

		if (templateName.contains("BetweenLAndRc"))
			return getBetweenLandRcTemplate(templateName);

		if (templateName.contains("BetweenLAndRe"))
			return getBetweenLAndRe(templateName);

		if (templateName.contains("AfterLUntilRc"))
			return getAfterLUntilRc(templateName);

		if (templateName.contains("AfterLUntilRe"))
			return getAfterLUntilRe(templateName);

		if (templateName.contains("AfterL"))
			return getAfterLTemplate(templateName, qProposition);

		throw new TemplateNotFoundException(templateName);
	}

	private Template getAfterLUntilRe(String templateName) throws TemplateNotFoundException {
		throw new TemplateNotFoundException(templateName);
	}

	private Template getAfterLUntilRc(String templateName) throws TemplateNotFoundException {
		// 1. Absence Of P
		if (templateName.equals("AbsenceOfPAfterLUntilRc")) {
			return new AfterLUntilRc(new GlobalAbsenceOfP(), new AbsenceOfPBeforeRc());
		}

		throw new TemplateNotFoundException(templateName);
	}

	private Template getBetweenLAndRe(String templateName) throws TemplateNotFoundException {
		// 1. Absence Of P
		if (templateName.equals("AbsenceOfPBetweenLAndRe")) {
			return new BetweenLAndRe(new AbsenceOfPBeforeRe());
		}

		// 2. Existence Of P
		if (templateName.equals("ExistenceOfPBetweenLAndRe")) {
			return new BetweenLAndRe(new ExistenceOfPBeforeRe());
		}

		// 3. Q Precedes Pc
		if (templateName.equals("QPrecedesPcBetweenLAndRe")) {
			return new BetweenLAndRe(new QPrecedesPcBeforeRe());
		}

		// 4. Q Precedes Pe
		if (templateName.equals("QPrecedesPeBetweenLAndRe")) {
			return new BetweenLAndRe(new QPrecedesPeBeforeRe());
		}

		// 5. Q Strictly Precedes Pc
		if (templateName.equals("QStrictlyPrecedesPcBetweenLAndRe")) {
			return new BetweenLAndRe(new QStrictlyPrecedesPcBeforeRe());
		}

		// 6. Q Strictly Precedes Pe
		if (templateName.equals("QStrictlyPrecedesPeBetweenLAndRe")) {
			return new BetweenLAndRe(new QStrictlyPrecedesPeBeforeRe());
		}

		// 7. Q Responds to P Between L And Rc
		if (templateName.equals("QRespondsToPBetweenLAndRe")) {
			return new BetweenLAndRe(new QRespondsToPBeforeRe());
		}

		throw new TemplateNotFoundException(templateName);
	}

	private Template getBetweenLandRcTemplate(String templateName) throws TemplateNotFoundException {
		// 1. Absence Of P
		if (templateName.equals("AbsenceOfPBetweenLAndRc")) {
			return new BetweenLAndRc(new AbsenceOfPBeforeRc());
		}

		// 2. Existence Of P
		if (templateName.equals("ExistenceOfPBetweenLAndRc")) {
			return new BetweenLAndRc(new ExistenceOfPBeforeRc());
		}

		// 3. Q Precedes Pc
		if (templateName.equals("QPrecedesPcBetweenLAndRc")) {
			return new BetweenLAndRc(new QPrecedesPcBeforeRc());
		}

		// 4. Q Precedes Pe
		if (templateName.equals("QPrecedesPeBetweenLAndRc")) {
			return new BetweenLAndRc(new QPrecedesPeBeforeRc());
		}

		// 5. Q Strictly Precedes Pc
		if (templateName.equals("QStrictlyPrecedesPcBetweenLAndRc")) {
			return new BetweenLAndRc(new QStrictlyPrecedesPcBeforeRc());
		}

		// 6. Q Strictly Precedes Pe
		if (templateName.equals("QStrictlyPrecedesPeBetweenLAndRc")) {
			return new BetweenLAndRc(new QStrictlyPrecedesPeBeforeRc());
		}

		// 7. Q Responds to P Between L And Rc
		if (templateName.equals("QRespondsToPBetweenLAndRc")) {
			return new BetweenLAndRc(new QRespondsToPBeforeRc());
		}

		throw new TemplateNotFoundException(templateName);
	}

	private Template getAfterLTemplate(String templateName, String qProposition) throws TemplateNotFoundException {
		if (templateName.equals("AbsenceOfPAfterL")) {
			return new AfterL(new GlobalAbsenceOfP());
		}

		if (templateName.equals("ExistenceOfPAfterL")) {
			return new AfterL(new GlobalExistenceOfP());
		}

		if (templateName.equals("QRespondsToPAfterL")) {
			return new AfterL(new GlobalQRespondsToP());
		}

		if (templateName.equals("QStrictlyPrecedesPcAfterL")) {
			return new AfterL(new GlobalQStrictlyPrecedesPC());
		}

		if (templateName.equals("QStrictlyPrecedesPeAfterL")) {
			return new AfterL(new GlobalQStrictlyPrecedesPE());
		}

		if (templateName.equals("QPrecedesPcAfterL")) {
			return new AfterL(getGlobalQPrecedesPC(qProposition));
		}

		if (templateName.equals("QPrecedesPeAfterL")) {
			return new AfterL(getGlobalQPrecedesPE(qProposition));
		}

		throw new TemplateNotFoundException(templateName);
	}

	private Template getBeforeRTemplate(String templateName) throws TemplateNotFoundException {
		if (templateName.equals("AbsenceOfPBeforeRc")) {
			return new AbsenceOfPBeforeRc();
		}

		if (templateName.equals("AbsenceOfPBeforeRe")) {
			return new AbsenceOfPBeforeRe();
		}

		if (templateName.equals("ExistenceOfPBeforeRc")) {
			return new ExistenceOfPBeforeRc();
		}

		if (templateName.equals("ExistenceOfPBeforeRe")) {
			return new ExistenceOfPBeforeRe();
		}

		if (templateName.equals("QPrecedesPcBeforeRc")) {
			return new QPrecedesPcBeforeRc();
		}

		if (templateName.equals("QPrecedesPcBeforeRe")) {
			return new QPrecedesPcBeforeRe();
		}

		if (templateName.equals("QPrecedesPeBeforeRc")) {
			return new QPrecedesPeBeforeRc();
		}

		if (templateName.equals("QPrecedesPeBeforeRe")) {
			return new QPrecedesPeBeforeRe();
		}

		if (templateName.equals("QRespondsToPBeforeRc")) {
			return new QRespondsToPBeforeRc();
		}

		if (templateName.equals("QRespondsToPBeforeRe")) {
			return new QRespondsToPBeforeRe();
		}

		if (templateName.equals("QStrictlyPrecedesPcBeforeRc")) {
			return new QStrictlyPrecedesPcBeforeRc();
		}

		if (templateName.equals("QStrictlyPrecedesPeBeforeRc")) {
			return new QStrictlyPrecedesPeBeforeRc();
		}

		if (templateName.equals("QStrictlyPrecedesPcBeforeRe")) {
			return new QStrictlyPrecedesPcBeforeRe();
		}

		if (templateName.equals("QStrictlyPrecedesPeBeforeRe")) {
			return new QStrictlyPrecedesPeBeforeRe();
		}

		throw new TemplateNotFoundException(templateName);
	}

	private Template getGlobalTemplate(String templateName, String qProposition) throws TemplateNotFoundException {
		if (templateName.equals("GlobalAbsenceOfP")) {
			return new GlobalAbsenceOfP();
		}

		if (templateName.equals("GlobalExistenceOfP")) {
			return new GlobalExistenceOfP();
		}

		if (templateName.equals("GlobalQPrecedesPE")) {
			return getGlobalQPrecedesPE(qProposition);
		}

		if (templateName.equals("GlobalQPrecedesPC")) {
			return getGlobalQPrecedesPC(qProposition);
		}

		if (templateName.equals("GlobalQPrecedesPCPlus")) {
			return new GlobalQPrecedesPCPlus();
		}

		if (templateName.equals("GlobalQPrecedesPCStar")) {
			return new GlobalQPrecedesPCStar();
		}

		if (templateName.equals("GlobalQPrecedesPEPlus")) {
			return new GlobalQPrecedesPEPlus();
		}

		if (templateName.equals("GlobalQPrecedesPEStar")) {
			return new GlobalQPrecedesPEStar();
		}

		if (templateName.equals("GlobalQRespondsToP")) {
			return new GlobalQRespondsToP();
		}

		if (templateName.equals("GlobalQStrictlyPrecedesPC")) {
			return new GlobalQStrictlyPrecedesPC();
		}

		if (templateName.equals("GlobalQStrictlyPrecedesPE")) {
			return new GlobalQStrictlyPrecedesPE();
		}

		throw new TemplateNotFoundException(templateName);
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
