package CA;


public class RuleModel implements Comparable {
	private int[][][][][][][][][] rules;
	private double fitnessValue= 0.0;
	public RuleModel(int[][][][][][][][][] rules){
		this.rules = rules;
	}
	@Override
	public int compareTo(Object ruleModel) {
		return (int) (((RuleModel)ruleModel).fitnessValue - this.fitnessValue);
	}
	public String toString(){
		return rulesToBinary() +" : " + fitnessValue + "";
	}

	public String rulesToBinary(){
		String results = "";
		for (int i = 0; i < rules.length; i++) {
			for (int j = 0; j < rules[0].length; j++) {
				for (int j2 = 0; j2 < rules[0][0].length; j2++) {
					for (int k = 0; k < rules[0][0][0].length; k++) {
						for (int k2 = 0; k2 < rules[0][0][0][0].length; k2++) {
							for (int l = 0; l < rules[0][0][0][0][0].length; l++) {
								for (int l2 = 0; l2 < rules[0][0][0][0][0][0].length; l2++) {
									for (int m = 0; m < rules[0][0][0][0][0][0][0].length; m++) {
										for (int m2 = 0; m2 < rules[0][0][0][0][0][0][0][0].length; m2++) {

											results = results+ rules[i][j][j2][k][k2][l][l2][m][m2];

										}

									}
								}
							}
						}
					}
				}
			}
		}
		return results;
	}
	public int[][][][][][][][][] getRules() {
		return rules;
	}
	public void setRules(int[][][][][][][][][] rules) {
		this.rules = rules;
	}
	public double getFitnessValue() {
		return fitnessValue;
	}
	public void setFitnessValue(double fitnessValue) {
		this.fitnessValue = fitnessValue;
	}


}