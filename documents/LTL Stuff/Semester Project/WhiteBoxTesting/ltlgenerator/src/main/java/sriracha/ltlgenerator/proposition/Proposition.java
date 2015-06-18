/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sriracha.ltlgenerator.proposition;

import java.util.ArrayList;

/**
 * 
 * 
 */
public class Proposition {
    
   public final String[] propositions;
   int n; //Number of propositions used

    public Proposition(int n) {
        
        this.n = n;
        propositions = new String[3];
	        
	this.propositions[0] = "-";
	this.propositions[1] = "-";
	this.propositions[2] = "-";
    }
    
    
    public ArrayList<String> getPropositions() {
        ArrayList<String> props = new ArrayList<String>();
        for (int i = 0; i < this.n; i++){
            props.add(propositions[i]);
        }
        return props;
    }

}
