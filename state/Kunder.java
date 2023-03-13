/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;
/**
 * 
 * Class that makes the customerNumber.
 *
 */
public class Kunder {
	private int customerNumber;

	/**
	 * Constructor for Kunder.
	 * @param number number
	 */
	public Kunder(int number) {
		this.customerNumber = number;
	}

	/**
	 * Returns the customerNumber.
	 *
	 * @return customerNumber
	 */

	public int getID() {
		return this.customerNumber;
	}
}
