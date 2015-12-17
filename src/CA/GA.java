package CA;

import java.awt.image.ReplicateScaleFilter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class GA implements Runnable{
	final int[][] mario = new int[][]{
			{0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0},
			{0,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0},
			{0,0,0,0,1,1,1,3,3,1,3,0,0,0,0,0},
			{0,0,0,1,3,1,3,3,3,1,3,3,3,0,0,0},
			{0,0,0,1,3,1,1,3,3,3,1,3,3,3,0,0},
			{0,0,0,1,1,3,3,3,3,1,1,1,1,0,0,0},
			{0,0,0,0,0,3,3,3,3,3,3,3,0,0,0,0},
			{0,0,0,0,1,1,2,1,1,1,0,0,0,0,0,0},
			{0,0,0,1,1,1,2,1,1,2,1,1,1,0,0,0},
			{0,0,1,1,1,1,2,2,2,2,1,1,1,1,0,0},
			{0,0,3,3,1,2,3,2,2,3,2,1,3,3,0,0},
			{0,0,3,3,3,2,2,2,2,2,2,3,3,3,0,0},
			{0,0,3,3,2,2,2,2,2,2,2,2,3,3,0,0},
			{0,0,0,0,2,2,2,0,0,2,2,2,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0},
			{0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0}
	};

	final int[][] mushroom = new int[][]{
			{0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
			{0,0,0,1,1,2,2,2,2,0,0,1,1,0,0,0},
			{0,0,1,0,0,2,2,2,2,0,0,0,0,1,0,0},
			{0,1,0,0,2,2,2,2,2,2,0,0,0,0,1,0},
			{0,1,0,2,2,0,0,0,0,2,2,0,0,0,1,0},
			{1,2,2,2,0,0,0,0,0,0,2,2,2,2,2,1},
			{1,2,2,2,0,0,0,0,0,0,2,2,0,0,2,1},
			{1,0,2,2,0,0,0,0,0,0,2,0,0,0,0,1},
			{1,0,0,2,2,0,0,0,0,2,2,0,0,0,0,1},
			{1,0,0,2,2,2,2,2,2,2,2,2,0,0,2,1},
			{1,0,2,2,1,1,1,1,1,1,1,1,2,2,2,1},
			{0,1,1,1,0,0,1,0,0,1,0,0,1,1,1,0},
			{0,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0},
			{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}
	};

	final int[][] creeper = new int[][]{
			{2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,2,2,2},
			{2,2,1,1,2,2,1,1,2,2},
			{2,2,1,1,2,2,1,1,2,2},
			{2,2,2,2,1,1,2,2,2,2},
			{2,2,2,1,1,1,1,2,2,2},
			{2,2,2,1,1,1,1,2,2,2},
			{2,2,2,1,2,2,1,2,2,2},
			{2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,2,2,2},
	};

	final int[][] creeperRep = new int[][]{
			{2,2,2,2,2,2,2,2},
			{2,1,1,2,2,1,1,2},
			{2,1,1,2,2,1,1,2},
			{2,2,2,1,1,2,2,2},
			{2,2,1,1,1,1,2,2},
			{2,2,1,1,1,1,2,2},
			{2,2,1,2,2,1,2,2},
			{2,2,2,2,2,2,2,2},
	};

	final int[][] creeperEasy = new int[][]{
			{1,1,0,0,1,1},
			{1,1,0,0,1,1},
			{0,0,1,1,0,0},
			{0,1,1,1,1,0},
			{0,1,1,1,1,0},
			{0,1,0,0,1,0},

	};
	final int[][] flag = new int[][]{
			{1,1,2,2,3,3},
			{1,1,2,2,3,3},
			{1,1,2,2,3,3},
			{1,1,2,2,3,3},
			{1,1,2,2,3,3},
			{1,1,2,2,3,3},

	};
	final int[][] Frenchflag = new int[][]{
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},
			{1,1,0,0,2,2},

	};
	
	final int[][] norFlag = new int[][]{
			{2,0,1,0,2,2},
			{0,0,1,0,0,0},
			{1,1,1,1,1,1},
			{0,0,1,0,0,0},
			{2,0,1,0,2,2},
			{2,0,1,0,2,2},

	};
	
	final int[][] norFlagBig = new int[][]{
			{1,2,3,2,1,1,1},
			{1,2,3,2,1,1,1},
			{2,2,3,2,2,2,2},
			{3,3,3,3,3,3,3},
			{2,2,3,2,2,2,2},
			{1,2,3,2,1,1,1},
			{1,2,3,2,1,1,1},


	};
	
	final int[][] simpleStructure = new int[][]{
			{1,1,1,1,1},
			{1,0,1,0,1},
			{1,1,1,1,1},
			{1,0,1,0,1},
			{1,1,1,1,1},


	};
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

	final int[][] flagBorderd = new int[][]{
			{0,0,0,0,0,0,0,0},
			{0,1,1,2,2,3,3,0},
			{0,1,1,2,2,3,3,0},
			{0,1,1,2,2,3,3,0},
			{0,1,1,2,2,3,3,0},
			{0,1,1,2,2,3,3,0},
			{0,1,1,2,2,3,3,0},
			{0,0,0,0,0,0,0,0},


	};

	final int[][] norFlagBorderd = new int[][]{
			{0,0,0,0,0,0,0,0},
			{0,2,0,1,0,2,2,0},
			{0,0,0,1,0,0,0,0},
			{0,1,1,1,1,1,1,0},
			{0,0,0,1,0,0,0,0},
			{0,2,0,1,0,2,2,0},
			{0,2,0,1,0,2,2,0},
			{0,0,0,0,0,0,0,0},


	};

	final int[][] norFlagBigBorderd = new int[][]{
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

	final int[][] simpleSimpleStructureBorderd = new int[][]{
			{0,0,0,0,0},
			{0,1,1,1,0},
			{0,1,0,1,0},
			{0,1,1,1,0},
			{0,0,0,0,0},


	};
	final int[][] simple2StateStructureBorderd = new int[][]{
			{0,0,0,0,0},
			{0,2,2,2,0},
			{0,2,1,2,0},
			{0,2,2,2,0},
			{0,0,0,0,0},


	};
	
	final int[][] SimpleCheckersBorderd = new int[][]{
			{0,0,0,0,0,0},
			{0,2,2,1,1,0},
			{0,2,2,1,1,0},
			{0,1,1,2,2,0},
			{0,1,2,2,2,0},
			{0,0,0,0,0,0},


	};
	protected Date startTime = new Date();
	protected double maxFitness; 
	protected int popSize;
	protected int maxIterations;
	protected int maxDevIterations;
	protected int dimentions; 
	protected int boardSize;
	protected int numOfStates;
	protected boolean elitism = false;
	protected int [][] freshBoard;
	protected int [][] target;
	protected int [][] secondaryTarget;
	protected boolean firstDone = false;
	private CA generator;
	private ArrayList<RuleModel> population;

	public int numReplicated = 3;

	protected ArrayList<Double> avarageList = new ArrayList<Double>();
	protected ArrayList<Double> bestList = new ArrayList<Double>();
	protected RuleModel bestSolution;
	protected String intermediatSolution;
	protected int intermediatSolutionIterations = 0;

	public GA(int popSize, int maxIterations,int maxDevIterations, int dimentions, int boardSize,
			int numOfStates, boolean elitism) {

		this.popSize = popSize;
		this.maxIterations = maxIterations;
		this.maxDevIterations = maxDevIterations;
		this.dimentions = dimentions;
		this.boardSize = boardSize;
		this.numOfStates = numOfStates;
		this.elitism = elitism;
		this.maxFitness = Math.pow(boardSize, dimentions);//NOT TRUE FOR ALL FITNESS FUNCTIONS. 
		population = new ArrayList<RuleModel>();

		generator = new CA(dimentions, boardSize, numOfStates, false, true);
		//		RuleModel max = new RuleModel((generator.getRules()));
		RuleModel rm;
		for (int i = 0; i < popSize; i++) {
			generator.setRandomRules();
			rm = new RuleModel(generator.cloneRules());
			//						System.out.println(rm);
			//rm.setFitnessValue(fitnessFunction(rm.getRules()));
			population.add(rm);
			//			System.out.println(population);
			//			if(rm.getFitnessValue()>max.getFitnessValue()){
			//				max=rm;
			//			}
			//			System.out.println(rm);

		}
		//		System.out.println("best: "+max);

		//testGeneration();
		//run(maxIterations);




	}
	public void setTarget(int [][] target){
		int [][] dot = new int[1][1];
		dot[0][0] = 1;
		this.target = target;
		generateReplicationBoard(dot);
		this.maxFitness = target.length*target[0].length *numReplicated*2/**/;
	}
	
	public void setSecondaryTarget(int [][] target){
		this.secondaryTarget = target;
		//generateReplicationBoard(target);
	}

	private void run(int nrOfRuns){
		for (int i = 0; i < nrOfRuns; i++) {


			//		System.out.println(population);
			//			System.out.println("iterate" + " at: " +  (new Date().getTime() - startTime.getTime()));
			iterateGeneration();
			//			System.out.println("test"+ " at: " + (new Date().getTime()- startTime.getTime()));
			testGeneration();
			//			System.out.println(population);
		}


	}


	private RuleModel testGeneration(){
		RuleModel rm;
		double avarage = 0.0;
		RuleModel max = new RuleModel((generator.cloneRules()));
		for (int i = 0; i < popSize; i++) {
			//			System.out.println("pop" + i + " at: " + (new Date().getTime()- startTime.getTime()));
			rm = population.get(i);
			//			System.out.println("nr " + i + ": "  + rm);
			rm.setFitnessValue(evoDevoFitnessFunction(rm.getRules(),numReplicated));
			if(rm.getFitnessValue()>=max.getFitnessValue()){
				max=rm;
			}
			//			System.out.println(rm);
			avarage+= rm.getFitnessValue();
		}

		//		System.out.println("best: "+max);
		bestList.add(max.getFitnessValue());
		//		System.out.println("avarage: "+ avarage/popSize);
		//avarageList.add(avarage/popSize);
		return max;
	}


	private double  majorityFitnessFunction(byte[][][][][][][][][] rules){
		double fitness = 0.0;
		int board[][] = new int [boardSize][1];
		for (int i = 0; i < Math.pow(dimentions+1, boardSize); i++) {
			String bin = Integer.toBinaryString(i);
			//adding 0 so that the binary is of right length
			for (int j = bin.length(); j < boardSize; j++) {
				bin = "0" + bin;
			}
			for (int j = 0; j < board.length; j++) {
				board[j][0]= bin.charAt(j)-48;
			}
			//System.out.println("test nr:"  + i);
			generator.setBoard(board);
			generator.setRules(rules);
			generator.start(20);



			int sumOfbin1s= 0;
			for (int j = 0; j < bin.length(); j++) {
				sumOfbin1s +=board[j][0];
			}
			int CAResult [][] = generator.getBoard();
			if(sumOfbin1s<(boardSize/2)+1){
				for (int j = 0; j < board.length; j++) {
					if(CAResult[j][0]==0){
						fitness++;
					}
				}
			}else{
				for (int j = 0; j < board.length; j++) {
					if(CAResult[j][0]==1){
						fitness++;
					}
				}
			}

			//System.out.println();
		}
		return fitness;
	}

	private double  pixelFitnessFunction(byte[][][][][][][][][] rules){
		double fitness = 0.0;
		double maxFitness = 0.0;
		ArrayList<Double> targetList = new ArrayList<Double>();
		generator.resetBoard();
		generator.setRules(rules);
		generator.start(5);
		for (int k = 0; k < (maxDevIterations-5); k++) {

			generator.start(1);
			int board[][] = generator.getBoard();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if(board[i][j] ==target[i][j]){
						fitness++;
					}
				}
			}
			if(fitness>maxFitness){
				maxFitness=fitness;
			}
			fitness = 0.0;

		}

		return maxFitness;
	}

	private double replicationFitnessFunction(byte[][][][][][][][][] rules, int nrReplicated){
		int partielFitness = 0;
		int fitness= 0;
		int maxFitness = 0;
		int [] bestPartials = null;
		generator.setBoard(freshBoard);
		generator.setRules(rules);
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
			for (int i = 0; i < nrReplicated; i++) {
				fitness += bestPartials[i];
			}

			if(fitness>maxFitness){
				maxFitness=fitness;
			}
			fitness = 0;

		}

		return maxFitness;
	}
	private double evoDevoFitnessFunction(byte[][][][][][][][][] rules, int nrReplicated){
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
		generator.start(bestDev + 1);
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
			}
			fitnessRep = 0;

		}

		return maxFitnessRep + (maxFitness*nrReplicated);
	}


	private double bestNoneOverlappingFitness(ArrayList<ReplicationPartalModel> partialList){
		double fitness = 0.0;
		ReplicationPartalModel [] used = new ReplicationPartalModel[numReplicated];
		boolean [][] board = new boolean [boardSize][boardSize];
		used[0] = partialList.get(0);
		for (int i = used[0].x; i < board.length+used[0].x; i++) {
			for (int j = used[0].y; j < board.length+used[0].y; j++) {

			}
		}


		return fitness;
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


	private void iterateGeneration(){
		//		for (int i = 0; i < popSize; i++) {
		//			System.out.println(population.get(i));
		//		}

		int nrBreeders = popSize*2;
		ArrayList<RuleModel> nextGen = new ArrayList<RuleModel>();
		ArrayList<RuleModel> breeders = new ArrayList<RuleModel>();
		Collections.sort(population);
		if(elitism){
			nextGen.add(population.get(0));
			nrBreeders-=2;
		}

		/*
		 *  normalizing the fitness value.
		 */
		double sum = 0;
		for (int i = 0; i < population.size(); i++) {
			sum += population.get(i).getFitnessValue();
		}
		for (int i = 0; i < population.size(); i++) {
			population.get(i).setFitnessValue( population.get(i).getFitnessValue()/sum);
		}

		/*
		 * normalzing such that it becomes a distribution
		 */
		for (int i = 1; i < population.size(); i++) {
			population.get(i).setFitnessValue(population.get(i).getFitnessValue() + population.get(i-1).getFitnessValue());
		}
		//incase overflow causes the sum to be less then 1.
		population.get(popSize-1).setFitnessValue(1);

		double ran = 0;

		/*
		 * selecting breeders
		 */
		for (int i = 0; i < nrBreeders; i++) {
			ran = Math.random();
			for (int j = 0; j < population.size(); j++) {
				if(population.get(j).getFitnessValue()>ran){
					breeders.add(population.get(j));
					break;
				}
			}
		}

		/*
		 * crossover 
		 */

		for (int i = 0; i < nrBreeders; i+=2) {
			nextGen.add(crossover(breeders.get(i), breeders.get(i+1)));



		}


		/*
		 * muation
		 */
		double mutateChance = 0.02;
		char [] mutate;
		String st;
		int ct = 0;
		if(elitism){
			ct = 1;
		}
		RuleModel rm;
		for (int p = ct; p < nextGen.size(); p++) {
			rm = nextGen.get(p);

			for (int i = 0; i < rm.getRules().length; i++) {
				for (int j = 0; j < rm.getRules()[0].length; j++) {
					for (int j2 = 0; j2 < rm.getRules()[0][0].length; j2++) {
						for (int k = 0; k < rm.getRules()[0][0][0].length; k++) {
							for (int k2 = 0; k2 < rm.getRules()[0][0][0][0].length; k2++) {
								for (int l = 0; l < rm.getRules()[0][0][0][0][0].length; l++) {
									for (int l2 = 0; l2 < rm.getRules()[0][0][0][0][0][0].length; l2++) {
										for (int m = 0; m < rm.getRules()[0][0][0][0][0][0][0].length; m++) {
											for (int m2 = 0; m2 < rm.getRules()[0][0][0][0][0][0][0][0].length; m2++) {
												if(Math.random()<mutateChance){
													rm.getRules()[i][j][j2][k][k2][l][l2][m][m2] = (byte)(Math.random()*numOfStates);
												}

											}
										}
									}
								}
							}
						}
					}
				}
			}


			//OLD mutation code(very slow)


			/*	//			System.out.println("before " + nextGen.get(i));
			mutate = nextGen.get(i).rulesToBinary().toCharArray();
			for (int j = 0; j < mutate.length; j++) {
				if(Math.random()<mutateChance){
					//					System.out.println("Mutated: " + mutate[j]);
					mutate[j] = (char) ((int)(Math.random()*numOfStates)+48);
					//					System.out.println("Into: " + mutate[j]);
				}
			}
			st = new String(mutate);
			generator.setRules(st);
			nextGen.get(i).setRules(generator.cloneRules());
			//			System.out.println("after " + nextGen.get(i));
		/**/
		}

		/*
		 * replacing
		 */
		population = nextGen;
		//		for (int i = 0; i < population.size(); i++) {
		//			System.out.println(population.get(i));
		//			
		//		}

	}
	/**
	 * random crossover
	 * @param dad
	 * @param mom
	 * @return
	 */


	/*
	 * NOTE: take care not to crossover to much, though random position of crossing is good, to many crossings might be a bad thing.
	 * NOTE: recalibrate and rethink this.
	 */

	private RuleModel crossover(RuleModel dad, RuleModel mom){

		double crossChance = 0.10;
		byte[][][][][][][][][] rules =generator.cloneRules();//will be overwritten
		boolean dadGenes = true;

		//		System.out.println("dad:" + dad.rulesToBinary());
		//		System.out.println("mom:" + mom.rulesToBinary());
		/* who to start selecting genes from */
		if(Math.random()>0.5){
			dadGenes= false;
		}else{
			dadGenes= true;
		}

		for (int i = 0; i < rules.length; i++) {
			for (int j = 0; j < rules[0].length; j++) {
				for (int j2 = 0; j2 < rules[0][0].length; j2++) {
					for (int k = 0; k < rules[0][0][0].length; k++) {
						for (int k2 = 0; k2 < rules[0][0][0][0].length; k2++) {
							for (int l = 0; l < rules[0][0][0][0][0].length; l++) {
								for (int l2 = 0; l2 < rules[0][0][0][0][0][0].length; l2++) {
									for (int m = 0; m < rules[0][0][0][0][0][0][0].length; m++) {
										for (int m2 = 0; m2 < rules[0][0][0][0][0][0][0][0].length; m2++) {
											if(Math.random()<crossChance){
												dadGenes= !dadGenes;
											}

											if(dadGenes){
												rules[i][j][j2][k][k2][l][l2][m][m2] = dad.getRules()[i][j][j2][k][k2][l][l2][m][m2];
											}else{
												rules[i][j][j2][k][k2][l][l2][m][m2] = mom.getRules()[i][j][j2][k][k2][l][l2][m][m2];
											}

										}
									}
								}
							}
						}
					}
				}
			}
		}
		RuleModel rm = new RuleModel(rules);
		//		System.out.println(rm.rulesToBinary());

		return rm;
	}


	public ArrayList<Double> getAvarageList() {
		return avarageList;
	}

	public ArrayList<Double> getBestList() {
		return bestList;
	}
	public RuleModel getBestSolution(){
		return bestSolution;
	}
	protected static double getLastElementIn(ArrayList<Double> ar){

		return ar.get(ar.size()-1);
	}

	public ArrayList<RuleModel> getPopulation() {
		return population;
	}




	public static void main(String[] args) {
		Scheduler.start();
	}

	/**
	 * thread method for starting the GA.
	 */
	@Override
	public void run() {
		for (int i = 0; i < this.maxIterations; i++) {


			//					System.out.println(population);
			//						System.out.println("iterate" + " at: " +  (new Date().getTime() - startTime.getTime()));
			iterateGeneration();
			//						System.out.println("test"+ " at: " + (new Date().getTime()- startTime.getTime()));
			bestSolution  = testGeneration();
			if(bestSolution.getFitnessValue()==this.maxFitness&&!firstDone){
				System.err.println("This thread is done." + bestSolution);
				break;
				/*
				System.err.println("This thread is half done." + bestSolution);
				firstDone = true;
				intermediatSolutionIterations = i;
				intermediatSolution = bestSolution.rulesToBinary();
				target = secondaryTarget;
			}else if(bestSolution.getFitnessValue()==this.maxFitness&&firstDone){
				System.err.println("This thread is done." + bestSolution);
				break;
				 /**/
			}
			//			System.out.println(population);
			if(i%100 == 0){
				System.out.println("this thread is " + i + " out of " + maxIterations + "runs." ) ;
				System.out.println(bestSolution);
			}
		}

		//		RuleModel rm = testGeneration();
		//		bestSolution = rm;
		System.out.println("Done"+ " at: " + (new Date().getTime()- startTime.getTime()));
		//		generator.resetBoard();
		//		generator.setRules(rm.getRules());
		//		generator.start(40);

		Scheduler.startAThread();

	}

	/**
	 * Scheduler made to ensure 3 threads are allways running. Should decrease experiment running time without changing any result. 
	 * @author tomeivin
	 *
	 */
	public static class Scheduler {
		static Date start = new Date();
		static String filesuffix = ".txt";
		static String file = "GA" + new SimpleDateFormat(" HHmm dd MM yyyy").format(new Date());
		static char tab = 9;
		static int nrOfGA = 100; // should be larger then 3. 
		static int MaxRunningGAAtTheTime = 3; //seems to work best when its equal to number of cores. or slight less. or even lower if you are running other things.

		static ArrayList<GA> gaList = new ArrayList<GA>();
		static Thread [] tr = new Thread[nrOfGA];
		static int k = 0;
		public static void start(){
			for (int j = 0; j < MaxRunningGAAtTheTime; j++) {
				startAThread();
			}
		}
		public static void startAThread(){
			if(k<nrOfGA){
				System.out.println("trail nr:" + k);
				GA ga = new GA(50, 10000, 40, 2, 30, 4, true);
				ga.setTarget(ga.flagBorderd);
				//ga.setSecondaryTarget(ga.Frenchflag);
				tr[k] = new Thread(ga);
				tr[k].start();
				gaList.add(ga);
				k++;
			}else{
				/* if a thread is still running, don't do nothing foo!*/
				int living = 0;
				for (int i = 0; i < tr.length; i++) {
					if(tr[i].getState()!=Thread.State.TERMINATED){
						//System.out.println(tr[i].getState());
						living++;
					}
				}
				if(living<=1){
					endExperiment();
				}
			}
		}
		public static void endExperiment(){
			CAOutputWriter writer = new CAOutputWriter(file + filesuffix); 
			// finds the list with the biggest size.
			int biggest = 0;
			for (int i = 0; i < gaList.size(); i++){
				if(gaList.get(i).getBestList().size()>biggest){
					biggest = gaList.get(i).getBestList().size();
				}
			}

			// for docu
			String line;
			/*writer.writeline("Avarage");
			for (int i = 0; i < biggest; i++) {
				line = "";
				for (int j = 0; j < gaList.size(); j++) {
					if(gaList.get(j).getAvarageList().size()>i){
						line+=  gaList.get(j).getAvarageList().get(i)+ "" + tab;
					}else{
						line+=  getLastElementIn(gaList.get(j).getAvarageList())+ ""+ tab;
					}
				}
				writer.writeline(line);
			}*/
			writer.writeline("Best");
			for (int i = 0; i < biggest; i++) {
				line = "";
				for (int j = 0; j < gaList.size(); j++) {
					if(gaList.get(j).getBestList().size()>i){
						line+=  gaList.get(j).getBestList().get(i)+ "" + tab;
					}else{
						line+=  getLastElementIn(gaList.get(j).getBestList()) + ""  + tab;
					}
				}
				writer.writeline(line);
			}
			/*
			 * write the num. of generations to finish first half. 
			 */
			writer.writeline("generations to first finish");
			line = "";
			for (int j = 0; j < gaList.size(); j++) {
				line+=  gaList.get(j).intermediatSolutionIterations+ "" + tab;
			}
			writer.writeline(line);
			/*
			 * rule at halfway. 
			 */
			writer.writeline("generations to first finish");
			line = "";
			for (int j = 0; j < gaList.size(); j++) {
				line+=  gaList.get(j).intermediatSolution+ "" + tab;
			}
			writer.writeline(line);
			/*
			 * write the num. of generations to finish. 
			 */
			writer.writeline("generations to finish");
			line = "";
			for (int j = 0; j < gaList.size(); j++) {
				line+=  gaList.get(j).getBestList().size()+ "" + tab;
			}
			writer.writeline(line);
			/*
			 * writing the rule that had the best fitness, so i may test it. 
			 */
			writer.writeline("best rules");
			line = "";
			for (int j = 0; j < gaList.size(); j++) {
				line+=  gaList.get(j).getBestSolution().rulesToBinary() + "" + tab;
			}
			writer.writeline(line);

			writer.close();

			System.out.println("GA Done"+ " at: " + (new Date().getTime()- start.getTime()));

		}
	}
}