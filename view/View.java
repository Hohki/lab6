/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.view;

import java.util.Observer;
import lab6.state.State;
import java.util.Observable;

public class View implements Observer {
	protected State state;

	/**
	 * Constructor for View.
	 * 
	 * @param state
	 */
	public View(State state) {
		this.state = state;
	}

	/**
	 * @param o   The state being observed
	 * @param arg The event that changed state
	 */

	@Override
	public void update(Observable o, Object arg) {

	}
}
