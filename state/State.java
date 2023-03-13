/**
 * Albin, Khaled, Gabriel
 * */

package lab6.state;

import lab6.event.Event;
import java.util.Observable;

public class State extends Observable {
	public boolean simStop;
	protected double simTime;

	public State() {
		this.simStop = false;
	}
	
	public void SetSimTime(double time) {
		this.simTime = time;
	}
	
	public void notify(Event event) {

	}
	
	public double CurrentTime() {
		return simTime;
	}
	
	public void stopSim() {
		simStop = true;
	}

}
