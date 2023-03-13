/**
 * @author Albin
 * @author Khaled
 * @outhor Gabriel
 * */

package lab6.state;

public class Kunder {
	private int customerNumber;

	/**
	 * @param number
	 * @return nothing
	 * */
	public Kunder(int number) {
		this.customerNumber = number;
	}

	/**
	 * @param Nothing
	 * @return customerNumber
	 * */

	public int getID() {
		return this.customerNumber;
	}
}
