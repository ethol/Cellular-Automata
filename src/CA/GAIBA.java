package CA;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import CA.GA.Scheduler;


public class GAIBA extends GA{
	protected int numberOfInstructions;

	private CAIBA generator;
	protected ArrayList<RuleModelIBA> population;
	protected RuleModelIBA bestSolution;

	public GAIBA(int popSize, int maxIterations, int maxDevIterations, int dimentions, int boardSize,
			int numOfStates, boolean elitism, int numberOfInstructions) {
		super(popSize, maxIterations,maxDevIterations, dimentions, boardSize, numOfStates, elitism);//probbebly redundant.
		// TODO Auto-generated constructor stub
		this.numberOfInstructions = numberOfInstructions;
		generator = new CAIBA(dimentions, boardSize, numOfStates, false, numberOfInstructions);
		population = new ArrayList<RuleModelIBA>();
		RuleModelIBA rm;
		for (int i = 0; i < popSize; i++) {
			generator.setRandomRules();
			rm = new RuleModelIBA(generator.cloneIBARules());
			//						System.out.println(rm);
			//rm.setFitnessValue(fitnessFunction(rm.getRules()));
			population.add(rm);
			//			System.out.println(population);
			//			if(rm.getFitnessValue()>max.getFitnessValue()){
			//				max=rm;
			//			}
			//			System.out.println(rm);

		}

	}

	private RuleModelIBA testGeneration(){
		RuleModelIBA rm;
		double avarage = 0.0;
		RuleModelIBA max = new RuleModelIBA((generator.cloneIBARules()));
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
		avarageList.add(avarage/popSize);
		return max;
	}

	protected double  pixelFitnessFunction(int[][] rules){
		double fitness = 0.0;
		double maxFitness = 0.0;
		generator.resetBoard();
		generator.setRules(rules);
		generator.start(5);
		for (int k = 0; k < (maxDevIterations-5); k++) {

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
	private double replicationFitnessFunction(int[][] rules, int nrReplicated){
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
	
	private double evoDevoFitnessFunction(int[][] rules, int nrReplicated){
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
		generator.start(bestDev);
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

	private void iterateGeneration(){
		//		for (int i = 0; i < popSize; i++) {
		//			System.out.println(population.get(i));
		//		}

		int nrBreeders = popSize*2;
		ArrayList<RuleModelIBA> nextGen = new ArrayList<RuleModelIBA>();
		ArrayList<RuleModelIBA> breeders = new ArrayList<RuleModelIBA>();
		Collections.sort(population);
		if(elitism){
			nextGen.add(population.get(0));
			/*if(!confirmFitnessValue(population.get(0))){
				System.out.println("elite is wong! " + population.get(0).getFitnessValue());
			};*/
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
		int ct = 0;
		if(elitism){
			ct = 1;
		}
		for (int i = ct; i < nextGen.size(); i++) {
			//			System.out.println("before " + nextGen.get(i));
			for (int j = 0; j < numberOfInstructions; j++) {
				for (int j2 = 0; j2 < 3; j2++) {//FIXED TO 3. 

					if(Math.random()<mutateChance){
						if(j2!=0){
							nextGen.get(i).getRules()[j][j2] = (int)(Math.random()*5);//FIXED to Von Neumann size 5.
						}else{
							nextGen.get(i).getRules()[j][j2] = (int)(Math.random()*IBARuleSett.ruleName.length);
						}

					}
				}
			}
			//			generator.setRules(st);
			//			nextGen.get(i).setRules(generator.cloneRules());
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

	protected RuleModelIBA crossover(RuleModelIBA dad, RuleModelIBA mom){

		double crossChance = 0.10;
		int[][] rules =generator.cloneIBARules();//will be overwritten
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

				if(Math.random()<crossChance){
					dadGenes= !dadGenes;
				}

				if(dadGenes){
					rules[i][j] = dad.getRules()[i][j];
				}else{
					rules[i][j] = mom.getRules()[i][j];
				}


			}
		}
		RuleModelIBA rm = new RuleModelIBA(rules);
		//		System.out.println(rm.rulesToBinary());

		return rm;
	}





	/*private boolean confirmFitnessValue(RuleModelIBA rule){
		if(rule.getFitnessValue()==pixelFitnessFunction(rule.getRules())){
			return true;
		}
	
		return false;
	}*/








	public static void main(String[] args) {
	 Scheduler.start();

	}


	public RuleModelIBA getBestSolutionIBA(){
		return bestSolution;
	}


	@Deprecated
	public RuleModel getBestSolution(){
		return super.getBestSolution();
	}

	/**
	 * thread method for starting the GA.
	 */
	@Override
	public void run() {
		for (int i = 0; i < this.maxIterations; i++) {


			//					System.out.println(population);
			//			System.out.println("iterate" + " at: " +  (new Date().getTime() - startTime.getTime()));
			iterateGeneration();
			//			System.out.println("test"+ " at: " + (new Date().getTime()- startTime.getTime()));
			bestSolution  = testGeneration();
			if(bestSolution.getFitnessValue()==this.maxFitness){
				System.err.println("This thread is done." + bestSolution);
				break;
			}
			//			System.out.println(population);
			if(i%(100) == 0){
				System.out.println("this thread is " + i + " out of " + maxIterations + "runs." ) ;
				System.out.println(bestSolution);
			}
		}

//		RuleModelIBA rm = testGeneration();
//		bestSolution = rm;
//		System.err.println("best solution: "  +rm.rulesToArray());
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
		static String file = "GAIBA" + new SimpleDateFormat(" HHmm dd MM yyyy").format(new Date());
		static char tab = 9;
		static int nrOfGA = 100;
		static int MaxRunningGAAtTheTime = 3; //seems to work best when its equal to number of cores. or slight less. or even lower if you are running other things.
		static ArrayList<GAIBA> gaList = new ArrayList<GAIBA>();
		
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
				GAIBA ga = new GAIBA(50, 10000,40, 2, 25, 2, true, 10);
				ga.setTarget(ga.simpleSimpleStructureBorderd);
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
				line+=  gaList.get(j).getBestSolutionIBA().rulesToArray()+ "" + tab;
			}
			writer.writeline(line);

			writer.close();
			System.out.println("GA Done"+ " at: " + (new Date().getTime()- start.getTime()));

		}
	}

}
