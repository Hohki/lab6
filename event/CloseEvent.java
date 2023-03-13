/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

public class CloseEvent extends Event {
	/**
	 * A constructer for the CloseEvent, that creates an object of type
	 * close which basically closes the store at a specified time.
	 *
	 * @param tid Time at which the store closes at
	 */
	public CloseEvent(double tid) {
		super("Stängning", tid);
	}

	/**
	 * This method sets the stores state to closed.
	 */
	@Override
	public void effect() {
		state.notify(this);
		state.SetStoreState(false);
	}

}
