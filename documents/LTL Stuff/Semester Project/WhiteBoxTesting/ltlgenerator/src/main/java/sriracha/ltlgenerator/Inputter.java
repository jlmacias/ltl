package sriracha.ltlgenerator;

import java.util.Scanner;

import sriracha.ltlgenerator.cpclasses.AtLeastOneC;
import sriracha.ltlgenerator.cpclasses.AtLeastOneE;
import sriracha.ltlgenerator.cpclasses.ConsecutiveC;
import sriracha.ltlgenerator.cpclasses.ConsecutiveE;
import sriracha.ltlgenerator.cpclasses.EventualC;
import sriracha.ltlgenerator.cpclasses.EventualE;
import sriracha.ltlgenerator.cpclasses.ParallelC;
import sriracha.ltlgenerator.cpclasses.ParallelE;
import sriracha.ltlgenerator.proposition.LProposition;
import sriracha.ltlgenerator.proposition.PProposition;
import sriracha.ltlgenerator.proposition.QProposition;
import sriracha.ltlgenerator.proposition.RProposition;

public class Inputter {

	public String [] inputForCP(){
		Scanner input = new Scanner(System.in);
		System.out.println( "Number of propositios for L:" );
		int numPropL = input.nextInt();

		System.out.println( "Number of propositios for R:" );
		int numPropR = input.nextInt();

		System.out.println( "Number of propositios for P:" );
		int numPropP = input.nextInt();

		System.out.println( "Number of propositios for Q:" );
		int numPropQ = input.nextInt();

		System.out.println("Here is a list of CP's for L, Select one:");
		System.out.println("1. AtleastOneC\n2. AtleastOneE\n3. ConsecutiveC\n4. ConsecutiveE" +
				"\n5. EventualC\n6. EventualE\n7. ParallelC\n8. ParallelE");

		int	cpChoiceL = input.nextInt();

		System.out.println("Here is a list of CP's for R, Select one:");
		System.out.println("1. AtleastOneC\n2. ConsecutiveC\n" +
				"3. EventualC\n4. ParallelC");

		int cpChoiceR = input.nextInt();

		System.out.println("Here is a list of CP's for P, Select one:");
		System.out.println("1. AtleastOneC\n2. AtleastOneE\n3. ConsecutiveC\n4. ConsecutiveE" +
				"\n5. EventualC\n6. EventualE\n7. ParallelC\n8. ParallelE");

		int cpChoiceP = input.nextInt();

		System.out.println("Here is a list of CP's for L, Select one:");
		System.out.println("1. AtleastOneC\n2. AtleastOneE\n3. ConsecutiveC\n4. ConsecutiveE" +
				"\n5. EventualC\n6. EventualE\n7. ParallelC\n8. ParallelE");

		int cpChoiceQ = input.nextInt();

		//Propositions
		LProposition l = new LProposition(numPropL);
		RProposition r = new RProposition(numPropR);
		PProposition p = new PProposition(numPropP);
		QProposition q = new QProposition(numPropQ);
		
		String cp_L = "";
		String cp_R = "";
		String cp_P = "";
		String cp_Q = "";

		if(cpChoiceL == 1){
			AtLeastOneC cpL = new AtLeastOneC(l);
			cp_L = cpL.getCPFormula();
		}
		if(cpChoiceL == 2){
			AtLeastOneE cpL = new AtLeastOneE(l);
			cp_L = cpL.getCPFormula();
		}
		if(cpChoiceL == 3){
			ConsecutiveC cpL = new ConsecutiveC(l);
			cp_L = cpL.getCPFormula();
		}
		if(cpChoiceL == 4){
			ConsecutiveE cpL = new ConsecutiveE(l);
			cp_L = cpL.getCPFormula();
		}
		if(cpChoiceL == 5){
			EventualC cpL = new EventualC(l);
			cp_L = cpL.getCPFormula();
		}
		if(cpChoiceL == 6){
			EventualE cpL = new EventualE(l);
			cp_L = cpL.getCPFormula();
		}
		if(cpChoiceL == 7){
			ParallelC cpL = new ParallelC(l);
			cp_L = cpL.getCPFormula();
		}
		if(cpChoiceL == 8){
			ParallelE cpL = new ParallelE(l);
			cp_L = cpL.getCPFormula();
		}
		//////////R
		if(cpChoiceR == 1){
			AtLeastOneC cpR = new AtLeastOneC(r);
			cp_R = cpR.getCPFormula();
		}
		if(cpChoiceR == 2){
			ConsecutiveC cpR = new ConsecutiveC(r);
			cp_R = cpR.getCPFormula();
		}
		if(cpChoiceR == 3){
			EventualC cpR = new EventualC(r);
			cp_R = cpR.getCPFormula();
		}
		if(cpChoiceR == 4){
			ParallelC cpR = new ParallelC(r);
			cp_R = cpR.getCPFormula();
		}
		//////////P
		if(cpChoiceP == 1){
			AtLeastOneC cpP = new AtLeastOneC(p);
			cp_P = cpP.getCPFormula();
		}
		if(cpChoiceP == 2){
			AtLeastOneE cpP = new AtLeastOneE(p);
			cp_P = cpP.getCPFormula();
		}
		if(cpChoiceP == 3){
			ConsecutiveC cpP = new ConsecutiveC(p);
			cp_P = cpP.getCPFormula();
		}
		if(cpChoiceP == 4){
			ConsecutiveE cpP = new ConsecutiveE(p);
			cp_P = cpP.getCPFormula();
		}
		if(cpChoiceP == 5){
			EventualC cpP = new EventualC(p);
			cp_P = cpP.getCPFormula();
		}
		if(cpChoiceP == 6){
			EventualE cpP = new EventualE(p);
			cp_P = cpP.getCPFormula();
		}
		if(cpChoiceP == 7){
			ParallelC cpP = new ParallelC(p);
			cp_P = cpP.getCPFormula();
		}
		if(cpChoiceP == 8){
			ParallelE cpP = new ParallelE(p);
			cp_P = cpP.getCPFormula();
		}
		
		//////////////q
		if(cpChoiceQ == 1){
			AtLeastOneC cpQ= new AtLeastOneC(q);
			cp_Q = cpQ.getCPFormula();
		}
		if(cpChoiceQ == 2){
			AtLeastOneE cpQ = new AtLeastOneE(q);
			cp_Q = cpQ.getCPFormula();
		}
		if(cpChoiceQ == 3){
			ConsecutiveC cpQ = new ConsecutiveC(q);
			cp_Q = cpQ.getCPFormula();
		}
		if(cpChoiceQ == 4){
			ConsecutiveE cpQ = new ConsecutiveE(q);
			cp_Q = cpQ.getCPFormula();
		}
		if(cpChoiceQ == 5){
			EventualC cpQ = new EventualC(q);
			cp_Q = cpQ.getCPFormula();
		}
		if(cpChoiceQ == 6){
			EventualE cpQ = new EventualE(q);
			cp_Q = cpQ.getCPFormula();
		}
		if(cpChoiceQ == 7){
			ParallelC cpQ = new ParallelC(q);
			cp_Q = cpQ.getCPFormula();
		}
		if(cpChoiceQ == 8){
			ParallelE cpQ = new ParallelE(q);
			cp_Q = cpQ.getCPFormula();
		}
		
		String [] inResult = {cp_L,cp_R,cp_P,cp_Q};
		return inResult;
	}
}
