package edu.tx.utep.ltlgenerator.inputoutput;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputToFile extends LTLInputOutput {
	
	protected static String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date).toString();
	}
	
	protected static void outputInitialMessage(){
		StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*********************************************************************************" + System.lineSeparator());
        stringBuilder.append("LTL GENERATOR RUN @ " + getDateTime() + System.lineSeparator());
        stringBuilder.append("*********************************************************************************" + System.lineSeparator());
        saveResultsToFile(stringBuilder.toString());
	}
	
	protected static void outputInputErrorMessage(){
		StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------------------------------------------" + System.lineSeparator());
        stringBuilder.append("ERROR READING INPUT SET " + getDateTime() + System.lineSeparator());
        stringBuilder.append("-----------------------------------------------------------------" + System.lineSeparator());
        saveResultsToFile(stringBuilder.toString());
	}
	
	protected static void outputLTLFormulaResultSet(String scope, String pattern, String p, String q, String r, String l, String ltlFormula){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("---------------------------------------------------------" + System.lineSeparator());
		stringBuilder.append("Scope: " + scope + System.lineSeparator());
		stringBuilder.append("Pattern: " + pattern + System.lineSeparator());
		if (!p.isEmpty()) {
			stringBuilder.append(p + System.lineSeparator());
		}
		if (!q.isEmpty()) {
			stringBuilder.append(q + System.lineSeparator());
		}
		if (!r.isEmpty()) {
			stringBuilder.append(r + System.lineSeparator());
		}
		if (!l.isEmpty()) {
			stringBuilder.append(l + System.lineSeparator());
		}
		stringBuilder.append(System.lineSeparator() + System.lineSeparator());
		stringBuilder.append("LTL Formula:" + System.lineSeparator());
		stringBuilder.append(ltlFormula + System.lineSeparator());
		stringBuilder.append("---------------------------------------------------------" + System.lineSeparator());
		
		saveResultsToFile(stringBuilder.toString());
		
	}
	
	protected static void saveResultsToFile(String results){
	   	 try {
	            FileWriter writer = new FileWriter("output.txt", true);
	            writer.write(results);
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }
}
