package lab6.state;

import java.util.Observable;

import lab6.event.Event;

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
		this.SetSimTime(event.tid()); 
		this.setChanged();
		this.notifyObservers(event);
	}
	
	public double CurrentTime() {
		return simTime;
	}
	
	public void stopSim() {
		simStop = true;
	}
	
	

}
