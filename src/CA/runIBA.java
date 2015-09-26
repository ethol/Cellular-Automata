package CA;

public class runIBA {
	final static int[][] test = new int[][]{
		{9,2,3,},{6,2,0,},{5,1,3,},{0,3,2,},{6,4,3,},{2,1,3,},{11,4,2,},{9,2,4,},{11,2,0,},{11,2,0,},







		//{8,0,1,},{2,2,0,},{6,4,3,},{0,4,1,},{13,2,1,},{11,0,3,},{4,2,1,},{11,4,1,},{2,1,3,},{1,1,0,},

//		{2,2,0,},{14,2,3,},{4,0,3,},{5,4,3,},{12,0,1,},{12,2,3,},{1,1,0,},{8,1,3,},{2,1,4,},{8,0,1,},
		
//		{13,1,4,},{12,4,1,},{3,1,2,},{1,2,1,},{0,0,3,},{1,2,0,},{2,2,0,},{12,3,0,},{4,3,4,},{4,1,4,},





























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

		CAIBA ca = new CAIBA(dimentions, boardSize, numOfStates, randomStart, numberofInstructions);
		ca.useWriter();
		ca.setRules(test);
		ca.start(numberOfRuns);
		
		
	}

}
