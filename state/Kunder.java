package lab6.state;

public class Kunder {
	public int customerNumber;
	private Object customerState;
	
	public Kunder (int customerNumber, Object customerState) {
		this.customerNumber = customerNumber;
		this.customerState = customerState;
	}
	
	public int getID() {
		return this.customerNumber;
	}
}
