package extra;

import CA.IBASMRuleSett;

public class CountInstructions {
	public static final int[][] set = new int [][]{
		{0,0,1,1,0,},{17,0,4,3,9,},{4,0,4,4,7,},{14,1,3,7,7,},{0,3,3,0,2,},{0,1,0,0,5,},{9,4,2,4,4,},{0,1,1,3,1,},{13,2,2,2,4,},{10,0,4,7,8,},
		{5,1,2,7,0,},{5,4,2,3,3,},{10,3,2,1,2,},{17,3,0,6,0,},{9,0,3,3,4,},{0,1,3,6,9,},{16,2,0,6,7,},{16,3,0,5,9,},{10,4,3,6,5,},{9,1,3,3,8,},
		{8,1,3,9,5,},{0,4,2,9,5,},{0,0,4,8,2,},{6,1,1,1,9,},{3,3,0,1,6,},{17,1,1,0,8,},{17,0,0,4,5,},{7,0,1,7,4,},{7,0,1,8,9,},{6,1,0,3,0,},
		{1,0,2,8,1,},{9,1,1,1,5,},{2,1,2,2,0,},{17,1,2,6,0,},{10,4,1,6,6,},{0,3,1,7,3,},{17,1,2,9,3,},{13,0,0,1,8,},{10,3,0,5,6,},{20,4,0,3,7,},
		{21,4,2,8,3,},{9,1,4,2,3,},{17,2,0,9,1,},{12,3,1,0,4,},{4,0,3,4,3,},{0,0,3,5,6,},{10,3,2,3,6,},{0,2,1,8,1,},{4,1,4,3,1,},{13,3,1,3,1,},





	};
	public static void main(String[] args) {
		boolean [] temp = new boolean [22];
		int [] used = new int [22];
		int SM = 0;
		for (int i = 0; i < set.length; i++) {
			temp[set[i][0]] = true;
			if(i%10 == 9){// set to instruction length (should also work for SM since they all start with the same number of ins.)
				for (int j = 16; j < temp.length; j++) {
					if(temp[j]==true){
						SM++;
						break;
					}
				}
				for (int j = 0; j < temp.length; j++) {
					if(temp[j]){
						used[j]++;
						temp[j] = false;
					}
				}
			}
			
		}
		
		
		for (int i = 0; i < used.length; i++) {
			System.out.println(IBASMRuleSett.ruleNameSM[i] +""+  '	' + " " + used[i] );
		}
		System.out.println(SM + " of the solutions used atleast 1 SM instructions");

	}

}
