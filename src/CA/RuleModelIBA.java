package CA;


public class RuleModelIBA implements Comparable {
	private int[][] rules;
	private double fitnessValue= 0.0;
	public RuleModelIBA(int[][] rules){
		this.rules = rules;
	}
	@Override
	public int compareTo(Object ruleModelIBA) {
		return (int) (((RuleModelIBA)ruleModelIBA).fitnessValue - this.fitnessValue);
	}


	public int[][] getRules() {
		return rules;
	}
	public void setRules(int[][] rules) {
		this.rules = rules;
	}
	public double getFitnessValue() {
		return fitnessValue;
	}
	public void setFitnessValue(double fitnessValue) {
		this.fitnessValue = fitnessValue;
	}
	
	public String toString(){
		return rulesToArray() + fitnessValue + "";
	}
	
	final int[][] creeperEasy = new int[][]{
			{1,1,0,0,1,1},
			{1,1,0,0,1,1},
			{0,0,1,1,0,0},
			{0,1,1,1,1,0},
			{0,1,1,1,1,0},
			{0,1,0,0,1,0},

	};
	
	public String rulesToArray(){
		String returner = "";
		for (int i = 0; i < rules.length; i++) {
			returner += "{";
			for (int j = 0; j < rules[0].length; j++) {
				returner += rules[i][j] + ",";
			}
			returner += "},";
		}
		
		return returner;
	}


}