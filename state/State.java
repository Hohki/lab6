/**
 * @author Albin
 * @author Khaled
 * @author Gabriel
 * */

package lab6.state;

import lab6.event.Event;
import java.util.Observable;

public class State extends Observable {
	public boolean simStop;
	protected double simTime;

	/**
	 * @param Inget
	 * @return Inget
	 * */
	public State() {
		this.simStop = false;
	}

	/**
	 * @param time
	 * @return Inget
	 * */
	public void SetSimTime(double time) {
		this.simTime = time;
	}

	/**
	 * @param event
	 * @return inget
	 * */
	public void notify(Event event) {

	}

	/**
	 * @param Nothing
	 * @return simTime
	 * */

	public double CurrentTime() {
		return simTime;
	}

	/**
	 * @param Nothing
	 * @return Nothing
	 * */

	public void stopSim() {
		simStop = true;
	}

}
