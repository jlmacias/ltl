/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sriracha.ltlgenerator.proposition;

/**
 * 
 * 
 */
public class PProposition extends Proposition {

    public PProposition(int n) {
        super(n);
        super.propositions[0]= "a";
        super.propositions[1]= "b";
        super.propositions[2]= "c";
    }

}
