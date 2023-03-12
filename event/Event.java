package lab6.event;

import lab6.state.Kunder;
import lab6.state.State;
import lab6.tools.Pair;

public abstract class Event {
	String str;
	Pair pair;
	static EventQueue eventQueue = new EventQueue();
	public Event(String str, Pair pair) {
		this.pair = pair;
		this.str = str;
	}

	public abstract void effect(State state);

	public double tid() {
		return this.pair.tid();
	}

	public Kunder kund() {
		return this.pair.kund();
	}
}