package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.templates.GlobalAbsenceOfP;
import edu.tx.utep.ltlgenerator.templates.GlobalExistanceOfP;
import edu.tx.utep.ltlgenerator.templates.GlobalQPrecedesPCPlus;
import edu.tx.utep.ltlgenerator.templates.GlobalQPrecedesPCStar;
import edu.tx.utep.ltlgenerator.templates.GlobalQPrecedesPEPlus;
import edu.tx.utep.ltlgenerator.templates.GlobalQPrecedesPEStar;
import edu.tx.utep.ltlgenerator.templates.GlobalQRespondsToP;
import edu.tx.utep.ltlgenerator.templates.Template;

// Factory Pattern
public class TemplateFactory {

	public Template getTemplate(String templateName, String qProposition) {
		if (templateName.equals("GlobalAbsenceOfP"))
			return new GlobalAbsenceOfP();
		
		if (templateName.equals("GlobalExistanceOfP"))
			return new GlobalExistanceOfP();
		
		if (templateName.equals("GlobalQRespondsToP"))
			return new GlobalQRespondsToP();
	
		if (templateName.equals("GlobalQPrecedesPE")) {
			Boolean isOfTypeStar = ( qProposition.contains("Q_AtLeastOneC") || qProposition.contains("Q_ParallelC") );
			if ( isOfTypeStar )
				return new GlobalQPrecedesPEStar();
			else
				return new GlobalQPrecedesPEPlus();
		}
		
		if (templateName.equals("GlobalQPrecedesPC")) {
			Boolean isOfTypeStar = ( qProposition.contains("Q_AtLeastOneC") || qProposition.contains("Q_ParallelC") );
			if ( isOfTypeStar )
				return new GlobalQPrecedesPCStar();
			else
				return new GlobalQPrecedesPCPlus();
		}
		
		return null;
	}
}
