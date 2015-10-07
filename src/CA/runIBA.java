package CA;

import org.omg.CORBA.FREE_MEM;

public class runIBA {
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
	
	final static int[][] norFlagExtraLargeBordered = new int[][]{
		{0,0,0,0,0,0,0,0,0,0,0},
		{0,1,2,3,2,1,1,1,1,1,0},
		{0,1,2,3,2,1,1,1,1,1,0},
		{0,2,2,3,2,2,2,2,2,2,0},
		{0,3,3,3,3,3,3,3,3,3,0},
		{0,2,2,3,2,2,2,2,2,2,0},
		{0,1,2,3,2,1,1,1,1,1,0},
		{0,1,2,3,2,1,1,1,1,1,0},
		{0,1,2,3,2,1,1,1,1,1,0},
		{0,1,2,3,2,1,1,1,1,1,0},
		{0,0,0,0,0,0,0,0,0,0,0},


};
	

	final static int[][] test = new int[][]{
		{2,0,1,},{14,0,1,},{1,1,1,},{2,1,0,},{12,4,1,},{5,1,4,},{6,2,2,},{13,3,0,},{14,1,4,},{7,1,0,},
		











		//{8,0,1,},{2,2,0,},{6,4,3,},{0,4,1,},{13,2,1,},{11,0,3,},{4,2,1,},{11,4,1,},{2,1,3,},{1,1,0,},

//		{2,2,0,},{14,2,3,},{4,0,3,},{5,4,3,},{12,0,1,},{12,2,3,},{1,1,0,},{8,1,3,},{2,1,4,},{8,0,1,},
		
//		{13,1,4,},{12,4,1,},{3,1,2,},{1,2,1,},{0,0,3,},{1,2,0,},{2,2,0,},{12,3,0,},{4,3,4,},{4,1,4,},






















	};
	
	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 2; 
		int boardSize = 30;
		int numOfStates = 4;
		int numberOfRuns =40;
		int numberofInstructions = 10;
		boolean randomStart = false;
		boolean vonNeumannNeighbourhood = true;

		CAIBA ca = new CAIBA(dimentions, boardSize, numOfStates, randomStart, numberofInstructions);
		ca.setBoard(generateReplicationBoard(norFlagExtraLargeBordered));
		ca.useWriter();
		ca.setRules(test);
		ca.start(numberOfRuns);
		
		
	}
	
	private static int [][] generateReplicationBoard(int [][] replicator){
		int s = 30;
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
