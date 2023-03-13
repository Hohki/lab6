/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import lab6.event.Event;
import java.util.Observable;

public class State extends Observable {
	public boolean simStop;
	protected double simTime;

	/**
	 * Konstruktor för State
	 */
	public State() {
		this.simStop = false;
	}

	/**
	 * Sätter simTime till vad time är.
	 * 
	 * @param time
	 */
	public void SetSimTime(double time) {
		this.simTime = time;
	}

	/**
	 * @param event
	 */
	public void notify(Event event) {

	}

	/**
	 * Returnerar nuvarande tiden.
	 *
	 * @return simTime
	 */

	public double CurrentTime() {
		return simTime;
	}

	/**
	 * Sätter stopSim till true.
	 *
	 */

	public void stopSim() {
		simStop = true;
	}

}
