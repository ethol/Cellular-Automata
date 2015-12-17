package extra;

public class HemmingSMIBA {
	public static final int [][] input1 = new int[][]{
		{5,3,3,1,3,},{2,1,4,2,4,},{1,3,1,0,6,},{12,2,3,3,0,},{10,2,3,2,2,},{0,2,1,3,8,},{10,3,4,5,9,},{17,4,4,1,9,},{0,1,1,4,4,},{9,1,3,9,5,},
		{8,2,2,1,4,},{4,4,0,4,0,},{0,1,4,7,9,},{21,4,1,6,0,},{7,3,2,7,5,},{17,3,2,8,2,},{14,2,1,3,3,},{15,0,3,7,4,},{4,1,2,5,6,},{2,3,3,6,2,},
		{4,2,4,5,4,},{10,0,3,4,2,},{18,0,2,6,3,},{10,4,1,1,8,},{0,2,1,1,4,},{11,1,1,4,6,},{3,4,0,1,7,},{4,2,3,5,4,},{12,0,2,5,4,},{20,2,4,1,6,},
		{17,4,2,5,3,},{10,1,3,8,4,},{17,3,3,6,2,},{4,0,1,5,7,},{14,4,3,8,3,},{8,0,3,3,7,},{11,4,0,0,6,},{0,3,2,7,2,},{0,2,3,7,3,},{17,3,0,6,9,},
		{15,1,2,6,2,},{14,3,0,1,8,},{17,3,3,1,9,},{7,4,0,2,2,},{5,1,1,4,0,},{1,4,1,5,2,},{14,1,1,9,4,},{4,4,3,4,8,},{9,4,2,7,8,},{4,3,0,4,7,},







	};
	public static final int [][] input2 = new int[][]{
		{5,3,4,1,3,},{2,1,4,2,4,},{1,3,1,0,6,},{12,2,2,1,0,},{10,2,3,2,2,},{0,2,1,3,8,},{10,3,4,5,9,},{17,3,4,1,9,},{0,1,1,4,4,},{9,1,3,9,5,},
		{8,2,1,0,0,},{21,4,2,8,1,},{0,1,4,8,8,},{15,0,2,7,9,},{7,3,2,1,2,},{17,1,4,8,3,},{14,0,2,4,0,},{17,1,0,3,0,},{4,2,3,5,0,},{2,4,0,1,2,},
		{4,0,4,6,3,},{16,3,0,7,1,},{18,2,1,2,8,},{11,0,1,8,8,},{0,2,4,4,0,},{11,0,2,4,3,},{8,1,2,9,1,},{6,1,0,7,0,},{2,1,4,6,3,},{20,4,1,1,8,},
		{17,4,3,5,3,},{10,1,3,8,4,},{17,3,2,6,2,},{4,0,1,5,7,},{14,4,4,4,0,},{8,0,2,3,7,},{11,0,0,7,3,},{0,3,2,3,5,},{0,3,4,7,3,},{17,3,2,6,9,},
		{2,1,2,4,9,},{14,2,4,3,1,},{17,4,0,1,9,},{7,4,0,4,3,},{5,3,1,1,0,},{1,3,1,8,3,},{14,0,4,6,8,},{4,1,4,4,2,},{1,4,2,3,2,},{2,4,1,4,2,},




	};
	public static void main(String[] args) {
		double sum= 0,sumRem= 0, sumParam =0, max = 0, SMIIBA =0, IBASMI = 0, IBAIBA = 0, SMISMI = 0, SMI = 0, IBA = 0, insRemMax = 0, insRem=0;
		int [][] program1 = new int [10][];
		int [][] program2 = new int [10][];
		for (int i = 0; i < input1.length; i++) {
			program1[i%10] = input1[i];
			program2[i%10] = input2[i];
			if(i%10==9){
				sum +=hemmingDistance(program1, program2);
				sumRem +=hemmingDistanceRemGarbedge(program1, program2);
				sumParam += hemmingDistanceParam(program1, program2);
				max +=  hemmingDistanceMax(program1, program2);
				SMIIBA +=  hemmingDistanceSMIIBA(program1, program2);
				IBASMI +=  hemmingDistanceIBASMI(program1, program2);
				SMISMI +=  hemmingDistanceSMISMI(program1, program2);
				IBAIBA +=  hemmingDistanceIBAIBA(program1, program2);
				IBA+=  hemmingDistanceIBA(program1, program2);
				SMI +=  hemmingDistanceSMI(program1, program2);
				insRemMax +=  hemmingDistanceMAXI(program1, program2);
				insRem +=  hemmingDistanceI(program1, program2);
			}

		}
		//System.out.println(input1.length);
		System.out.println("Total: 		"+sum/(input1.length /10) + "	%: " +(sum/(input1.length /10))/50*100);
		System.out.println("TotalRem: 	"+sumRem/(input1.length /10) + "	%: " +(sumRem/(input1.length /10))/(max/(input1.length) /10));
		System.out.println("Parameter: 	" +sumParam/(input1.length /10) +"	%: " +(sumParam/(input1.length /10)*100)/((max/(input1.length) /10*100)-(insRemMax/(input1.length /10))));
		System.out.println("Instruction: 	" + (sumRem-sumParam)/(input1.length /10)+ "	%: " +(sumRem-sumParam)/(input1.length /10)/(insRemMax/(input1.length /10)) *100);
		System.out.println("IChecksum: 	" + (insRem)/(input1.length /10)+ "	%: " +(insRem)/(input1.length /10)/(insRemMax/(input1.length /10)) *100);
		System.out.println("SMI->IBA: 	" + (SMIIBA)/(input1.length /10));
		System.out.println("IBA->SMI: 	" + (IBASMI)/(input1.length /10));
		System.out.println("SMI->SMI: 	" + (SMISMI)/(input1.length /10));
		System.out.println("IBA->IBA: 	" + (IBAIBA)/(input1.length /10));
		System.out.println("Max: 		" + max/(input1.length /10));
		System.out.println("SMI: 		" + SMI/(input1.length /10));
		System.out.println("IBA: 		" + (insRemMax-SMI)/(input1.length /10));
		System.out.println("MaxI: 		" + insRemMax/(input1.length /10));
	}

