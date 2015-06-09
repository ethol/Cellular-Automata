package CA;

public class runIBASM {
	final static int[][] test = new int[][]{
		/*interesting*/

		//class 1 
	//	{1,2,0,4,0,},{18,1,1,4,3,},{15,0,1,8,0,},{5,2,3,4,0,},{12,4,2,8,0,},{8,1,0,1,2,},{18,0,0,1,6,},{15,3,4,4,2,},{2,1,2,9,2,},{5,0,0,5,4,},
		
		//


		{18,2,2,4,15,},{19,0,0,3,11,},{9,3,2,15,0,},{10,0,1,14,4,},{8,4,2,19,14,},{3,2,1,13,6,},{13,1,0,10,2,},{13,3,3,4,17,},{6,4,3,5,18,},{1,0,4,4,11,},{4,2,2,13,4,},{9,2,2,16,8,},{8,2,2,9,17,},{6,3,0,0,10,},{9,0,3,4,19,},{9,3,2,16,17,},{9,4,2,11,4,},{13,2,4,17,0,},{5,1,4,18,18,},{9,3,0,0,14,},










































	};
	
	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 2; 
		int boardSize = 6;
		int numOfStates = 4;
		int numberOfRuns = 80;
		int numberofInstructions = 20;
		boolean randomStart = false;
		boolean vonNeumannNeighbourhood = true;

		CAIBA ca = new CAIBASM(dimentions, boardSize, numOfStates, randomStart, numberofInstructions);
		ca.useWriter();
		ca.setRules(test);
		ca.start(numberOfRuns);
		
		
	}

}
