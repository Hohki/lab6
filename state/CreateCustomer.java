package lab6.state;

public class CreateCustomer {
	StoreState state;
	int number = 0;
	private Object customerStage = Plockhändelse;
	
	public void CreateCustomers() {
		state.customers.add(new Kunder(number, customerStage));
		number = number + 1;
	}
}
