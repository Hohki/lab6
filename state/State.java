/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import lab6.event.Event;
import java.util.Observable;
/**
 * 
 * General state.
 *
 */
public class State extends Observable {
	public boolean simStop;
	protected double simTime;

	/**
	 * Constructor for State
	 */
	public State() {
		this.simStop = false;
	}

	/**
	 * Sets simTime to what time is
	 * @param time time
	 */
	public void SetSimTime(double time) {
		this.simTime = time;
	}

	/**
	 * notifies
	 * @param event event
	 */
	public void notify(Event event) {

	}

	/**
	 * Returns current time.
	 * @return simTime
	 */

	public double CurrentTime() {
		return simTime;
	}

	/**
	 * Sets stopSim to true.
	 */

	public void stopSim() {
		simStop = true;
	}

}
