package CA;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class GA {


	private int popSize;
	private int maxIterations;
	private int dimentions; 
	private int boardSize;
	private int numOfStates;
	boolean elitism = false;
	private CA generator;
	private ArrayList<RuleModel> population;
	
	private ArrayList<Double> avarageList = new ArrayList<Double>();
	private ArrayList<Double> bestList = new ArrayList<Double>();

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
//		RuleModel max = new RuleModel((generator.getRules()));
		RuleModel rm;
		for (int i = 0; i < popSize; i++) {
			rm = new RuleModel(generator.cloneRules());
			generator.setRandomRules();
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
		for (int i = 0; i < maxIterations; i++) {
			
		System.out.println(population);
		testGeneration();
//		System.out.println(population);
		iterateGeneration();
		}
		testGeneration();
		System.out.println(population);
		
		System.out.println("best List:");
		for (int i = 0; i < bestList.size(); i++) {
			System.out.println(bestList.get(i));
		}
		System.out.println("avarage List:");
		for (int i = 0; i < avarageList.size(); i++) {
			System.out.println(avarageList.get(i));
		}
	}
	
	
	private void testGeneration(){
		RuleModel rm;
		double avarage = 0.0;
		RuleModel max = new RuleModel((generator.cloneRules()));
		for (int i = 0; i < popSize; i++) {
			rm = population.get(i);
//			System.out.println("nr " + i + ": "  + rm);
			rm.setFitnessValue(fitnessFunction(rm.getRules()));
			if(rm.getFitnessValue()>max.getFitnessValue()){
				max=rm;
			}
//			System.out.println(rm);
			avarage+= rm.getFitnessValue();
		}
		System.out.println("best: "+max);
		bestList.add(max.getFitnessValue());
		System.out.println("avarage: "+ avarage/popSize);
		avarageList.add(avarage/popSize);
	}


	private double  fitnessFunction(int[][][][][][][][][] rules){



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
		double mutateChance = 0.04;
		char [] mutate;
		String st;
		int ct = 0;
		if(elitism){
			ct = 1;
		}
		for (int i = ct; i < nextGen.size(); i++) {
//			System.out.println("before " + nextGen.get(i));
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






	public static void main(String[] args) {
		GA ga = new GA(20, 50, 1, 5, 2, false);

	}
}