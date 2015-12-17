package extra;

import java.util.ArrayList;

import CA.CA;
import CA.CAIBA;
import CA.CAIBASM;

public class extraReplicationsTT {
	final static String[] kandidates = new String[]{
		"000021010112000002221100010010101220100002222220000202022001201202122212200111012101121100000121211102122002200022211110111002212110011122222120011011211222120202201222201012120110000121022110212201221001220010111101000012021120010011212010201",
		"000021001212212201002021121012222002001012210211112212201221212202212112211022101002222110201210121012211010022201022220202022211011122100102120100020221022221202111001001200200011011101011120112220220220212020102211011112120001121200221022111",
		"000011020200020112012201002122200102100001200201221001111212121211211211011001122202101122011000111112112001000022112122200000201012220221020211102002021221000001021120212111222200012002021222110011221210201010021211001210112002200202201112111",
		"000000012111101022222020221212102222001022221200110100022000210010101002210212011100211210012110212102222201002012120111100122212122201020001102222101010100020020210110200100222002001112210212022112100121220022220111220222022001020120222022201",
		"000011021110220010200012111110122102200021120202010000012010202111122002020012020100101122011021222222020201202021002111102220112122021200001212111020120020220012220020000002100012010110022110220200222002222121010110220221022022201002102002220",










	};
	
	CA generator; 
	int [][] target;
	int boardSize;
	int [][] freshBoard;
	int maxDevIterations;

	public extraReplicationsTT(int maxDevIterations, int dimentions, int boardSize,
			int numOfStates, boolean elitism, int numberOfInstructions){
		generator = new CA(dimentions, boardSize, numOfStates, false, true);
		this.maxDevIterations = maxDevIterations;
		this.boardSize = boardSize;
	}
	final static byte[][][] test = new byte[][][]{

	};
	
	public void setTarget(int [][] target){
		int [][] dot = new int[1][1];
		dot[0][0] = 1;
		this.target = target;
		generateReplicationBoard(target);
	//	this.maxFitness = target.length*target[0].length /*numReplicated/*2/**/;
	}
	private void generateReplicationBoard(int [][] replicator){
		int x = (boardSize/2) - (replicator.length/2);
		int y = (boardSize/2) - (replicator[0].length /2);

		int [][] newBoard = new int [boardSize][boardSize];
		for (int i = x; i < x+replicator.length; i++) {
			for (int j =y; j < y+replicator[0].length; j++) {
				newBoard[i][j] = replicator[i-x][j-y];
			}
		}
		freshBoard = newBoard;

	}

	private double replicationFitnessFunction(String rules, int nrReplicated){
		int partielFitness = 0;
		int fitness= 0;
		int maxFitness = 0;
		int [] bestPartials = new int [nrReplicated];
		generator.setBoard(freshBoard);
		generator.setRules(rules.trim());
		generator.start(5);
		for (int k = 0; k < (maxDevIterations-5); k++) {

			generator.start(1);
			int board[][] = generator.getBoard();
			bestPartials = new int [nrReplicated];
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
					for (int j2 = 0; j2 < nrReplicated; j2++) {
						if(bestPartials[j2]< partielFitness){
							bestPartials[j2] = partielFitness;
							break;
						}
					}
				}
			}
			fitness = 0;
			for (int i = 0; i < nrReplicated; i++) {
				if(bestPartials[i]==target.length*target[0].length)
				fitness += 1;

			}
			if(fitness>maxFitness){
				maxFitness=fitness;
			}


		}

		return maxFitness;
	}
	
	public static void main(String[] args) {
		final int[][] simpleStructureBorderd = new int[][]{
				{0,0,0,0,0,0,0},
				{0,1,1,1,1,1,0},
				{0,1,0,1,0,1,0},
				{0,1,1,1,1,1,0},
				{0,1,0,1,0,1,0},
				{0,1,1,1,1,1,0},
				{0,0,0,0,0,0,0},


		};
		final int[][] frenchFlagBorderd = new int[][]{
				{0,0,0,0,0,0,0,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,0,0,0,0,0,0,0},


		};
		extraReplicationsTT tester = new extraReplicationsTT(120, 2, 75, 3, true, 10);
		tester.setTarget(frenchFlagBorderd);
		ArrayList<Double> values = new ArrayList<Double>();
		double sum = 0;
		double best = 0, bestNr;
		for (int i = 0; i < kandidates.length; i++) {
			values.add (tester.replicationFitnessFunction(kandidates[i], 100));
			sum+=tester.replicationFitnessFunction(kandidates[i], 100);
			if (best < tester.replicationFitnessFunction(kandidates[i], 100)) {
				bestNr = i;
				best = tester.replicationFitnessFunction(kandidates[i], 100);
				System.out.println(bestNr + ":" +best);
			}
		}
		
		System.out.println("Average: " + sum/values.size());
		
		//stdev
		System.out.println("StDev: " + stDev(values));
	}
	
	private static double stDev(ArrayList<Double> set){
		double sum=0, sumMeanSquared = 0;
		double avarage;
		
		for (Double integer : set) {
			sum+=integer;
		}
		avarage = sum/set.size();
		for (Double integer : set) {
			sumMeanSquared += Math.pow((integer-avarage),2);
			//System.out.println(Math.pow((integer.doubleValue()-avarage),2));
		}
		//System.out.println(sumMeanSquared);
		
		return Math.sqrt(sumMeanSquared/set.size());
	}
	

}
