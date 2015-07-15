package edu.tx.utep.ltlgenerator;

import java.util.List;

import edu.tx.utep.ltlgenerator.cps.CompositeProposition;
import edu.tx.utep.ltlgenerator.factories.CPFactory;

public class CPGenerator {

	public String getCompositeProposition(String cp) {
		String[] splitCP = cp.split("_");
		String letter = splitCP[0].toLowerCase();
		String cpName = splitCP[1];
		String countS = splitCP[2];

		int count = Integer.parseInt(countS);

		CompositeProposition cpClass = new CPFactory().getCPClass(cpName);
		if (cpClass != null)
			return cpClass.generateLTLFormulaString(letter, count);

		return "No CP Class for " + cpName;
	}

	public List<String> getCompositeProposition2(String cp) {
		if(cp == null || cp.length() == 0)
			return null;
		
		String[] splitCP = cp.split("_");
		String letter = splitCP[0].toLowerCase();
		String cpName = splitCP[1];
		String countS = splitCP[2];

		int count = Integer.parseInt(countS);

		CompositeProposition cpClass = new CPFactory().getCPClass(cpName);
		if (cpClass != null)
			return cpClass.generateLTLFormulaArray(letter, count);

		return null;
	}

}