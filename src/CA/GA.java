package CA;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GA {
	

	private int popSize;
	private int maxIterations;
	private int dimentions; 
	private int boardSize;
	private int numOfStates;
	boolean elitism = false;
	CA generator;
	ArrayList<RuleModel> population;

	public GA(int popSize, int maxIterations, int dimentions, int boardSize,
			int numOfStates, boolean elitism) {
		this.popSize = popSize;
		this.maxIterations = maxIterations;
		this.dimentions = dimentions;
		this.boardSize = boardSize;
		this.numOfStates = numOfStates;
		this.elitism = elitism;
		population = new ArrayList<RuleModel>();

		generator = new CA(dimentions, boardSize, numOfStates, false);
		RuleModel max = new RuleModel((generator.cloneRules()));
		for (int i = 0; i < popSize; i++) {
			generator.setRandomRules();
			RuleModel rm = new RuleModel(generator.cloneRules());
//			System.out.println(rm);
			rm.fitnessValue = fitnessFunction(rm.rules);
			population.add(rm);
			if(rm.fitnessValue>max.fitnessValue)
				max=rm;

		}
		fitnessFunction((max.rules));
		System.out.println("best: "+max);

		iterateGeneration();
	}


	public double  fitnessFunction(int[][][][][][][][][] rules){



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
						//						System.out.print(":01:");
					}
				}
			}else{
				for (int j = 0; j < board.length; j++) {
					if(CAResult[j][0]==1){
						fitness++;
						//						System.out.print(":11:");
					}
				}
			}

			//System.out.println();
		}


		return fitness;
	}


	private void iterateGeneration(){
//		for (int i = 0; i < popSize; i++) {
//			System.out.println(population.get(i));
//		}
		
		ArrayList<RuleModel> nextGen = new ArrayList<RuleModel>();
		ArrayList<RuleModel> breeders = new ArrayList<RuleModel>();
		Collections.sort(population);

		/*
		 *  normalizing the fitness value.
		 */
		double sum = 0;
		for (int i = 0; i < population.size(); i++) {
			sum += population.get(i).fitnessValue;
		}
		for (int i = 0; i < population.size(); i++) {
			population.get(i).fitnessValue= population.get(i).fitnessValue/sum;
		}

		/*
		 * normalzing such that it becomes a distribution
		 */
		for (int i = 1; i < population.size(); i++) {
			population.get(i).fitnessValue+=population.get(i-1).fitnessValue;
		}
		//incase overflow causes the sum to be less then 1.
		population.get(popSize-1).fitnessValue = 1;

		double ran = 0;

		/*
		 * selecting breeders
		 */
		for (int i = 0; i < popSize*2; i++) {
			ran = Math.random();
			for (int j = 0; j < population.size(); j++) {
				if(population.get(j).fitnessValue>ran){
					breeders.add(population.get(j));
					break;
				}
			}
		}

		/*
		 * crossover 
		 */
		
	
		for (int i = 0; i < popSize*2; i+=2) {
			nextGen.add(crossover(breeders.get(i), breeders.get(i+1)));



		}


		/*
		 * muation
		 */
		for (int i = 0; i < nextGen.size(); i++) {
			System.out.println("before " + nextGen.get(i));
			generator.setRules(nextGen.get(i).rulesToBinary());
			nextGen.get(i).rules = generator.getRules();
			System.out.println("after " + nextGen.get(i));

		}

		/*
		 * replacing
		 */

	}
	/**
	 * random crossover
	 * @param dad
	 * @param mom
	 * @return
	 */
	
	
	/*
	 * take care not to crossover to much, though random position of crossing is good, to many crossings might be a bad thing.
	 */

	private RuleModel crossover(RuleModel dad, RuleModel mom){


		int[][][][][][][][][] rules =generator.cloneRules();//will be overwritten
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
											if(Math.random()>0.8){
												dadGenes= !dadGenes;
											}

											if(dadGenes){
												rules[i][j][j2][k][k2][l][l2][m][m2] = dad.rules[i][j][j2][k][k2][l][l2][m][m2];
											}else{
												rules[i][j][j2][k][k2][l][l2][m][m2] = mom.rules[i][j][j2][k][k2][l][l2][m][m2];
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






	public static void main(String[] args) {
		GA ga = new GA(20, 40, 1, 7, 2, false);

	}
}