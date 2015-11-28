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
	final static int[][] frenchFlagBorderd = new int[][]{
			{0,0,0,0,0,0,0,0},
			{0,1,1,0,0,2,2,0},
			{0,1,1,0,0,2,2,0},
			{0,1,1,0,0,2,2,0},
			{0,1,1,0,0,2,2,0},
			{0,1,1,0,0,2,2,0},
			{0,1,1,0,0,2,2,0},
			{0,0,0,0,0,0,0,0},


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

	final static int[][] dot = new int[][]{
		{1},
	};
	
	final static int[][] target = new int[][]{
		{0,0,0,0,0},
		{0,1,1,1,0},
		{0,1,0,1,0},
		{0,1,1,1,0},
		{0,0,0,0,0},
	};
	final static byte[][] test = new byte[][]{
		/*interesting*/

		//class 1 
		//	{1,2,0,4,0,},{18,1,1,4,3,},{15,0,1,8,0,},{5,2,3,4,0,},{12,4,2,8,0,},{8,1,0,1,2,},{18,0,0,1,6,},{15,3,4,4,2,},{2,1,2,9,2,},{5,0,0,5,4,},

		//

	//	{5,3,1,1,0,},{18,1,0,8,4,},{7,0,0,8,2,},{1,1,4,0,2,},{13,0,0,6,3,},{8,1,3,4,0,},{1,0,3,9,1,},{18,3,2,2,5,},{2,1,0,0,3,},{21,1,4,7,5,},

		
		// can solve FFlag evoDevo with a large enough lattice
		//{14,3,0,3,7,},{7,4,2,5,0,},{21,2,3,0,4,},{2,2,0,0,3,},{5,1,4,6,6,},{17,3,2,9,0,},{10,1,2,5,1,},{12,3,1,5,1,},{4,2,2,9,6,},{11,0,2,6,9,},
		
		//creeper mytosis.
//		{4,2,3,2,0,},{5,2,2,6,4,},{10,0,3,7,3,},{2,2,4,4,1,},{12,0,3,2,8,},{13,3,1,6,0,},{2,4,2,3,6,},{18,4,2,7,2,},{11,4,0,6,2,},{4,2,1,5,2,},
		
		{15,4,1,7,2,},{2,4,3,2,3,},{8,4,4,7,1,},{21,0,0,5,9,},{16,0,4,2,2,},{8,4,3,0,2,},{15,2,0,0,4,},{2,1,4,0,6,},{3,4,0,0,3,},{5,4,0,0,4,},
		
		
		
		
		
	};
	
	

	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 2; 
		int boardSize = 30;
		int numOfStates = 2;
		int numberOfRuns = 40;
		int numberofInstructions = 10;
		boolean randomStart = false;
		boolean vonNeumannNeighbourhood = true;

		CAIBASM ca = new CAIBASM(dimentions, boardSize, numOfStates, randomStart, numberofInstructions);
		ca.setBoard(generateReplicationBoard(simpleStructure));
		ca.useWriter();
		ca.setRules(test);
		ca.start(numberOfRuns);


//		/*System.out.println((*/evoDevoFitnessFunction(test, 3, ca, generateReplicationBoard(dot), target, 40);
	}


	private static int [][] generateReplicationBoard(int [][] replicator){
		int s = 25;
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
	
	private static double evoDevoFitnessFunction(byte [][] rules, int nrReplicated, CAIBASM generator, int [][] freshBoard, int [][] target, int maxDevIterations){
		// development
		int partielFitness = 0;
		int fitness= 0;
		int maxFitness = 0;
		int bestPartial = 0;
		int bestDev = 0;
		generator.setBoard(freshBoard);
		generator.setRules(rules);
		for (int k = 0; k < (maxDevIterations/2); k++) {

			generator.start(1);
			int board[][] = generator.getBoard();
			bestPartial = 0;
			for (int i = 0; i < board.length - target.length; i++) {
				for (int j = 0; j < board[0].length - target[0].length; j++) {
					partielFitness = 0;
					for (int j2 = 0; j2 < target.length; j2++) {
						for (int l = 0; l < target[0].length; l++) {
							if(board[(i+j2)][(j+l)]==target[j2][l]){
								partielFitness++;
							}
						}
					}
					if(bestPartial< partielFitness){
						bestPartial = partielFitness;
					}
					
				}
			}
				fitness += bestPartial;

			if(fitness>maxFitness){
				maxFitness=fitness;
				bestDev = k;
				//System.out.println(k);
				System.out.println("Dev "+ (k+1) + ": " + fitness);
			}
			fitness = 0;
			if(maxFitness==target.length*target[0].length){
				break;
			}

		}

		// replication
		int partielFitnessRep = 0;
		int fitnessRep= 0;
		int maxFitnessRep = 0;
		int [] bestPartialsRep = null;
		generator.setBoard(freshBoard);
		generator.setRules(rules);
		generator.start(bestDev+ 1);
		
		for (int k = 0; k < (maxDevIterations/2); k++) {

			generator.start(1);
			int board[][] = generator.getBoard();
			bestPartialsRep = new int [nrReplicated];
			for (int i = 0; i < board.length - target.length; i++) {
				for (int j = 0; j < board[0].length - target[0].length; j++) {
					partielFitnessRep = 0;
					for (int j2 = 0; j2 < target.length; j2++) {
						for (int l = 0; l < target[0].length; l++) {
							if(board[(i+j2)][(j+l)]==target[j2][l]){
								partielFitnessRep++;
							}
						}
					}
					for (int j2 = 0; j2 < nrReplicated; j2++) {
						if(bestPartialsRep[j2]< partielFitnessRep){
							bestPartialsRep[j2] = partielFitnessRep;
							break;
						}
					}
				}
			}
			for (int i = 0; i < nrReplicated; i++) {
				fitnessRep += bestPartialsRep[i];
			}

			if(fitnessRep>maxFitnessRep){
				maxFitnessRep=fitnessRep;
				System.out.println("Rep " + (k+bestDev+1) + ":" + fitnessRep);
			}
			fitnessRep = 0;

		}
		System.out.println("total: " + (maxFitnessRep + (maxFitness*nrReplicated)));
		return maxFitnessRep + (maxFitness*nrReplicated);
	}

}
