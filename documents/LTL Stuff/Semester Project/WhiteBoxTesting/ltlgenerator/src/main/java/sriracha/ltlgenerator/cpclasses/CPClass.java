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
public class CPClass {
    
    Proposition s;
    
    public String OnePropFormula = "";
    public String TwoPropFormula = "";
    public String ThreePropFormula = "";

    public CPClass(Proposition s) {
        this.s = s;
    }

    public String getCPFormula(){
        if (s.getPropositions().size() == 1)
            return OnePropFormula.replace("[p1]", s.getPropositions().get(0));
        else if (s.getPropositions().size() == 2)
            return TwoPropFormula.replace("[p1]",s.getPropositions().get(0)).replace("[p2]", s.getPropositions().get(1));
        else if (s.getPropositions().size() == 3)
            return ThreePropFormula.replace("[p1]",s.getPropositions().get(0)).replace("[p2]", s.getPropositions().get(1)).replace("[p3]", s.getPropositions().get(2));
        return "Error";
    }
   
}
