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
public class AtLeastOneC extends CPClass {
    

    public AtLeastOneC(Proposition s) {
        super(s);
        super.OnePropFormula = "([p1].)";
        super.TwoPropFormula = "([p1]|[p2].)";
        super.ThreePropFormula = "([p1]|[p2]|[p3].)";
    }
    
    
}
