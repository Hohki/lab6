/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class KassaQueue {

	private int maxsize = 0;

	private ArrayList<Kunder> queue = new ArrayList<Kunder>();

	/**
	 * Lägger till en Kund i Kassakö.
	 * 
	 * @param arg0
	 */

	public void add(Kunder arg0) {
		queue.add(arg0);
		if (queue.size() > maxsize) {
			maxsize = maxsize + 1;
		}
	}

	/**
	 * Returnerar kunden längs fram i Kassakö
	 *
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
	 * Returnerar om Kassakö är tom eller inte.
	 *
	 * @return isEmpty()
	 */

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * Returnerar största storleken av Kassakö.
	 *
	 * @return maxsize
	 **/
	public int maxSize() {
		return maxsize;
	}

	/**
	 * Tar bort första Kunden i Kassakö
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
	 * Returnerar storleken på Kassakö.
	 *
	 * @return size()
	 **/

	public int size() {
		return queue.size();
	}

	/**
	 * Returnerar Kassakö som en String.
	 *
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
