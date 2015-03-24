package CA;

public class Run {

	
	
	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 1; 
		int boardSize = 9;
		int numOfStates = 2;
		int numberOfRuns = 20;
		boolean randomStart = false;
		
		CA ca = new CA(dimentions, boardSize, numOfStates, randomStart, numberOfRuns);
		
		
		

	}
}
