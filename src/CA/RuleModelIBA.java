package CA;


public class RuleModelIBA implements Comparable {
	private byte[][] rules;
	private double fitnessValue= 0.0;
	public RuleModelIBA(byte[][] bs){
		this.rules = bs;
	}
	@Override
	public int compareTo(Object ruleModelIBA) {
		return (int) (((RuleModelIBA)ruleModelIBA).fitnessValue - this.fitnessValue);
	}


	public byte[][] getRules() {
		return rules;
	}
	public void setRules(byte[][] rules) {
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