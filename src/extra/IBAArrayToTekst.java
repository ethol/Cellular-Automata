package extra;

import CA.IBARuleSett;

public class IBAArrayToTekst {
	final static int[][] test = new int[][]{
		{2,0,1,},{14,0,1,},{1,1,1,},{2,1,0,},{12,4,1,},{5,1,4,},{6,2,2,},{13,3,0,},{14,1,4,},{7,1,0,},

		//{8,0,1,},{2,2,0,},{6,4,3,},{0,4,1,},{13,2,1,},{11,0,3,},{4,2,1,},{11,4,1,},{2,1,3,},{1,1,0,},

//		{2,2,0,},{14,2,3,},{4,0,3,},{5,4,3,},{12,0,1,},{12,2,3,},{1,1,0,},{8,1,3,},{2,1,4,},{8,0,1,},




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
			st = "(" + IBARuleSett.ruleName[test[i][0]];
			st += ", " + op[test[i][1]];
			st += ", " + op[test[i][2]]+ ")";
			System.out.println(st);
		}
	}

}
