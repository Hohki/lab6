package lab6.state;

import java.security.PublicKey;
import java.util.Observable;

import lab6.event.Event;
import lab6.event.EventQueue;

public class State extends Observable {
	public boolean simStop;
	protected double simTime;
	private Event event;
	private EventQueue eventQueue = event.getEventQueue();

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


	public EventQueue eventQueue() {
		return this.eventQueue;
	}
}
