package CA;

public class runIBA {
	final static int[][] test = new int[][]{
		{3,4,4,},{10,4,3,},{4,4,3,},{13,1,0,},{6,3,0,},{15,2,0,},{12,1,3,},{1,3,0,},{5,1,3,},{8,1,4,},

		//{8,0,1,},{2,2,0,},{6,4,3,},{0,4,1,},{13,2,1,},{11,0,3,},{4,2,1,},{11,4,1,},{2,1,3,},{1,1,0,},

//		{2,2,0,},{14,2,3,},{4,0,3,},{5,4,3,},{12,0,1,},{12,2,3,},{1,1,0,},{8,1,3,},{2,1,4,},{8,0,1,},
		
//		{13,1,4,},{12,4,1,},{3,1,2,},{1,2,1,},{0,0,3,},{1,2,0,},{2,2,0,},{12,3,0,},{4,3,4,},{4,1,4,},





























	};
	
	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 2; 
		int boardSize = 16;
		int numOfStates = 3;
		int numberOfRuns = 40;
		int numberofInstructions = 30;
		boolean randomStart = false;
		boolean vonNeumannNeighbourhood = true;

		CAIBA ca = new CAIBA(dimentions, boardSize, numOfStates, randomStart, numberofInstructions);
		ca.useWriter();
		ca.setRules(test);
		ca.start(numberOfRuns);
		
		
	}

}
