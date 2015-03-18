
public class CA {
	int dimentions; 
	int boardSize;
	int numOfStates;
	int [][] board;
	int [][] boardNext;
	int [][][][][] rules; // L,C,R,U,D;

	public CA(int dimentions, int boardSize, int numOfStates, boolean ran, int numofRuns) {
		this.dimentions = dimentions;
		this.boardSize = boardSize;
		this.numOfStates = numOfStates;
		if(dimentions == 1){
			board = new int [boardSize][1];
			boardNext = new int [boardSize][1];
			
		}else{
			board = new int [boardSize][boardSize];
			boardNext = new int [boardSize][boardSize];
		}
		if(ran){
			randomInitialisation();
		}else{
			board[(board.length/2)][board[0].length/2] = 1;
		}
		if(dimentions == 1){
			rules = new int[numOfStates][numOfStates][numOfStates][1][1];
		}else{
			rules = new int[numOfStates][numOfStates][numOfStates][numOfStates][numOfStates];
		}
		setRulesElementary(90);
		start(numofRuns);
	
	}

	private void setRulesElementary(int rule){
		String bin = Integer.toBinaryString(rule);
		for (int i = bin.length(); i < 8; i++) {
			bin = "0" + bin;
		}
		rules[0][0][0][0][0] = bin.charAt(7)-48;
		rules[0][0][1][0][0] = bin.charAt(6)-48;
		rules[0][1][0][0][0] = bin.charAt(5)-48;
		rules[0][1][1][0][0] = bin.charAt(4)-48;
		rules[1][0][0][0][0] = bin.charAt(3)-48;
		rules[1][0][1][0][0] = bin.charAt(2)-48;
		rules[1][1][0][0][0] = bin.charAt(1)-48;
		rules[1][1][1][0][0] = bin.charAt(0)-48;

	}

	private void randomInitialisation(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = (int) (Math.random()*numOfStates);
			}
		}
	}

	public void printBoard(){
		for (int i = 0; i < board[0].length; i++) {
			if(dimentions!=1)
				System.out.println();
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[j][i] + " ");
			}
		}
		System.out.println();
	}
	public void printBoardNext(){
		for (int i = 0; i < boardNext[0].length; i++) {
			if(dimentions!=1)
				System.out.println();
			for (int j = 0; j < boardNext.length; j++) {
				System.out.print(boardNext[j][i] + " ");
			}
		}
		System.out.println();
	}

	public void start(int num){
		printBoard();
		int l,r,c;
		for (int k = 0; k < num; k++) {
			for (int i = 0; i < board[0].length; i++) {
				for (int j = 0; j < board.length; j++) {
					l= board[(j+boardSize-1)%boardSize][i];
					c=board[j][i];
					r= board[(j+1)%boardSize][i];
					//System.out.println("l=" + l + " c=" + c + " r=" + r);
				//System.out.println("c-1: "+ j +"  = " + (j+boardSize-1)%boardSize);
					boardNext[j][i] = rules[l][c][r][0][0];

				}
			}
			setBoard(boardNext);
			printBoard();
		}
	}
	public void setBoard(int[][] newBoard){
		for (int i = 0; i < newBoard[0].length; i++) {
			for (int j = 0; j < newBoard.length; j++) {
				board[j][i] = newBoard[j][i];
			}
			
		}
	}

}
