package extra;

public class latexWriter {
	private static final String [] input = new String[]{
		"AND	31	38	40	36	23	1	41	210	34.77     ",
		"OR	30	35	29	35	41	4	34	208	34.44         ",
		"XOR	100	100	100	100	100	4	100	604	100.00    ",
		"NOT	48	21	44	35	35	4	38	225	37.25     ",
		"INV	47	36	41	40	42	1	42	249	41.23     ",
		"MIN	34	36	36	41	30	3	37	217	35.93     ",
		"MAX	38	33	35	39	32	3	38	218	36.09     ",
		"SET	43	47	47	47	52	0	40	276	45.70     ",
		"INC	48	39	49	36	30	2	34	238	39.40     ",
		"DEC	39	39	36	45	38	4	47	248	41.06     ",
		"SWAP	58	49	47	47	49	1	49	300	49.67     ",
		"ROR	36	42	42	53	46	1	56	276	45.70     ",
		"ROL	43	54	44	49	47	3	49	289	47.85     ",
		"ROU	41	52	45	40	45	1	44	268	44.37     ",
		"ROD	42	50	39	43	46	0	48	268	44.37     ",
		"NOP	47	49	44	49	42	0	36	267	44.21     ",





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
