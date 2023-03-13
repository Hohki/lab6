/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

public class CustomerFactory {
	private static int number = -1;

	/**
	 * @param nothing
	 * @return number
	 **/
	public int getNumber() {
		number++;
		return number;
	}
}
