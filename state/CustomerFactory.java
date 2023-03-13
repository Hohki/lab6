/**
 * Albin, Khaled, Gabriel
 * */

package lab6.state;

public class CustomerFactory {
	private static int number = -1;
	public int getNumber() {
		number++;
		return number;
	}
}