	public static int hemmingDistance(int [][] a, int [][] b){

		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if(a[i][j]!=b[i][j]){
					retur++;
				}
			}
		}
		return retur;
	}
	public static int hemmingDistanceRemGarbedge(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if(!hasCHF){
					if(a[i][j]!=b[i][j]&&hasRelevance(a[i], b[i], j)){
						/*System.out.println(j+"("+a[i][0] +", " + a[i][1] +", " + a[i][2] +", " + a[i][3] +", " + a[i][4] + ")");
						System.out.println(j+"("+b[i][0] +", " + b[i][1] +", " + b[i][2] +", " + b[i][3] +", " + b[i][4] + ")");
						System.out.println(hasRelevance(a[i], b[i], j));*/
						retur++;
					}
				} else if(a[i][j]!=b[i][j]){
					retur++;
				}
			}
		}
		return retur;
	}
	private static int trimProgram(int [][] a){
		int retur = a.length;
		int ins = 0;
		for (int i = a.length-1; i >= 0; i--) {
			ins = a[i][0];
			if(ins<16&&ins!=14&&ins!=13&&ins!=12&&ins!=11){
				if((ins<10&&a[i][1]!=1)||ins==15){
					//System.out.println("("+a[i][0] +", " + a[i][1] +", " + a[i][2] +", " + a[i][3] +", " + a[i][4] + ")");
					retur--;
				}else if(ins==14&&a[i][1]!=1&&a[i][2]!=1){
					//System.out.println("("+a[i][0] +", " + a[i][1] +", " + a[i][2] +", " + a[i][3] +", " + a[i][4] + ")");
					retur--;
				}else{
					break;
				}
			}else{
				break;
			}
		}
		return retur;
	}
	public static int hemmingDistanceParam(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(j!=0){
					if(!hasCHF){
						if(a[i][j]!=b[i][j]&&hasRelevance(a[i], b[i], j)){
						retur++;
						}
					}else if(a[i][j]!=b[i][j]){
						retur++;
					}
				}
			}
		}
		return retur;
	}
	public static int hemmingDistanceMax(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(hasRelevance(a[i], b[i], j)&&!hasCHF){
					retur++;
				} else if(hasCHF){
					retur++;
				}
			}
		}
		return retur;
	}
	public static int hemmingDistanceSMIIBA(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]>=16&&b[i][0]<16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceIBASMI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]<16&&b[i][0]>=16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceSMISMI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]>=16&&b[i][0]>=16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceIBAIBA(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]<16&&b[i][0]<16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}

	public static int hemmingDistanceIBA(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]<16){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceSMI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]>=16){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceMAXI(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			retur++;
		}
		return retur;
	}

	public static boolean hasRelevance(int [] a, int [] b, int param){
		switch (a[0]) {
		case 0:
		case 1:
		case 2:
			if(param==3||param==4){
				return false;
			}
			break;
		case 3:
		case 4:
			if(param==2||param==3||param==4){
				return false;
			}
			break;
		case 5:
		case 6:
			if(param==3||param==4){
				return false;
			}
			break;
		case 7:
			if(param==3||param==4){
				return false;
			}
			break;
		case 8:
		case 9:
			if(param==2||param==3||param==4){
				return false;
			}
			break;
		case 10:
			if(param==3||param==4){
				return false;
			}
			break;
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
			if(param==1||param==2||param==3||param==4){
				return false;
			}
			break;
		case 16:
			if(param==2||param==3||param==4){
				return false;
			}
			break;
		case 17:
		case 18:
			if(param==1||param==2){
				return false;
			}
			break;
		case 19:
			if(param==1||param==2||param==4){
				return false;
			}
			break;
		case 20:
		case 21:


			break;
		}
		return true;
	}
}
