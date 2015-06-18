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
public class LProposition extends Proposition {

    public LProposition(int n) {
        super(n);
        super.propositions[0]= "j";
        super.propositions[1]= "k";
        super.propositions[2]= "l";
    }
    
}
