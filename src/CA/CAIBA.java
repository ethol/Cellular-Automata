package CA;

public class CAIBA extends CA{
	private int [][] insSet;
	

	public CAIBA(int dimentions, int boardSize, int numOfStates, boolean ran, int instructionSetLength) {
		super(dimentions, boardSize, numOfStates, ran, true);
		insSet = new int[instructionSetLength][3];
	}

}
