package lab6.event;

import lab6.state.Kunder;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public abstract class Event {
	protected StoreState state;
	private String str;
	private Pair pair;
	static EventQueue eventQueue = new EventQueue();

	public Event(StoreState state, String str, Pair pair) {
		this.state = state;
		this.pair = pair;
		this.str = str;
	}

	public Event(String str, Pair pair) {
		this.pair = pair;
		this.str = str;
	}

	public Event(StoreState state, String str) {
		this.state = state;
		this.str = str;
	}

	public Event(String str) {
		this.str = str;
	}

	public abstract void effect();

	public double tid() {
		return this.pair.tid();
	}

	public Kunder kund() {
		return this.pair.kund();
	}

	public EventQueue getEventQueue() {
		return eventQueue;
	}
}