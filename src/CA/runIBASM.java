package CA;

public class runIBASM {
	final static int[][] test = new int[][]{
		/*interesting*/

		//class 1 
	//	{1,2,0,4,0,},{18,1,1,4,3,},{15,0,1,8,0,},{5,2,3,4,0,},{12,4,2,8,0,},{8,1,0,1,2,},{18,0,0,1,6,},{15,3,4,4,2,},{2,1,2,9,2,},{5,0,0,5,4,},
		
		//

		{17,3,4,3,8,},{9,2,2,2,3,},{3,0,0,9,0,},{1,1,3,9,9,},{15,2,4,2,4,},{6,4,4,0,7,},{5,0,1,0,7,},{9,4,3,6,3,},{9,1,1,5,1,},{2,1,0,2,2,},
		




































	};
	
	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 2; 
		int boardSize = 6;
		int numOfStates = 4;
		int numberOfRuns = 40;
		int numberofInstructions = 10;
		boolean randomStart = false;
		boolean vonNeumannNeighbourhood = true;

		CAIBA ca = new CAIBASM(dimentions, boardSize, numOfStates, randomStart, numberofInstructions);
		ca.useWriter();
		ca.setRules(test);
		ca.start(numberOfRuns);
		
		
	}

}
