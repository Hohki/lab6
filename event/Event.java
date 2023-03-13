/**
 * Albin, Khaled, Gabriel
 * */

package lab6.event;

import lab6.state.Kunder;
import lab6.state.StoreState;

public abstract class Event {
	protected StoreState state;
	protected static EventQueue eventQueue = new EventQueue();
	private double tid;
	private String str;
	private Kunder kund;

	public Event(String str, double tid, Kunder kund) {
		this.str = str;
		this.tid = tid;
		this.kund = kund;
	}

	public Event(String str, double tid) {
		this.str = str;
		this.tid = tid;
	}


	public Event(String str) {
		this.str = str;
	}

	public Event(StoreState state) {
		this.state = state;
	}

	public abstract void effect();

	public void setState(StoreState state) {
		this.state = state;
	}

	public StoreState getState() {
		return this.state;
	}

	public String eventName() {
		return this.str;
	}

	public double tid() {return this.tid;}

	public Kunder kund() {
		return this.kund;
	}

	public EventQueue getEventQueue() {
		return eventQueue;
	}

	public String toString() {
		return "(" + this.str + ", " + this.tid + ")";
	}
}