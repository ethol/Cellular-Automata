package CA;

import java.util.ArrayList;

public class IBASMRuleSett extends IBARuleSett{
	public final static String  [] ruleNameSM = {"AND", "OR", "XOR", "NOT" , "INV", "MIN", "MAX" , "SET", "INC", "DEC", "SWAP" , "ROR", "ROL", "ROU", "ROD", "NOP", "SKIP", "MOVE", "DUPE", "DEL", "CHF", "CHP",};
	private ArrayList<byte []> toDo = new ArrayList<byte []>();
	int skipCounter = 0;//goTo command
	int maxInstructionLength;
	boolean preformSM = false;

	public IBASMRuleSett(int nOS, int insLength) {
		super(nOS);
		maxInstructionLength = insLength;
	}

	@Override
	public int preformRules(int [] nH){
		skipCounter=0;
		this.nH = nH;
		//		printNH();
		for (int i = 0; i < rules.length; i++) {
			if(skipCounter<=0){
				if(calculateSM(rules[i][0], rules[i][1], rules[i][2])){ //makes strong assumptions of rules array.)
					toDo.add(rules[i]);
				}
				//				System.out.println("noSkip");
			}else{
				skipCounter--;
				//				System.out.println("Skip");
			}
		}
		//		printNH();
		if(preformSM){
			selfModify(); //<-- keep at the end
			preformSM= false;
		}
		return nH[1];
	}

	/**
	 * adds the SM rules to the ToDo list.
	 */

	public boolean calculateSM(byte rule, byte op1, byte op2){
		super.calculate(rule, op1, op2);

		switch(rule){
		case 16: //SKIP
			skipCounter = op1;
			break;
		case 17: //MOVE
		case 18: //DUPE
		case 19: //DEL
		case 20: //CHF
		case 21: //CHP
			//			System.out.println("SM" + rule);
			return true;


		}
		return false;
	}
	/**
	 * Performs the selfModification of the rule set
	 */
	private void selfModify(){
		ArrayList<byte []> nextIns = new ArrayList<byte []>();
		for (int i = 0; i < rules.length; i++) {
			nextIns.add(rules[i]);
		}
		byte [] rule ;
		while(!toDo.isEmpty()){
			rule = toDo.remove(0);
			//			System.out.println(ruleNameSM[rule[0]]);
			if(nextIns.size()>rule[3]){
				switch(rule[0]){
				case 17: //MOVE
					//					System.out.println(rule[4] + " " + rule[3]);
					//					if(nextIns.size()-1>rule[4]){
					//						nextIns.add( nextIns.remove(rule[3]));
					//						break;
					//					}
					byte [] temp = nextIns.remove(rule[3]);
					if(nextIns.size()<rule[4]){
						nextIns.add(temp);//add it to the end
						break;
					}
					nextIns.add(rule[4], temp);
					break;
				case 18: //DUPE
					if(nextIns.size()<rule[4]){
						nextIns.add(nextIns.get(rule[3]));//add it to the end
						break;
					}
					nextIns.add(rule[4], nextIns.get(rule[3]));
					break;
				case 19: //DEL
					nextIns.remove(rule[3]);
					break;
				case 20: //CHF
					if(nextIns.size()>rule[4]){
						nextIns.get(rule[3])[0]=nextIns.get(rule[4])[0];
					}
					break;
				case 21: //CHP
					if(rule[1]==0){//NoOp
					}else if(rule[1]<=2){
						nextIns.get(rule[3])[rule[1]] = rule[2];
					}else{
						nextIns.get(rule[3])[rule[1]] = rule[4];
					}

					break;
				}//endswich


			}//endif
		}//endwhile
		if(nextIns.size()<maxInstructionLength){
			rules = new byte [nextIns.size()][5];
		}else{
			rules = new byte [maxInstructionLength][5];
		}
		//		System.out.println(nextIns.size());
		for (int i = 0; i < rules.length; i++) {
			rules[i] = nextIns.get(i);
		}

		//		System.out.println("next dev");
		//		printRules();
	}
	@Override
	public void setRules(byte[][] rules) {
		this.rules = rules;
		if(rules[0].length!=5){
			System.err.println("NEIN!");
		}
	}
	public void printRules(){
		for (int i = 0; i < rules.length; i++) {
			System.out.println(IBASMRuleSett.ruleNameSM[rules[i][0]] + ", op1: " + rules[i][1] +  ", op2: " + rules[i][2]+  ", op3: " + rules[i][3]+  ", op4: " + rules[i][4]);
		}
	}
	public void preformSMNext(){
		preformSM = true;
	}
	public byte[][] getRules(){
		return rules;
	}
}
