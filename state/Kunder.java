/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

public class Kunder {
	private int customerNumber;

	/**
	 * Konstruktor för Kunder.
	 * 
	 * @param number
	 */
	public Kunder(int number) {
		this.customerNumber = number;
	}

	/**
	 * Returnerar kundnummret.
	 *
	 * @return customerNumber
	 */

	public int getID() {
		return this.customerNumber;
	}
}
