package lab6.state;

public class CustomerFactory {
	private int number;
	
	public CustomerFactory() {
		number = 0;
	}
	
	
	public Kunder CreateCustomers() {
		Kunder kund = new Kunder(number);
		number = number + 1;
		return kund;
	}
}
