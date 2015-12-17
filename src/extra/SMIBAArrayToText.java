package extra;

import CA.IBASMRuleSett;

public class SMIBAArrayToText {
	final static int[][] test = new int[][]{
		{8,2,1,0,0,},{21,4,2,8,1,},{0,1,4,8,8,},{15,0,2,7,9,},{7,3,2,1,2,},{17,1,4,8,3,},{14,0,2,4,0,},{17,1,0,3,0,},{4,2,3,5,0,},{2,4,0,1,2,},

	};
	final static char[] op = new char[]{
		'L','C','R','U','D'
	};
	
	/*
	 * 0 = L
	 * 1 = C
	 * 2 = R
	 * 3 = U
	 * 4 = D
	 */
	
	public static void main(String[] args) {
		String st = "";
		for (int i = 0; i < test.length; i++) {
			st = "(" + IBASMRuleSett.ruleNameSM[test[i][0]];
			st += ", " + op[test[i][1]];
			st += ", " + op[test[i][2]];
			st += ", " + test[i][3];
			st += ", " + test[i][4]+ "),";
			System.out.print(st);
			//System.out.println();
		}
	}

}
