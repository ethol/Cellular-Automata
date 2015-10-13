package CA;

public class CAIBASM extends CAIBA{
	private IBASMRuleSett ibaRuleFactory;

	public CAIBASM(int dimentions, int boardSize, int numOfStates, boolean ran,
			int instructionSetLength) {
		super(dimentions, boardSize, numOfStates, ran, instructionSetLength);
		ibaRuleFactory = new IBASMRuleSett(numOfStates, instructionSetLength);
		insSet = new byte[instructionSetLength][5];
	}


	@Override
	public void setRandomRules(){
		for (int i = 0; i < insSet.length; i++) {
			insSet[i][0] = (byte) (Math.random()*IBASMRuleSett.ruleNameSM.length); 
			insSet[i][1] = (byte) (Math.random()*5);
			insSet[i][2] = (byte) (Math.random()*5);
			insSet[i][3] = (byte) (Math.random()*instructionSetLength);
			insSet[i][4] = (byte) (Math.random()*instructionSetLength);



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
					if(i==board[0].length -1 && j==board.length -1){//(tells it to do SM ( should speed it up by only performance it at the end.)
						ibaRuleFactory.preformSMNext(); 
						boardNext[j][i] = ibaRuleFactory.preformRules(new int []{u,c,d,l,r});// don't judge me!
						insSet = ibaRuleFactory.getRules();
					}else{
						boardNext[j][i] = ibaRuleFactory.preformRules(new int []{u,c,d,l,r});// don't judge me!
					}
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
	@Override
	public byte[][] cloneIBARules() {
		if(insSet.length == 0){//nullpointer 
			return null;
		}
		byte [][] returner = new byte [insSet.length][insSet[0].length];
		for (int i = 0; i < insSet.length; i++) {
			for (int j = 0; j < insSet[0].length; j++) {
				returner[i][j] = insSet[i][j];
			}
		}
		return returner;
	}


	@Override
	public void printRules(){
		for (int i = 0; i < insSet.length; i++) {
			System.out.println(IBASMRuleSett.ruleNameSM[insSet[i][0]] + ", op1: " + insSet[i][1] +  ", op2: " + insSet[i][2]+  ", op3: " + insSet[i][3]+  ", op4: " + insSet[i][4]);
		}
	}
	public void setRules(byte [][] insSet){
		this.insSet = insSet;
		this.insSet = cloneIBARules(); // fix for problem with rulesett changing.
		ibaRuleFactory.setRules(this.insSet);
	}


	public static void main(String[] args) {
		CAIBASM iba = new CAIBASM(2, 6, 3, false, 10);
		iba.setRandomRules();
		iba.useWriter();
		iba.randomInitialisation();
		//		iba.setRules(new int [][]{{0,1,0}});
		iba.printRules();

		iba.start(1);
	}

}
