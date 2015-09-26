package CA;

import java.io.Writer;
import java.lang.reflect.Array;
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
	protected Date startTime = new Date();
	protected double maxFitness; 
	protected int popSize;
	protected int maxIterations;
	protected int dimentions; 
	protected int boardSize;
	protected int numOfStates;
	protected boolean elitism = false;
	private CA generator;
	private ArrayList<RuleModel> population;

	protected ArrayList<Double> avarageList = new ArrayList<Double>();
	protected ArrayList<Double> bestList = new ArrayList<Double>();
	protected RuleModel bestSolution;

	public GA(int popSize, int maxIterations, int dimentions, int boardSize,
			int numOfStates, boolean elitism) {

		this.popSize = popSize;
		this.maxIterations = maxIterations;
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
			rm.setFitnessValue(pixelFitnessFunction(rm.getRules()));
			if(rm.getFitnessValue()>=max.getFitnessValue()){
				max=rm;
			}
			//			System.out.println(rm);
			avarage+= rm.getFitnessValue();
		}

		//		System.out.println("best: "+max);
		bestList.add(max.getFitnessValue());
		//		System.out.println("avarage: "+ avarage/popSize);
		avarageList.add(avarage/popSize);
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
		generator.resetBoard();
		generator.setRules(rules);
		generator.start(5);
		for (int k = 0; k < 35; k++) {

			generator.start(1);
			int board[][] = generator.getBoard();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if(board[i][j] ==Frenchflag[i][j]){
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





	public static void main(String[] args) {
		Date start = new Date();
		String filesuffix = ".txt";
		String file = "GA";
		char tab = 9;
		int nrOfGA = 100; //make sure to be div by 4 or errors .
		int MaxRunningGAAtTheTime = 3; //seems to work best when its equal to number of cores. or slight less. or even lower if you are running other things.
		CAOutputWriter writer = new CAOutputWriter(file + filesuffix); 
		ArrayList<GA> gaList = new ArrayList<GA>();

		Thread [] tr = new Thread[nrOfGA];
		int k = 0;
		while(k<nrOfGA){
			for (int j = 0; j < MaxRunningGAAtTheTime; j++) {
				if(k==nrOfGA) {
					break;
				}
				System.out.println("trail nr:" + k);
				GA ga = new GA(50, 100000, 2, 6, 3, true);
				tr[k] = new Thread(ga);
				tr[k].start();
				gaList.add(ga);
				k++;
			
			}

			try {

				for (int j = k-MaxRunningGAAtTheTime; j < k; j++) {
					if(j==nrOfGA){
						break;
					}
					tr[j].join();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		// finds the list with the biggest size.
		int biggest = 0;
		for (int i = 0; i < gaList.size(); i++){
			if(gaList.get(i).getAvarageList().size()>biggest){
				biggest = gaList.get(i).getAvarageList().size();
			}
		}

		// for docu
		String line;
		writer.writeline("Avarage");
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
		}
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
			if(bestSolution.getFitnessValue()==this.maxFitness){
				System.err.println("This thread is done." + bestSolution);
				break;
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

	}
}