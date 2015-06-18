/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sriracha.ltlgenerator.cpclasses;

import sriracha.ltlgenerator.proposition.Proposition;

/**
 * 
 * 
 */
public class EventualC extends CPClass {

	public EventualC(Proposition s) {
		super(s);
		super.OnePropFormula = "([p1].)";
		super.TwoPropFormula = "([p1].&X(![p2].U([p2].)))";
		super.ThreePropFormula = "([p1].&X(![p2].U([p2].&X(![p3].U([p3].)))))";
	}

	
	

}
