package lab6.event;

import lab6.Simulator;
import lab6.state.Kunder;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public abstract class Event {
	protected StoreState state;
	private String str;
	protected static EventQueue eventQueue = new EventQueue();
	protected double tid;
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

	public Event(String str, double tid, StoreState state) {
		this.str = str;
		this.tid = tid;
		this.state = state;
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