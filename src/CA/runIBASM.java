package CA;

public class runIBASM {
	final static int[][] simpleStructure = new int[][]{
			{1,1,1,1,1},
			{1,0,1,0,1},
			{1,1,1,1,1},
			{1,0,1,0,1},
			{1,1,1,1,1},


	};
	final static int[][] Frenchflag = new int[][]{
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},

	};
	final static int[][] flag = new int[][]{
		{1,1,2,2,3,3},
		{1,1,2,2,3,3},
		{1,1,2,2,3,3},
		{1,1,2,2,3,3},
		{1,1,2,2,3,3},
		{1,1,2,2,3,3},

};
	final static int[][] norFlagBorderd = new int[][]{
		{0,0,0,0,0,0,0,0},
		{0,2,0,1,0,2,2,0},
		{0,0,0,1,0,0,0,0},
		{0,1,1,1,1,1,1,0},
		{0,0,0,1,0,0,0,0},
		{0,2,0,1,0,2,2,0},
		{0,2,0,1,0,2,2,0},
		{0,0,0,0,0,0,0,0},


};
	final static int[][] norFlagBigBorderd = new int[][]{
		{0,0,0,0,0,0,0,0,0},
		{0,1,2,3,2,1,1,1,0},
		{0,1,2,3,2,1,1,1,0},
		{0,2,2,3,2,2,2,2,0},
		{0,3,3,3,3,3,3,3,0},
		{0,2,2,3,2,2,2,2,0},
		{0,1,2,3,2,1,1,1,0},
		{0,1,2,3,2,1,1,1,0},
		{0,0,0,0,0,0,0,0,0},


};
	final static int[][] creeperRep = new int[][]{
			{2,2,2,2,2,2,2,2},
			{2,1,1,2,2,1,1,2},
			{2,1,1,2,2,1,1,2},
			{2,2,2,1,1,2,2,2},
			{2,2,1,1,1,1,2,2},
			{2,2,1,1,1,1,2,2},
			{2,2,1,2,2,1,2,2},
			{2,2,2,2,2,2,2,2},
	};
	final static int[][] test = new int[][]{
		/*interesting*/

		//class 1 
	//	{1,2,0,4,0,},{18,1,1,4,3,},{15,0,1,8,0,},{5,2,3,4,0,},{12,4,2,8,0,},{8,1,0,1,2,},{18,0,0,1,6,},{15,3,4,4,2,},{2,1,2,9,2,},{5,0,0,5,4,},
		
		//

		{10,0,2,8,6,},{17,0,3,8,4,},{7,1,1,4,8,},{16,1,0,9,1,},{16,0,4,1,6,},{17,4,3,2,8,},{20,0,2,5,3,},{21,1,0,2,6,},{2,4,4,4,9,},{11,2,1,4,2,},









































	};
	
	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 2; 
		int boardSize = 50;
		int numOfStates = 4;
		int numberOfRuns = 40;
		int numberofInstructions = 10;
		boolean randomStart = false;
		boolean vonNeumannNeighbourhood = true;

		CAIBA ca = new CAIBASM(dimentions, boardSize, numOfStates, randomStart, numberofInstructions);
		ca.setBoard(generateReplicationBoard(creeperRep));
		ca.useWriter();
		ca.setRules(test);
		ca.start(numberOfRuns);
		
		
	}
	
	
	private static int [][] generateReplicationBoard(int [][] replicator){
		int s = 50;
		int x = (s/2) - (replicator.length/2);
		int y = (s/2) - (replicator[0].length /2);

		int [][] newBoard = new int [s][s];
		for (int i = x; i < x+replicator.length; i++) {
			for (int j =y; j < y+replicator[0].length; j++) {
				System.out.println(i + ":" + j);
				newBoard[i][j] = replicator[i-x][j-y];
			}
		}
		return newBoard;

	}

}
