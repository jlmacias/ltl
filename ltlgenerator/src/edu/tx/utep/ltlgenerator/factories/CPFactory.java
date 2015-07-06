package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.cps.AtLeastOneC;
import edu.tx.utep.ltlgenerator.cps.AtLeastOneE;
import edu.tx.utep.ltlgenerator.cps.CompositeProposition;
import edu.tx.utep.ltlgenerator.cps.ConsecutiveC;
import edu.tx.utep.ltlgenerator.cps.ConsecutiveE;
import edu.tx.utep.ltlgenerator.cps.ConsecutiveH;
import edu.tx.utep.ltlgenerator.cps.EventualC;
import edu.tx.utep.ltlgenerator.cps.EventualE;
import edu.tx.utep.ltlgenerator.cps.EventualH;
import edu.tx.utep.ltlgenerator.cps.ParallelC;
import edu.tx.utep.ltlgenerator.cps.ParallelE;
import edu.tx.utep.ltlgenerator.cps.ParallelInverse;

// Factory Pattern
public class CPFactory {

	public CompositeProposition getCPClass(String cpName) {
		if (cpName.equals("AtLeastOneC"))
			return new AtLeastOneC();

		if (cpName.equals("AtLeastOneH"))
			return new AtLeastOneC();

		if (cpName.equals("AtLeastOneE"))
			return new AtLeastOneE();

		if (cpName.equals("ParallelC"))
			return new ParallelC();

		if (cpName.equals("ParallelH"))
			return new ParallelC();

		if (cpName.equals("ParallelE"))
			return new ParallelE();

		if (cpName.equals("ParallelInverse"))
			return new ParallelInverse();

		if (cpName.equals("ConsecutiveC"))
			return new ConsecutiveC();

		if (cpName.equals("ConsecutiveH"))
			return new ConsecutiveH();

		if (cpName.equals("ConsecutiveE"))
			return new ConsecutiveE();

		if (cpName.equals("EventualC"))
			return new EventualC();

		if (cpName.equals("EventualH"))
			return new EventualH();

		if (cpName.equals("EventualE"))
			return new EventualE();

		return null;
	}


}
