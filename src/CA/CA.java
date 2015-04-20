package CA;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CA {
	private boolean vonNaumanNeighbourhood = true;
	private int dimentions; 
	private int boardSize;
	private int numOfStates;
	private int [][] board;
	private int [][] boardNext;
	private int [][][][][][][][][] rules; // L,C,R,U,D,UL,UR,DL,UR;
	private CAOutputWriter out;

	public CA(int dimentions, int boardSize, int numOfStates, boolean ran) {
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
			rules = new int[numOfStates][numOfStates][numOfStates][1][1][1][1][1][1];
		}else if(vonNaumanNeighbourhood){
			rules = new int[numOfStates][numOfStates][numOfStates][numOfStates][numOfStates][1][1][1][1];
		}else {
			rules = new int[numOfStates][numOfStates][numOfStates][numOfStates][numOfStates][numOfStates][numOfStates][numOfStates][numOfStates];
		}
		setRandomRules();


	}


	public CA(int dimentions, int boardSize, int numOfStates, boolean ran, int numofRuns) {
		this(dimentions,boardSize,numOfStates,ran);
		start(numofRuns);

	}
	public void setRules(int [][][][][][][][][] rules){
		this.rules = rules;
	}

	/* why would i need to comment this it makes total sense...
	 *  ok ok, I know
	 *  because of the idiot also known as pastMyself i have to convert a binary to decimal string into a 9 dimensional array. so b is the most significant bit value. one needs to go through the array from that as a
	 *  starting point. 
	 *  
	 *  if you feel you understand what I've done and why, contact your nearest psychiatrist immediately.
	 */
	public void setRules(String rules){
		int b = (int) Math.pow(numOfStates, 2);
		if(dimentions==2){
			b=(int) Math.pow(numOfStates, 4);
		}
		if(!vonNaumanNeighbourhood){
			b = (int) Math.pow(numOfStates, 8);
		}

		//		for (int i = 0; i < this.rules.length; i++) {
		//			for (int j = 0; j < this.rules[0].length; j++) {
		//				for (int j2 = 0; j2 < this.rules[0][0].length; j2++) {
		//					for (int k = 0; k < this.rules[0][0][0].length; k++) {
		//						for (int k2 = 0; k2 < this.rules[0][0][0][0].length; k2++) {
		//							for (int l = 0; l < this.rules[0][0][0][0][0].length; l++) {
		//								for (int l2 = 0; l2 < this.rules[0][0][0][0][0][0].length; l2++) {
		//									for (int m = 0; m < this.rules[0][0][0][0][0][0][0].length; m++) {
		//										for (int m2 = 0; m2 < this.rules[0][0][0][0][0][0][0][0].length; m2++) {
		//											this.rules[i][j][j2][k][k2][l][l2][m][m2] = rules.charAt(i*b+j*b/2+j2*b/4+k*8+k2*b/8+l*b/16+l2*b/32 +m*b/64+m2*b/128)-48;
		//
		//										}
		//									}
		//								}
		//							}
		//						}
		//					}
		//				}
		//			}
		//		}
		int k, k1, k2,k3=0,k4=0,k5=0,k6=0,k7=0,k8=0, k9=0;
		for (int i = 0; i < rules.length(); i++) {
			k= i;
			k1 = k/b;
			k-= b*k1;
			k2 = (k/(b/numOfStates));
			k-= (b/numOfStates)*k2;
			k3 = (k/(b/(int)Math.pow(numOfStates, 2)));
			k-= (b/(int)Math.pow(numOfStates, 2))*k3;
			if((b/(int)Math.pow(numOfStates, 3)!=0)){
				k4 = (k/(b/(int)Math.pow(numOfStates, 3)));
				k-= (b/(int)Math.pow(numOfStates, 3))*k4;
				k5 = (k/(b/(int)Math.pow(numOfStates, 4)));
				k-= (b/(int)Math.pow(numOfStates, 4))*k5;
				if((b/(int)Math.pow(numOfStates, 5))!=0){
					k6 = (k/(b/(int)Math.pow(numOfStates, 5)));
					k-= (b/(int)Math.pow(numOfStates, 5))*k6;
					k7 = (k/(b/(int)Math.pow(numOfStates, 6)));
					k-= (b/(int)Math.pow(numOfStates, 6))*k7;
					k8 = (k/(b/(int)Math.pow(numOfStates, 7)));
					k-= (b/(int)Math.pow(numOfStates, 7))*k8;
					k9 = (k/(b/(int)Math.pow(numOfStates, 8)));
					k-= (b/(int)Math.pow(numOfStates, 8))*k9;
				}
			}
//			System.out.println(Integer.toBinaryString(i));
//			System.out.println(""+k1+k2+k3+k4+k5+k6+k7+k8+k9);
						this.rules[k1][k2][k3][k4][k5][k6][k7][k8][k9] = rules.charAt(i)-48;
		}


	}

	public int [][][][][][][][][]  getRules(){
		return this.rules;
	}

	public void setRulesElementary(int rule){
		String bin = Integer.toBinaryString(rule);
		for (int i = bin.length(); i < 8; i++) {
			bin = "0" + bin;
		}
		rules[0][0][0][0][0][0][0][0][0] = bin.charAt(7)-48;
		rules[0][0][1][0][0][0][0][0][0] = bin.charAt(6)-48;
		rules[0][1][0][0][0][0][0][0][0] = bin.charAt(5)-48;
		rules[0][1][1][0][0][0][0][0][0] = bin.charAt(4)-48;
		rules[1][0][0][0][0][0][0][0][0] = bin.charAt(3)-48;
		rules[1][0][1][0][0][0][0][0][0] = bin.charAt(2)-48;
		rules[1][1][0][0][0][0][0][0][0] = bin.charAt(1)-48;
		rules[1][1][1][0][0][0][0][0][0] = bin.charAt(0)-48;

	}
	public void resetBoard(){
		if(dimentions == 1){
			board = new int [boardSize][1];
			boardNext = new int [boardSize][1];
		}else{
			board = new int [boardSize][boardSize];
			boardNext = new int [boardSize][boardSize];
		}

		board[(board.length/2)][board[0].length/2] = 1;
		this.out = new CAOutputWriter(dimentions, boardSize, numOfStates);
	}
	public void setGameOfLife(){
		vonNaumanNeighbourhood = false;
		if(dimentions==2){
			for (int i = 0; i < rules.length; i++) {
				for (int j = 0; j < rules[0].length; j++) {
					for (int j2 = 0; j2 < rules[0][0].length; j2++) {
						for (int k = 0; k < rules[0][0][0].length; k++) {
							for (int k2 = 0; k2 < rules[0][0][0][0].length; k2++) {
								for (int l = 0; l < rules[0][0][0][0][0].length; l++) {
									for (int l2 = 0; l2 < rules[0][0][0][0][0][0].length; l2++) {
										for (int m = 0; m < rules[0][0][0][0][0][0][0].length; m++) {
											for (int m2 = 0; m2 < rules[0][0][0][0][0][0][0][0].length; m2++) {

												if(j==1&&(i+j2+k+k2+l+l2+m+m2)<2){
													rules[i][j][j2][k][k2][l][l2][m][m2] = 0;
													//													System.out.print("rule 1: ");
												}else if(j==1&&((i+j2+k+k2+l+l2+m+m2)==2||(i+j2+k+k2+l+l2+m+m2)==3)){
													//													System.out.print("rule 2: ");
													rules[i][j][j2][k][k2][l][l2][m][m2] = 1;
												}else if(j==1&&((i+j2+k+k2+l+l2+m+m2)>3)){
													//													System.out.print("rule 3: ");
													rules[i][j][j2][k][k2][l][l2][m][m2] = 0;
												}else if((j==0&&((i+j2+k+k2+l+l2+m+m2)==3))){
													//													System.out.print("rule 4: ");
													rules[i][j][j2][k][k2][l][l2][m][m2] = 1;
												}else{
													rules[i][j][j2][k][k2][l][l2][m][m2] = 0;
												}
												/*
												System.out.print("i:" + i);
												System.out.print("j:" + j);
												System.out.print("j2:" + j2);
												System.out.print("k:" + k);
												System.out.print("k2:" + k2);
												System.out.print("l:" + l);
												System.out.print("l2:" + l2);
												System.out.print("m:" + m);
												System.out.print("m2:" + m2);
												System.out.print(" value:" + rules[i][j][j2][k][k2][l][l2][m][m2]);
												System.out.println();/**/
											}
										}
									}
								}
							}
						}
					}
				}
			}

		}else{
			JFrame frame = new JFrame("Get your Sh*t togheter son!");
			JOptionPane.showMessageDialog(frame,
					"Why you no use right amount of dimentions?");
			System.exit(0);

		}
	}


	public void setRandomRules(){
		for (int i = 0; i < rules.length; i++) {
			for (int j = 0; j < rules[0].length; j++) {
				for (int j2 = 0; j2 < rules[0][0].length; j2++) {
					for (int k = 0; k < rules[0][0][0].length; k++) {
						for (int k2 = 0; k2 < rules[0][0][0][0].length; k2++) {
							for (int l = 0; l < rules[0][0][0][0][0].length; l++) {
								for (int l2 = 0; l2 < rules[0][0][0][0][0][0].length; l2++) {
									for (int m = 0; m < rules[0][0][0][0][0][0][0].length; m++) {
										for (int m2 = 0; m2 < rules[0][0][0][0][0][0][0][0].length; m2++) {
											rules[i][j][j2][k][k2][l][l2][m][m2] = (int) (Math.random()*numOfStates);
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
				}
			}
		}

	}
	/*
	 * incase you ever wonder if you are insane
	 */
	public int[][][][][][][][][] cloneRules() {

		int[][][][][][][][][] retur = new int [rules.length][rules[0].length][rules[0][0].length][rules[0][0][0].length]
				[rules[0][0][0][0].length][rules[0][0][0][0][0].length][rules[0][0][0][0][0][0].length][rules[0][0][0][0][0][0][0].length][rules[0][0][0][0][0][0][0][0].length];

		for (int i = 0; i < rules.length; i++) {
			for (int j = 0; j < rules[0].length; j++) {
				for (int j2 = 0; j2 < rules[0][0].length; j2++) {
					for (int k = 0; k < rules[0][0][0].length; k++) {
						for (int k2 = 0; k2 < rules[0][0][0][0].length; k2++) {
							for (int l = 0; l < rules[0][0][0][0][0].length; l++) {
								for (int l2 = 0; l2 < rules[0][0][0][0][0][0].length; l2++) {
									for (int m = 0; m < rules[0][0][0][0][0][0][0].length; m++) {
										for (int m2 = 0; m2 < rules[0][0][0][0][0][0][0][0].length; m2++) {
											retur[i][j][j2][k][k2][l][l2][m][m2] = rules[i][j][j2][k][k2][l][l2][m][m2];
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
				}
			}
		}



		return retur;
	}

	public void randomInitialisation(){
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
		//	printBoard();
		int l,r,c,u=0,d=0,ul=0,ur=0,dl=0,dr=0;
		for (int k = 0; k < num; k++) {
			for (int i = 0; i < board[0].length; i++) {
				for (int j = 0; j < board.length; j++) {
					l= board[(j+boardSize-1)%boardSize][i];
					c=board[j][i];
					r= board[(j+1)%boardSize][i];
					if(dimentions!=1){
						u = board[j][(i-1+boardSize)%boardSize];
						d = board[j][(i+1)%boardSize];
						if(!vonNaumanNeighbourhood){
							ul = board[(j+boardSize-1)%boardSize][(i-1+boardSize)%boardSize];
							ur = board[(j+1)%boardSize][(i-1+boardSize)%boardSize];
							dl = board[(j+boardSize-1)%boardSize][(i+1)%boardSize];
							dr = board[(j+1)%boardSize][(i+1)%boardSize];
						}
					}

					//System.out.println("l=" + l + " c=" + c + " r=" + r);
					//System.out.println("c-1: "+ j +"  = " + (j+boardSize-1)%boardSize);
					boardNext[j][i] = rules[l][c][r][u][d][ul][ur][dl][dr];

				}
			}
			setBoard(boardNext);
			//	printBoard();
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
	public int [][] getBoard(){
		return board;
	}



}
