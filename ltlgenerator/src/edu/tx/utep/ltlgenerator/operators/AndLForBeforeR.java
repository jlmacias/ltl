package edu.tx.utep.ltlgenerator.operators;

public class AndLForBeforeR {

	public AndLForBeforeR() {
		// TODO Auto-generated constructor stub
	}

	public String getAndLForBeforeR(String leftSide, String rightSide){
		boolean sidesAreInitialized = ((leftSide != null) && (rightSide != null));
		int lastElementStartIndex;
		int firstClosingParenthesisIndex;
		int leftSideLength;
		int IntroduceRightSideIndex;
		String lastElementString;
		StringBuilder leftSideAndLRightSide = new StringBuilder();
		
		leftSideLength = leftSide.length();
		if (sidesAreInitialized){	
			lastElementStartIndex = leftSide.lastIndexOf('&');		
			if (lastElementStartIndex != -1){
				lastElementStartIndex++; 
				if (leftSide.indexOf('U', lastElementStartIndex) != -1){
					lastElementStartIndex = leftSide.lastIndexOf('U', leftSideLength) + 1;
				} else if (leftSide.indexOf('X', lastElementStartIndex) != -1 ){
					lastElementStartIndex = leftSide.lastIndexOf('X', leftSideLength) + 1;
				}
				
				lastElementString = leftSide.substring(lastElementStartIndex);
				firstClosingParenthesisIndex = lastElementString.indexOf(')');
				
				if (firstClosingParenthesisIndex != -1){
					IntroduceRightSideIndex = lastElementStartIndex + firstClosingParenthesisIndex + 1;
					leftSideAndLRightSide.append(leftSide.substring(0, IntroduceRightSideIndex));
					leftSideAndLRightSide.append(Operator.AND);
					leftSideAndLRightSide.append(Operator.OPEN_P);
					leftSideAndLRightSide.append(rightSide);
					leftSideAndLRightSide.append(Operator.CLOSE_P);
					leftSideAndLRightSide.append(leftSide.substring(IntroduceRightSideIndex, leftSideLength));
					return leftSideAndLRightSide.toString();
				} else {
					//error
					return null;
				}
			
			} else {
				//This is noly for strings resulting from the andR operation. Further Error Handling might need to be implemented. Roberto Fierro
				return null;
			}
		}
		return null;
	}

}
