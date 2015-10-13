package CA;

public class CAIBA extends CA{
	protected byte [][] insSet;
	protected int instructionSetLength;
	private IBARuleSett ibaRuleFactory;


	public CAIBA(int dimentions, int boardSize, int numOfStates, boolean ran, int instructionSetLength) {
		super(dimentions, boardSize, numOfStates, ran, true);//sets Von Neumann neighborhood to true, as CAIBA has not ben set up to work with moores yet.
		this.instructionSetLength= instructionSetLength; 
		insSet = new byte[instructionSetLength][3];
		ibaRuleFactory = new IBARuleSett(numOfStates);

	}



	@Override
	public void setRandomRules(){
		for (int i = 0; i < insSet.length; i++) {
			insSet[i][0] = (byte) (Math.random()*IBARuleSett.ruleName.length); 
			insSet[i][1] = (byte) (Math.random()*5);
			insSet[i][2] = (byte) (Math.random()*5);
		}
		ibaRuleFactory.setRules(insSet);

	}
	@Override
	public void start(int num){
		if(super.useWriter){
			out.writeBlock(board);
		}
		
//		printBoard();

			int l,r,c,u=0,d=0/*,ul=0,ur=0,dl=0,dr=0/**/;
			for (int k = 0; k < num; k++) {
				for (int i = 0; i < board[0].length; i++) {
					for (int j = 0; j < board.length; j++) {
						l= board[(j+boardSize-1)%boardSize][i];
						c=board[j][i];
						r= board[(j+1)%boardSize][i];
						if(dimentions!=1){
							u = board[j][(i-1+boardSize)%boardSize];
							d = board[j][(i+1)%boardSize];
//							if(!vonNaumanNeighbourhood){//atm ignored
//								ul = board[(j+boardSize-1)%boardSize][(i-1+boardSize)%boardSize];
//								ur = board[(j+1)%boardSize][(i-1+boardSize)%boardSize];
//								dl = board[(j+boardSize-1)%boardSize][(i+1)%boardSize];
//								dr = board[(j+1)%boardSize][(i+1)%boardSize];
//							}
						}

						//System.out.println("l=" + l + " c=" + c + " r=" + r);
						//System.out.println("c-1: "+ j +"  = " + (j+boardSize-1)%boardSize);
						boardNext[j][i] = ibaRuleFactory.preformRules(new int []{u,c,d,l,r});// don't judge me!
					}
				}
				setBoard(boardNext);
				//	printBoard();
				if(useWriter){
				out.writeBlock(board);
				}
			}
			if(useWriter){
			out.close();
			}
		
	}


	public void setRules(byte [][] insSet){
		this.insSet = insSet;
		ibaRuleFactory.setRules(insSet);
	}

	public void printRules(){
		for (int i = 0; i < insSet.length; i++) {
			System.out.println(IBARuleSett.ruleName[insSet[i][0]] + ", op1: " + insSet[i][1] +  ", op2: " + insSet[i][2]);
		}
	}
	
	
	public byte[][] cloneIBARules() {
		byte [][] returner = new byte [insSet.length][insSet[0].length];
		for (int i = 0; i < insSet.length; i++) {
			for (int j = 0; j < insSet[0].length; j++) {
				returner[i][j] = insSet[i][j];
			}
		}
		return returner;
	}
	
	public static void main(String[] args) {
		CAIBA iba = new CAIBA(2, 6, 3, false, 10);
		iba.setRandomRules();
		iba.useWriter();
		iba.randomInitialisation();
//		iba.setRules(new int [][]{{0,1,0}});
		iba.printRules();
		
		iba.start(40);
	}

	/*
	 * DO NOT GO BEYOND THIS EDGE!
	 * Deprication graveyard of ultimate darkness
	 * 
	 */

	@Deprecated
	public void setRules(int [][][][][][][][][] rules){

	}
	@Deprecated
	public byte [][][][][][][][][]  getRules(){
		return null;
	}
	@Deprecated
	public void setRules(String rules){

	}
	@Deprecated
	public void setRulesElementary(int rule){

	}
	@Deprecated
	public void setGameOfLife(){

	}
	@Deprecated
	public byte[][][][][][][][][] cloneRules() {
		return null;
	}
	
	
	


}
