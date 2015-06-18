/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sriracha.ltlgenerator.andutils;

/**
 * 
 * 
 */
public class ANDUtils {

    public ANDUtils() {
    }
    
    public int manageleft(String formula, int pos){
        int open = 0;
        int close = 0;
        int finalPos = 0;
        
        for (int i = pos; i >= 0; i--){
            if (formula.charAt(i) == ')')
                close ++;
             if (formula.charAt(i) == '(')
                open ++;
             if (open == close && open > 0 && close > 0){
                     finalPos = i;
                     return finalPos;
             }
        }
        return 0;
    }

    public int manageright(String formula, int pos){
        int open = 0;
        int close = 0;
        int finalPos = 0;
        
        for (int i = pos; i <= formula.length(); i++){
            if (formula.charAt(i) == ')')
                close ++;
             if (formula.charAt(i) == '(')
                open ++;
             if (open == close && open > 0 && close > 0){
                     finalPos = i;
                     return finalPos;
             }
        }
        return 0;
    }
    
    
}
