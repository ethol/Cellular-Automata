package CA;

public class ReplicationPartalModel implements Comparable{
	int x;
	int y;
	double value;

	public ReplicationPartalModel(int x, int y, double value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Object partial) {
		return (int) (((ReplicationPartalModel)partial).value - this.value);
	}
	
	public String toString(){
		return "" + value;
	}
}
