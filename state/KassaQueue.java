/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * 
 * Makes a Queue for the Kassa.
 *
 */
public class KassaQueue {

	private int maxsize = 0;

	private ArrayList<Kunder> queue = new ArrayList<Kunder>();

	/**
	 * Adds a Customer to the KassaQueue.
	 * @param arg0 arg0
	 */

	public void add(Kunder arg0) {
		queue.add(arg0);
		if (queue.size() > maxsize) {
			maxsize = maxsize + 1;
		}
	}

	/**
	 * Returns the Customer in the first spot.
	 * @return get(0)
	 */

	public Kunder first() throws NoSuchElementException {
		try {
			return queue.get(0);
		} catch (Exception e) {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Returns if the KassaQueue is empty or not.
	 * @return isEmpty()
	 */

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * Returns the biggest size of KassaQueue.
	 * @return maxsize
	 **/
	public int maxSize() {
		return maxsize;
	}

	/**
	 * Removes the first Customer in KassaQueue.
	 *
	 **/

	public void removeFirst() throws NoSuchElementException {
		try {
			queue.remove(0);
		} catch (Exception e) {
			throw new NoSuchElementException();
		}

	}

	/**
	 * Returns the size of the KassaQueue.
	 * @return size()
	 **/

	public int size() {
		return queue.size();
	}

	/**
	 * Returns KassaQueue as a String.
	 * @return s
	 **/

	@Override
	public String toString() {
		String s = "Queue: ";
		for (int i = 0; i < this.queue.size(); i++) {
			s = s + "(" + String.valueOf(this.queue.get(i).getID()) + ") ";
		}
		return s;
	}
}
