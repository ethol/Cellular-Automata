package CA;

public class IBARuleSett {
	public final String  [] ruleName = {"AND", "OR", "XOR", "NOT" , "INV", "MIN", "MAX" , "SET", "INC", "DEC", "SWAP" , "ROR", "ROL", "ROU", "ROD", "NOP"};
	private int [][] rules;
	private int nOS; //Number of states
	private int [] nH = new int [5]; // Neighborhood 
	/*
	 * 0 = L
	 * 1 = C
	 * 2 = R
	 * 3 = U
	 * 4 = D
	 */

	public IBARuleSett(int nOS){
		this.nOS = nOS;
	}
	public int preformRules(int [] nH){
		this.nH = nH;
		for (int i = 0; i < rules.length; i++) {
			calculate(rules[i][0], rules[i][1], rules[i][2]);//makes strong assumptions of rules array. 
		}
		return nH[1];
	}
	/*
	 * Ever wanted to implement a RISC architecture into JAVA? Of course you have who doesen't, this is one way:
	 */
	public void calculate(int rule, int op1, int op2){
		int temp, temp2;
		switch(rule){
		case 0: //AND
			nH[op1] = nH[op1] & nH[op2] ; 	
		case 1: //OR
			nH[op1] = nH[op1] | nH[op2] ; 	
		case 2: //XOR
			nH[op1] = nH[op1] ^ nH[op2] ; 	
		case 3: //NOT
			nH[op1] = ~nH[op1]; 			
		case 4: //INV
			nH[op1] = nOS - nH[op2] ; 		
		case 5: //MAX
			nH[op1] = Math.max(nH[op1], nH[op2]);
		case 6: //MIN
			nH[op1] = Math.min(nH[op1], nH[op2]);
		case 7: //SET
			nH[op1] = nH[op2];
			return;
		case 8: //INC
			nH[op1] = nH[op1]++;
		case 9: //DEC
			nH[op1] =  nH[op1]--;
		case 10: //SWAP
			temp = nH[op1];
			nH[op1] = nH[op2];
			nH[op2] = temp;
			return;
		case 11: //ROR
			temp = nH[0];
			temp2 = nH[1];
			nH[0] = nH[2];
			nH[1] = temp;
			nH[2] = temp2;
			return;
		case 12: //ROL
			temp = nH[0];
			temp2 = nH[1];
			nH[1] = nH[2];
			nH[2] = temp;
			nH[0] = temp2;
			return;
		case 13: //ROU
			temp = nH[1];
			temp2 = nH[3];
			nH[1] = nH[4];
			nH[3] = temp;
			nH[4] = temp2;
			return;
		case 14: //ROD
			temp = nH[1];
			temp2 = nH[3];
			nH[3] = nH[4];
			nH[4] = temp;
			nH[1] = temp2;
			return;
		default: //NOP
		}
		// many of the mathimatical operations can cause overflow so modulo. also inverse java modolu accsept negative numbers which we dont want so we have to add nOS if it yealds a neg. 
		nH[op1]=nH[op1] %nOS;
		if(nH[op1]<0){
			nH[op1]+=nOS;
		}
	}
	
	
	public int[][] getRules() {
		return rules;
	}
	public void setRules(int[][] rules) {
		this.rules = rules;
		if(rules[0].length!=3){
			System.err.println("NAIN! DAS RULES BIST NICHT SO LANG YA!");
		}
	}

}
