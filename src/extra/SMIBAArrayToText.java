package extra;

import CA.IBASMRuleSett;

public class SMIBAArrayToText {
	final static int[][] test = new int[][]{
		{2,2,0,5,2,},{2,3,4,5,1,},{14,4,4,0,2,},{2,2,1,8,7,},{6,2,1,4,4,},{17,3,2,2,8,},{7,0,0,0,1,},{21,0,3,1,1,},{2,3,2,4,3,},{5,1,2,8,6,},

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
			System.out.println(st);
		}
	}

}
