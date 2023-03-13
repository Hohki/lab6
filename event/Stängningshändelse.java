/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

public class Stängningshändelse extends Event {
	/**
	 * Konstruktor för Stängningshändelse.
	 * 
	 * @param tid
	 */
	public Stängningshändelse(double tid) {
		super("Stängning", tid);
	}

	/**
	 * Stänger butiken.
	 */
	@Override
	public void effect() {
		state.notify(this);
		state.SetStoreState(false);
	}

}
