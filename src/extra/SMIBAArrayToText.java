package extra;

import CA.IBASMRuleSett;

public class SMIBAArrayToText {
	final static int[][] test = new int[][]{
		{1,2,4,7,0,},{3,4,3,0,9,},{17,4,4,4,8,},{5,0,4,5,5,},{0,0,1,7,6,},{8,1,1,5,5,},{1,4,0,8,5,},{11,1,1,8,5,},{12,3,2,5,3,},{17,0,1,2,6,},

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
