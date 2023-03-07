package lab6.state;

public class CreateCustomer {
	StoreState state;
	int number = 0;
	
	public void CreateCustomers() {
		state.customers.add(new Kunder(number, null));
	}
}
