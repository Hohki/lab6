package lab6.state;

public class CreateCustomer {
	StoreState state;
	int number = 0;
	
	public void createCustomer() {
		state.customers.add(new Customer(number, null));
	}
}
