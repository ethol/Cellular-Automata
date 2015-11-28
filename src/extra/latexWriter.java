package extra;

public class latexWriter {
	private static final String [] input = new String[]{
		"AND	26	33	1	5	x	x	65	36.52       ",
		"OR	72	45	1	1	x	x	119	66.85           ",
		"XOR	52	55	0	1	x	x	108	60.67       ",
		"NOT	31	17	1	1	x	x	50	28.09       ",
		"INV	45	23	0	2	x	x	70	39.33       ",
		"MIN	58	59	1	1	x	x	119	66.85       ",
		"MAX	24	31	0	1	x	x	56	31.46       ",
		"SET	21	19	0	1	x	x	41	23.03       ",
		"INC	42	48	1	1	x	x	92	51.69       ",
		"DEC	38	38	0	4	x	x	80	44.94       ",
		"SWAP	33	25	0	4	x	x	62	34.83       ",
		"ROR	25	31	1	0	x	x	57	32.02       ",
		"ROL	41	30	1	1	x	x	73	41.01       ",
		"ROU	34	21	0	3	x	x	58	32.58       ",
		"ROD	25	24	0	1	x	x	50	28.09       ",
		"NOP	23	11	0	0	x	x	34	19.10       ",
		"SKIP	17	7	0	1	x	x	25	14.04       ",
		"MOVE	58	59	1	5	x	x	123	69.10       ",
		"DUPE	35	28	0	0	x	x	63	35.39       ",
		"DEL	6	6	0	0	x	x	12	6.74        ",
		"CHF	24	21	0	1	x	x	46	25.84       ",
		"CHP	22	16	0	1	x	x	39	21.91       ",
		"SM ins.	91	79	1	5	x	x	176	98.88   ",



	};

	public static void main(String[] args) {
		char tab = 9;
		String line[];
		for (int i = 0; i < input.length; i++) {
			line = input[i].trim().split(tab +"")
					;
			for (int j = 0; j < line.length; j++) {
				if(j==line.length-1){
					System.out.print(line[j] + "\\%\\\\");
				}else{
					System.out.print(line[j] + " & ");
				} 
			}
			System.out.println();
		}
	}
}
