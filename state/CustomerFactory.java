package lab6.state;

public class CustomerFactory {
	private static int number = 0;
	public int getNumber() {
		number++;
		return number;
	}
}
