package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.cps.*;

// Factory Pattern
public class CPFactory {

	public CompositeProposition getCPClass(String cpName) {
		if (cpName.equals("AtLeastOneC"))
			return new AtLeastOneC();

		if (cpName.equals("AtLeastOneH"))
			return new AtLeastOneH();

		if (cpName.equals("AtLeastOneE"))
			return new AtLeastOneE();

		if (cpName.equals("ParallelC"))
			return new ParallelC();

		if (cpName.equals("ParallelH"))
			return new ParallelH();

		if (cpName.equals("ParallelE"))
			return new ParallelE();

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

		if (cpName.equals("ParallelInverse"))
			return new ParallelInverse();

		return null;
	}


}
