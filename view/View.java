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
	 * Konstruktor för View.
	 * 
	 * @param state
	 */
	public View(State state) {
		this.state = state;
	}

	/**
	 * @param o   Det state som blir observerat
	 * @param arg Det event som ändrade på state
	 */

	@Override
	public void update(Observable o, Object arg) {

	}
}
