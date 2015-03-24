package CA;

public class CA {
	private int dimentions; 
	private int boardSize;
	private int numOfStates;
	private int [][] board;
	private int [][] boardNext;
	private int [][][][][] rules; // L,C,R,U,D;
	private CAOutputWriter out;

	public CA(int dimentions, int boardSize, int numOfStates, boolean ran, int numofRuns) {
		this.dimentions = dimentions;
		this.boardSize = boardSize;
		this.numOfStates = numOfStates;
		this.out = new CAOutputWriter(dimentions, boardSize, numOfStates);
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
//		setRulesElementary(110);
		setRandomRules();
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


	private void setRandomRules(){
		for (int i = 0; i < rules.length; i++) {
			for (int j = 0; j < rules[0].length; j++) {
				for (int j2 = 0; j2 < rules[0][0].length; j2++) {
					for (int k = 0; k < rules[0][0][0].length; k++) {
						for (int k2 = 0; k2 < rules[0][0][0][0].length; k2++) {
							rules[i][j][j2][k][k2] = (int) (Math.random()*numOfStates);
							/*
							System.out.print("i:" + i);
							System.out.print("j:" + j);
							System.out.print("j2:" + j2);
							System.out.print("k:" + k);
							System.out.print("k2:" + k2);
							System.out.print(" value:" + rules[i][j][j2][k][k2]);
							System.out.println();/**/
						}
					}
				}
			}
		}


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
		out.writeBlock(board);
		printBoard();
		int l,r,c,u=0,d=0;
		for (int k = 0; k < num; k++) {
			for (int i = 0; i < board[0].length; i++) {
				for (int j = 0; j < board.length; j++) {
					l= board[(j+boardSize-1)%boardSize][i];
					c=board[j][i];
					r= board[(j+1)%boardSize][i];
					if(dimentions!=1){
					u = board[j][(i-1+boardSize)%boardSize];
					d = board[j][(i+1)%boardSize];
					}
				
					//System.out.println("l=" + l + " c=" + c + " r=" + r);
					//System.out.println("c-1: "+ j +"  = " + (j+boardSize-1)%boardSize);
					boardNext[j][i] = rules[l][c][r][u][d];

				}
			}
			setBoard(boardNext);
			printBoard();
			out.writeBlock(board);
		}
		out.close();
	}
	public void setBoard(int[][] newBoard){
		for (int i = 0; i < newBoard[0].length; i++) {
			for (int j = 0; j < newBoard.length; j++) {
				board[j][i] = newBoard[j][i];
			}

		}
	}

	

}
