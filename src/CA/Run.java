package CA;

public class Run {

	
	
	public static void main(String[] args) {
		/*  Initialize variables */ 
		int dimentions = 2; 
		int boardSize = 19;
		int numOfStates = 2;
		int numberOfRuns = 40;
		boolean randomStart = false;
		
		CA ca = new CA(dimentions, boardSize, numOfStates, randomStart, numberOfRuns);
		
		
		

	}
}
