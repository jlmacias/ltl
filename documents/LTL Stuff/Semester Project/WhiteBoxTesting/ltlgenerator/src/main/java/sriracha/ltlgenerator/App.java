package sriracha.ltlgenerator;

import sriracha.ltlgenerator.andutils.ANDL;
import sriracha.ltlgenerator.andutils.ANDR;

import sriracha.ltlgenerator.pattern.Pattern;
import sriracha.ltlgenerator.scope.Scope;

/**
 * 
 *
 */
public class App 
{
	public static void main( String[] args )
	{   
				
		Inputter in = new Inputter();

		String [] result = in.inputForCP();

		Pattern pat = new Pattern(result[0], result[1], result[2], result[3]);

		//Generating response before c formula
                String pFormula = pat.getResponseBeforeRc();

                ANDR andr = new ANDR();
                //Running ANDR operation
		pFormula = andr.replaceAllforANDR(pFormula);

                ANDL andl = new ANDL();
                //Running ANDL operation
		pFormula = andl.replaceAllforANDL(pFormula);

                //Setting scope formula
		Scope s = new Scope(result[0], result[1], pFormula, result[3]);
                //Running ANDL operation
		String finalFormula =  andl.replaceAllforANDL(s.getFormulaBetweenLANDR());
                //Remove state placeholders
		finalFormula = finalFormula.replaceAll("\\.", "");

                //Print final formula output
		System.out.println(finalFormula);

	}


}
